package com.huhusw.sword;

import com.huhusw.ListNode;

public class S22 {
    //暴力顺序搜索
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = head;
        int count = 0;
        //计算链表的长度
        while (first.next != null) {
            count++;
            first = first.next;
        }
        int startIndex = count - k + 1;
        count = 0;
        //计算结果
        ListNode res = head;
        while (count != startIndex) {
            count++;
            res = res.next;
        }
        return res;
    }

    //双指针 单次循环
    public ListNode getKthFromEnd1(ListNode head, int k) {
        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
