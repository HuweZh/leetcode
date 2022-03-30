package com.huhusw;

/**
 * @author huhusw
 * @Description
 * @create 2021-04-26 13:08
 */
public class ListNode {
    public int val;
    public ListNode next;

    //    ListNode(int x) {
//        val = x;
//    }
    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
