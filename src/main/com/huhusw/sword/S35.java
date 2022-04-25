package com.huhusw.sword;

import com.huhusw.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * 复杂链表的复制
 */
public class S35 {
    //保存已经复制的节点
    Map<Node, Node> cacheMap = new HashMap<>();

    /**
     * 复杂链表的复制
     * 链表包含next和random指针
     * 在复制时，random节点可能还未创建
     * 所以需要递归回溯创建
     * 递归函数要做的事情就是返回当前节点的复制
     *
     * @param head 节点
     * @return 当前节点的复制
     */
    public Node copyRandomList(Node head) {
        //遇到空节点，直接返回
        if (head == null) {
            return null;
        }
        //当前节点还未复制，进行复制
        if (!cacheMap.containsKey(head)) {
            //创建新节点
            Node node = new Node(head.val);
            //放入映射表
            cacheMap.put(head, node);
            //递归构造next和random节点
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        //直接返回当前节点的复制
        return cacheMap.get(head);
    }
}
