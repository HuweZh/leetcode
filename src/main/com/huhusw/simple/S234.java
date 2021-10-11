package com.huhusw.simple;

import com.huhusw.ListNode;

public class S234 {
    //二叉树可以使用数组和链表实现，二叉树可以进行前中后遍历，对应的链表也能有两种遍历方式
//链表具有递归的属性，具有前序遍历和后续遍历的能力
    void traverse(ListNode head) {
        //前序遍历，就是正向遍历，在这里完成
        //递归
        traverse(head.next);
        //后序遍历，就是倒着遍历，在这里完成
    }

    //利用链表的前后遍历属性，对于回文链表的判断就方便了一点
    //标记头节点
    ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverseListNode(head);
    }

    private boolean traverseListNode(ListNode right) {
        //前序遍历
        //遍历到链表的末尾
        if (right == null) {
            return true;
        }
        //递归
        //只要有一次res=false，以后的结果都是res
        boolean res = traverseListNode(right.next);
        //后续遍历的阶段
        res = res && (right.val == left.val);
        //比较下一个节点，跟递归栈同步，也就是链表会遍历一次
        left = left.next;
        return res;
    }

    //判断是否为回文链表
    //1.利用快慢指针定位到链表的后半段
    //2.将后半段的链表反转
    //3.挨个比较前半段和后半段
    //4.恢复原链表
    public boolean isPalindrome1(ListNode head) {
        //1.定位后半段
        ListNode midNode = getMidNode(head);
        //2.反转后半段
        ListNode tail = reverse(midNode);
        //3.比较链表
        boolean res = true;
        //保存临时变量
        ListNode left = head;
        ListNode right = tail;
        while (right != null) {
            if (left.val != right.val) {
                res = false;
                break;
            }
            //往后遍历
            left = left.next;
            right = right.next;
        }
        //4.恢复原链表
//        //找到中点节点的前一个节点
//        while (left.next != midNode) {
//            left = left.next;
//        }
//        //恢复中点节点后面的被反转链表,并赋值
//        left.next = reverse(tail);
        return res;
    }

    /**
     * 反转以head开头的链表
     *
     * @param head 头节点
     * @return 反转链表后的头节点
     */
    private ListNode reverse(ListNode head) {
        ListNode prev, curr, next;
        prev = null;
        curr = next = head;
        while (next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

/**
 * 确定链表的中间节点
 *
 * @param head 头节点
 * @return 中间节点
 */
//双指针确定中间节点
private ListNode getMidNode(ListNode head) {
    //定义快慢指针
    ListNode slow, fast;
    slow = fast = head;
    //因为链表长度有奇数和偶数，所以会有两种情况，任意一个满足跳出循环
    while (fast != null && fast.next != null) {
        //快指针移动是慢指针的两倍，慢指针指向中点
        slow = slow.next;
        fast = fast.next.next;
    }
    //长度为奇数的情况，判断回文的时候，奇数中间的节点是不需要判断的
    if (fast != null) {
        slow = slow.next;
    }
    return slow;
}
}
