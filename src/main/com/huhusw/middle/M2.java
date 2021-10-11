package com.huhusw.middle;

import com.huhusw.ListNode;

public class M2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head, tail;
        head = tail = null;
        //每次运算的余数
        int remainder = 0;
        //遍历两个链表
        while (l1 != null || l2 != null) {
            int sum = 0;
            //计算，判断谁是短链表
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + remainder;
            } else if (l1 == null && l2 != null) {
                sum = l2.val + remainder;
            } else if (l1 != null && l2 == null) {
                sum = l1.val + remainder;
            }
            //处理进位
            int num = sum % 10;
            remainder = sum / 10;
            if (head == null) {
                head = tail = new ListNode(num);
            } else {
                tail.next = new ListNode(num);
                //往后移动
                tail = tail.next;
            }
            //防止越界
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //处理进位
        if (remainder != 0) {
            tail.next = new ListNode(remainder);
        }
        return head;
    }
}
