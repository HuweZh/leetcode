package com.huhusw.TX;

import com.huhusw.ListNode;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(0 ^ 0);
        System.out.println(0 ^ 1);
        System.out.println(1 ^ 0);
        System.out.println(1 ^ 1);

        sc.close();

        Z01 z01 = new Z01();
        ListNode node1 = new ListNode(1);
        ListNode x = new ListNode(0);
        ListNode y = new ListNode(1);
        ListNode z= new ListNode(1);
        node1.next = x;
        x.next = y;
        y.next = z;


        ListNode node2 = new ListNode(0);
        ListNode a= new ListNode(1);
        node2.next = a;
        z01.xorList(node1, node2);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a ListNode类
     * @param b ListNode类
     * @return ListNode类
     */
    public ListNode xorList(ListNode a, ListNode b) {
        // write code here
        if (a == null && b == null) {
            return null;
        }
        ListNode node1 = reverse(a);
        ListNode node2 = b;
        ListNode dummy = new ListNode(0);
        ListNode stem = dummy;
        while (node1 != null && node2 != null) {
            stem.next = new ListNode(node1.val ^ node2.val);
            stem = stem.next;
            node1 = node1.next;
            node2 = node2.next;
        }
//        while (node1 != null) {
//            stem.next = new ListNode(node1.val ^ 0);
//            node1 = node1.next;
//            stem = stem.next;
//        }
//        while (node2 != null) {
//            stem.next = new ListNode(node2.val ^ 0);
//            stem = stem.next;
//            node2 = node2.next;
//        }
        if (node1 != null) {
            stem.next = node1;
        }
        if (node2 != null) {
            stem.next = node2;
        }
        ListNode res = reverse(dummy.next);
        while (res != null && res.val == 0) {
            res = res.next;
        }
        return res;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode stem = curr.next;
            curr.next = prev;
            prev = curr;
            curr = stem;
        }
        return prev;
    }

}
