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

    /**
     * 移出倒数第n位的节点
     *
     * @param head 头结点
     * @param n    倒数第n位
     * @return 移除后的链表
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        //虚拟一个头结点，也是返回的结果
        ListNode res = new ListNode();
        //结果链表的尾结点
        ListNode tail = res;
        //快慢指针
        ListNode fast = head;
        ListNode slow = head;
        //快指针先跑
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //快慢一起
        while (fast != null) {
            fast = fast.next;
            //并更新结果
            tail.next = slow;
            slow = slow.next;
            tail = tail.next;
        }
        //跳过删除的节点
        tail.next = slow.next;
        // System.out.println(slow.val);
        return res.next;
    }
}
