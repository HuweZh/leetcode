package com.huhusw.simple;

import com.huhusw.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 删除排序链表中重复的元素
 */
public class S83 {
    /**
     * 删除排序链表中的重复元素
     * 快慢指针，慢指针标识当前的不重复元素，快指针探索链表
     *
     * @param head 头结点
     * @return 删除后的链表
     */
    public ListNode deleteDuplicates(ListNode head) {
        //构造一个虚拟头结点
        ListNode newHead = new ListNode(-101, head);
        //快慢指针，分别指向虚拟头结点和头结点
        ListNode slow = newHead;
        ListNode fast = newHead.next;
        //遍历链表
        while (fast != null) {
            //当前元素重复，删除重复的元素
            if (slow.val == fast.val) {
                slow.next = fast.next;
                fast = fast.next;
                continue;
            }
            //快慢指针移动
            slow = slow.next;
            fast = fast.next;
        }
        //返回结果
        return newHead.next;
    }
}
