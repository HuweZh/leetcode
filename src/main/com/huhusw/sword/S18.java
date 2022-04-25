package com.huhusw.sword;

import com.huhusw.ListNode;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * 删除链表中的一个节点
 */
public class S18 {
    public ListNode deleteNode(ListNode head, int val) {
        //定义一个虚拟头结点
        ListNode newHead = new ListNode(0, head);
        //当前节点和上一个节点
        ListNode pre = newHead;
        ListNode cur = head;
        //根据当前节点判断遍历是否结束
        while (cur != null) {
            //找到值，更新
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            }
            //更新索引
            pre = cur;
            cur = cur.next;
        }
        //返回
        return newHead.next;
    }
}
