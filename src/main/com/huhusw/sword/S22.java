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

    /**
     * 双指针找到倒数第k个节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd3(ListNode head, int k) {
        //定义两个指针
        ListNode p1 = head;
        ListNode p2 = head;
        int count = 1;
        //单次遍历链表
        while (p1.next != null) {
            p1 = p1.next;
            count++;
            if (count > k) {
                p2 = p2.next;
            }
        }
        //返回慢指针
        return p2;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
