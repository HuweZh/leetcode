package com.huhusw.middle;

import com.huhusw.ListNode;
import sun.applet.Main;

public class M19 {
    public static void main(String[] args) {
        M19 m19 = new M19();
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode head = new ListNode(1, new ListNode(2));
        m19.removeNthFromEnd(head, 1);
    }

    int count = -1;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        //人为构造一个头节点，为了防止头节点越界
        ListNode newHead = new ListNode(0, head);
        //从头节点和头节点的下一个节点开始递归
        //头节点
        ListNode prev = null;
        //当前节点
        ListNode curr = newHead;
        removeNthFromEnd0(prev, curr, n);
        return newHead.next;
    }

    /**
     * 删除倒数第n个节点
     *
     * @param prev 当前节点的上一个节点
     * @param curr 遍历的当前节点
     * @param n    删除的第n个节点
     */
    private void removeNthFromEnd0(ListNode prev, ListNode curr, int n) {
        //前序遍历

        //遍历到末尾，开始弹栈
        if (curr == null) {
            return;
        }
        //往后遍历
        prev = curr;
        curr = curr.next;

        //递归压栈
        removeNthFromEnd0(prev, curr, n);
        //后序遍历
        count++;
        //找到了倒数第n个元素
        if (count == n) {
            prev.next = prev.next.next;
        }
    }
}
