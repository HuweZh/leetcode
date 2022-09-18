package com.huhusw.SD;

import com.huhusw.ListNode;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 查找单链表中间节点
     *
     * @param head ListNode类 链表头节点
     * @return int整型
     */
    public int findMidNode(ListNode head) {
        // write code here
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
        }
        return p2.val;
    }
}
