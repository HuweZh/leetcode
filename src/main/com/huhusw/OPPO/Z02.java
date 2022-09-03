package com.huhusw.OPPO;

import com.huhusw.ListNode;
import sun.reflect.generics.tree.ClassSignature;

import java.util.*;

public class Z02 {
    public static void main(String[] args) {
        Z02 z02 = new Z02();
        ListNode node1 = new ListNode(3);
        node1.next = new ListNode(1);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(2);
        z02.combineTwoDisorderNodeToOrder(node1, node2);
    }

    public ListNode combineTwoDisorderNodeToOrder(ListNode node1, ListNode node2) {
        // write code here
        ListNode res = new ListNode(0);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (node1 != null) {
            queue.add(node1.val);
            node1 = node1.next;
        }
        while (node2 != null) {
            queue.add(node2.val);
            node2 = node2.next;
        }
        ListNode ss = res;
        while (!queue.isEmpty()) {
            ListNode stem = new ListNode(queue.poll());
            ss.next = stem;
            ss = ss.next;
        }
        return res.next;
    }
}
