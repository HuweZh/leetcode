package com.huhusw.hard;

import com.huhusw.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class H23 {
    public ListNode mergeKLists(ListNode[] lists) {
        //临界情况
        if (lists == null) {
            return null;
        }

        //遍历链表，保存其中的值
        ArrayList<Integer> nums = new ArrayList();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                nums.add(listNode.val);
                listNode = listNode.next;
            }
        }
        //所有的链表为空
        if (nums.size() == 0) {
            return null;
        }
        //排序所有的值
        nums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        //构造链表并返回
        ListNode res = new ListNode(nums.get(0));
        ListNode tail = res;
        for (int i = 1; i < nums.size(); i++) {
            tail.next = new ListNode(nums.get(i));
            tail = tail.next;
        }
        return res;
    }

    /***
     * 升序合并两个链表，顺序合并
     * @param a 第一个链表，升序排列
     * @param b 第二个链表，升序排列
     * @return 合并后链表的头节点
     */
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        //构造虚拟头节点
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        ListNode aHead = a;
        ListNode bHead = b;
        while (aHead != null && bHead != null) {
            if (aHead.val < bHead.val) {
                tail.next = new ListNode(aHead.val);
                aHead = aHead.next;
            } else {
                tail.next = new ListNode(bHead.val);
                bHead = bHead.next;
            }
            tail = tail.next;
        }
        tail.next = (aHead == null ? bHead : aHead);
        return newHead.next;
    }

    /***
     * 升序合并k个链表
     * @param lists k个链表，且都是升序链表
     * @return 合并后链表的头节点
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode res = null;
        for (ListNode listNode : lists) {
            res = mergeTwoLists(res, listNode);
        }
        return res;
    }

    /***
     * 升序合并k个链表，归并排序，分治的思想
     * @param lists k个链表，且都是升序链表
     * @return 合并后链表的头节点
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    /***
     * 归并排序算法的具体实现，分治的思想
     * @param lists 链表数组
     * @param left  当前排序的下界
     * @param right 当前排序的上届
     * @return 合并后的数组
     */
    private ListNode merge(ListNode[] lists, int left, int right) {
        //递归到最小单元
        if (left == right) {
            return lists[left];
        }
        //不应该出现的情况
        else if (left > right) {
            return null;
        }
        //归并排序
        int mid = (left + right) >> 1;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    /**
     * 构造Status保存链表的状态
     */
    class Status implements Comparable<Status> {
        int val;
        ListNode listNode;

        Status(int val, ListNode listNode) {
            this.val = val;
            this.listNode = listNode;
        }

        @Override
        public int compareTo(Status o) {
            return val - o.val;
        }
    }

    //优先队列，保存每个链表的斗节点
    PriorityQueue<Status> queue = new PriorityQueue<>();

    /***
     * 优先队列实现和合并k个链表
     * @param lists 需要合并的链表
     * @return 合并后的链表
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        //保存当前的链表
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(new Status(listNode.val, listNode));
            }
        }
        //构造虚拟头节点
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;

        //遍历各个链表
        while (!queue.isEmpty()) {
            //取出值最小的节点，连接到结果链表
            Status status = queue.poll();
            tail.next = status.listNode;
            tail = tail.next;
            //再把此链表的下一个节点放入优先队列
            if (status.listNode.next != null) {
                queue.offer(new Status(status.listNode.next.val, status.listNode.next));
            }

        }
        return newHead.next;
    }
}
