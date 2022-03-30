package com.huhusw.simple;

import com.huhusw.ListNode;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 链表的中间节点
 */
public class S876 {
    /**
     * @param head 链表的头节点
     * @return 链表的中间节点
     */
    public ListNode middleNode(ListNode head) {
        //虚拟一个头结点
        ListNode newHead = new ListNode(0, head);
        //快慢指针从虚拟节点开始
        ListNode fast = newHead;
        ListNode slow = newHead;
        //遍历链表，快指针走两次，慢指针走一次
        while (true) {
            //快指针要判断是否走到头
            fast = fast.next;
            if (fast == null) {
                slow = slow.next;
                break;
            }
            fast = fast.next;
            if (fast == null) {
                slow = slow.next;
                break;
            }
            slow = slow.next;
        }
        //返回慢指针
        return slow;
    }
}
