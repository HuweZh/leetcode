package com.huhusw.sword;

import com.huhusw.ListNode;

/**
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * 合并两个有序链表
 */
public class S25 {
    /**
     * 合并两个有序链表
     *
     * @param l1 链表
     * @param l2 链表
     * @return 输出有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //新建链表存储结果，虚拟一个头结点
        ListNode newHead = new ListNode(0);
        ListNode res = newHead;
        //循环遍历两个链表
        while (true) {
            //第一个链表为空，直接将第二个链表接上
            if (l1 == null) {
                res.next = l2;
                break;
            }
            //第二个链表为空，直接将第一个链表接上
            if (l2 == null) {
                res.next = l1;
                break;
            }
            //判断大小，往后遍历
            if (l1.val < l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        //返回结果
        return newHead.next;
    }
}
