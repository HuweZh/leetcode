package com.huhusw.sword;

import com.huhusw.ListNode;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 反转链表
 */
public class S24 {
    /**
     * 反转链表
     * 递归的逻辑是输入一个头结点，反转这个链表，所以第一次递归的情况如下
     * |1|->rever(|2|->|3|->|4|)->null
     * 递归结束时的情况如下
     * null<-|1|<-newHead
     * 递归中间的部分并不关心
     *
     * @param head 链表的头结点
     * @return 反转后的头结点
     */
    public ListNode reverseList(ListNode head) {
        //反转到最后一个节点，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        //用来接收结果
        ListNode newHead = reverseList(head.next);
        //重置指针
        head.next.next = head;
        head.next = null;
        //返回结果
        return newHead;
    }
}
