package com.huhusw.middle;

import com.huhusw.Node;

import java.util.HashMap;
import java.util.Map;

public class M138 {
    //保存拷贝过的节点
    Map<Node, Node> cache = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //未创建过当前节点
        if (!cache.containsKey(head)) {
            //创建节点并添加到已创建表中
            Node newNode = new Node(head.val);
            cache.put(head,newNode);
            //递归拷贝当前节点的下一个和随机
            newNode.next = copyRandomList(head.next);
//            newNode.random = copyRandomList(head.random);
        }
        return cache.get(head);
    }
}
