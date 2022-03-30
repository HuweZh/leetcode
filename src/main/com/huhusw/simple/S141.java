package com.huhusw.simple;

import com.huhusw.ListNode;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 判断链表中是否有环
 */
public class S141 {
    /**
     * 是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        //走到的空节点，证明走到了结尾，没有环
        while (!(fast == null || fast.next == null)) {
            //快慢指针
            fast = fast.next.next;
            slow = slow.next;
            //有环，快慢指针相遇
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
