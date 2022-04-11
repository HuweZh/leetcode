package com.huhusw.sword;

import com.huhusw.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 从头打印链表
 */
public class S06 {
    //队列，存储节点值
    Queue<Integer> queue = new LinkedList<>();
    //结果
    int[] res;

    /**
     * 倒叙返回链表
     * 可以用栈，正向遍历一次即可，不需要递归
     *
     * @param head 头结点
     * @return 倒叙返回链表
     */
    public int[] reversePrint(ListNode head) {
        //递归链表
        traverse(head);
        //设置结果
        res = new int[queue.size()];
        int index = 0;
        while (!queue.isEmpty()) {
            res[index++] = queue.poll();
        }
        //返回
        return res;
    }

    /**
     * 递归链表
     * @param node
     */
    public void traverse(ListNode node) {
        if (node == null) {
            return;
        }
        //前序遍历位置
        traverse(node.next);
        //后序遍历位置
        queue.offer(node.val);
    }
}
