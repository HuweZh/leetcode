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
        if (tail != null) {
            tail.next = prev;
        } else {
            head = prev;
        }
        cont.next = curr;
        return head;
    }

    /**
     * 反转以head为头节点的链表
     *
     * @param head 头节点
     * @return 反转后链表的头节点
     */
    ListNode reverse(ListNode head) {
        //跳出递归
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);

        //设置反转，假设head后面的链表已经全部反转，这里修改最后一个节点的反转指向
        head.next.next = head;
        //设置尾节点的下一个为null
        head.next = null;
        return last;
    }

    /**
     * 反转以head为头节点的前n个节点
     *
     * @param head 头节点
     * @param n    前n个节点
     * @return 返回反转后链表的头节点
     */
    //后驱节点，即第n+1个节点
    ListNode nextNode = null;

    ListNode reverseN(ListNode head, int n) {
        //最后一次递归
        if (n == 1) {
            //记录第n+1个节点
            nextNode = head.next;
            return head;
        }
        //开始递归
        ListNode last = reverseN(head.next, n - 1);
        //反转前n个节点
        head.next.next = head;
        //最后一次指向后驱节点
        head.next = nextNode;
        return last;
    }

    ListNode reverseBetween1(ListNode head, int m, int n) {
        //相当于直接反转当前链表的前n-m个元素
        if (m == 1) {
            return reverseN(head, n);
        }
        //往后移动，直到触发反转前n个函数的条件
        head.next = reverseBetween1(head.next, m - 1, n - 1);
        return head;
    }
}
