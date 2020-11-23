package com.huhusw;

/**
 * 148
 **/


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class S206 {


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        S206 s206 = new S206();
        s206.reverseList(listNode1);
        System.out.println("hello");

    }


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode listNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = listNode;
        }
        return pre;
    }
}
