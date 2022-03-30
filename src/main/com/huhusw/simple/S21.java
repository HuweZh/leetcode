package com.huhusw.simple;

import com.huhusw.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 合并两个有序链表
 */
public class S21 {
    /**
     * @param list1 链表
     * @param list2 链表
     * @return 合并后的有序链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //新建虚拟头结点和尾结点
        ListNode head = new ListNode();
        ListNode tail = head;
        //遍历两个链表
        while (list1 != null || list2 != null) {
            //其中一个链表为空，直接将另一个链表加到结果上
            if (list1 == null) {
                while (list2 != null) {
                    tail.next = list2;
                    list2 = list2.next;
                    tail = tail.next;
                }
                break;
            }
            if (list2 == null) {
                while (list1 != null) {
                    tail.next = list1;
                    list1 = list1.next;
                    tail = tail.next;
                }
                break;
            }
            //比较大小，小的先加到链表上
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        //返回虚拟节点的下一个节点
        return head.next;
    }

    /**
     * 优化版
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        //循环一遍以后，将不为空的链表的剩余部分拼到后面，不需要遍历
        if (list1 == null) {
            tail.next = list2;
        }
        if (list2 == null) {
            tail.next = list1;
        }
        return head.next;
    }
}
