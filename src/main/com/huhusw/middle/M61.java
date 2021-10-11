package com.huhusw.middle;

import com.huhusw.ListNode;

public class M61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        //统计链表节点的个数
        int count = 1;
        ListNode tail = head;
        while (tail.next != null) {
            count++;
            tail = tail.next;
        }
        //链表组成环
        tail.next = head;
        //获取最后一个节点的位置
        int num = count - (k % count);
        //找到断裂的位置
        while (num-- > 0) {
            tail = tail.next;
        }
        //断裂链表
        ListNode newHead = tail.next;
        tail.next = null;
        return newHead;
    }
}
