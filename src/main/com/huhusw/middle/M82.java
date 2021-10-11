package com.huhusw.middle;

import com.huhusw.ListNode;

public class M82 {
    public ListNode deleteDuplicates(ListNode head) {
        //构造虚拟头节点
        ListNode res = new ListNode(0, head);
        ListNode curr = res;
        //遍历链表
        while (curr.next != null) {
            int x = 0;
            //找到相同值得节点并删除
            if (curr.next.next != null && curr.next.val == curr.next.next.val) {
                x = curr.next.val;
                while (curr.next != null && curr.next.val == x) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return res.next;
    }
}
