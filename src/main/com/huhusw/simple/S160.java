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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
