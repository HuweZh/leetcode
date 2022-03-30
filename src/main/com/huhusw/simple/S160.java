package com.huhusw.simple;

import com.huhusw.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author huhusw
 * @Description
 * @create 2021-06-04 14:37
 */
public class S160 {
    /**
     * 找到两个链表的相交部分
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //定义一个集合，存放已经访问过的节点
        Set<ListNode> visited = new HashSet<>();
        ListNode temp = headA;
        //将A加入集合
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        //遍历B
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * 双指针得到链表的相交部分
     * 将A和B拼接一起，进行遍历，双指针相等的部分就是相交的部分
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //两个指针
        ListNode p1 = headA;
        ListNode p2 = headB;
        //遍历链表
        while (!(p1 == null && p2 == null)) {
            if (p1 == p2) {
                return p1;
            }
            //p1遍历完一个链表，转而去遍历另一个链表，逻辑上拼接在一起
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            ////p1遍历完一个链表，转而去遍历另一个链表，逻辑上拼接在一起
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }

        }
        return null;
    }
}
