package com.huhusw.hard;

import com.huhusw.ListNode;

import java.util.List;

public class H25 {
    /**
     * 迭代反转以head为头节点的链表
     *
     * @param head 头节点
     * @return 反转后的头节点
     */
    ListNode reverse(ListNode head) {
        //反转链表时用到的变量
        ListNode curr, prev, next;
        //当前节点的前一个节点，初始为null
        prev = null;
        //当前节点，初始为head
        curr = head;
        //当前节点的下一个节点，初始为head
        next = head;
        //反转链表
        while (curr != null) {
            //在链断裂前记录下一个节点
            next = curr.next;
            //断裂当前节点的链，并更新
            curr.next = prev;
            //更新当前节点的下一个节点和当前节点
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 反转[a,b)之间的链表
     *
     * @param a 默认为头节点
     * @param b
     * @return 反转链表后的头节点
     */
    ListNode reverseAB(ListNode a, ListNode b) {
        ListNode prev, curr, next;
        prev = null;
        curr = a;
        next = a;
        while (curr != b) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 以k个节点为一组，反转组内节点
     *
     * @param head 头节点
     * @param k    一组的数量
     * @return 反转后的链表
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a, b;
        a = b = head;
        //获取一组节点
        for (int i = 0; i < k; i++) {
            // 最后k个节点不够一组
            if (b == null) return head;
            b = b.next;
        }
        //反转a，b之间的节点
        ListNode newHead = reverseAB(a, b);
        //将链表重新连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }
}
