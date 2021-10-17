package com.huhusw.middle;

import com.huhusw.Node;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class M117 {
    Queue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
        @Override
        public int compare(Character o1, Character o2) {
            return
        }
    })
    //下一层的节点
    Node next = null;
    //下一层的起始节点
    Node nextStart = null;

    public Node connect(Node root) {
        //边界条件
        if (root == null) {
            return null;
        }
        //初始化，第一层只有一个节点，直接构造下一层的状态
        Node start = root;
        while (start != null) {
            //构造之前初始化
            next = null;
            nextStart = null;
            //遍历当前层，并构造下一层
            for (Node i = start; i != null; i = i.next) {
                if (i.left != null) {
                    deal(i.left);
                }
                if (i.right != null) {
                    deal(i.right);
                }
            }
            //遍历树的所有层
            start = nextStart;
        }
        return root;
    }

    /**
     * 构建下一层的节点
     *
     * @param node
     */
    private void deal(Node node) {
        //依次处理下一层的每一个节点
        if (next != null) {
            next.next = node;
        }
        //下一层的起始节点
        if (nextStart == null) {
            nextStart = node;
        }
        //更新节点的状态
        next = node;
    }

    /**
     * 使用层次遍历完成题目要求
     *
     * @param root
     * @return
     */
    public Node connect1(Node root) {
        //边界条件
        if (root == null) {
            return null;
        }
        //每一层的起始节点
        Node start = null;
        //用于层次遍历的队列
        Queue<Node> queue = new LinkedList<>();
        //初始加入根节点
        queue.add(root);
        //遍历
        while (!queue.isEmpty()) {
            int count = queue.size();
            //每次循环一层节点，循环之前初始化每一层的起始节点
            start = null;
            for (int i = 0; i < count; i++) {
                Node node = queue.poll();
                //加入下一层节点
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                //将这一层的节点连接起来
                if (i != 0) {
                    start.next = node;
                }
                start = node;
            }
        }
        return root;
    }
}
