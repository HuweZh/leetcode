package com.huhusw.middle;

import com.huhusw.ListNode;

public class M92 {


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        M92 m92 = new M92();
        ListNode listNode = m92.reverseBetween(listNode1, 2, 4);
        System.out.println("hello");
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m > n) {
            return null;
        }
        if (m == n) {
            return head;
        }
        // 将链表分成三段进行组装
        // prev和curr会首先确定tail和cont的位置，然后会处于第二段结束的位置，标识第三段
        ListNode prev = null;  // 最后遍历到第二段的结尾
        ListNode curr = head;  // 最后遍历到第三段的开始
        ListNode tail = null;  // 第一段的结尾
        ListNode cont = null;  // 第二段的开始
        while (m > 1) {
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }
        cont = curr;
        tail = prev;
        while (n > 0) {
            ListNode stem = curr.next;
            curr.next = prev;
            prev = curr;
            curr = stem;
            n--;
        }
        if(tail!=null){
            tail.next = prev;
        }else {
            head = prev;
        }
        cont.next = curr;
        return head;
    }
}
