package com.huhusw.middle;

import com.huhusw.ListNode;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/linked-list-random-node/
 * 随机返回链表中的一个值
 * 池塘抽样
 */
public class M382 {
    //链表
    ListNode head;
    //随机数
    Random random;

    /**
     * 初始化
     *
     * @param head
     */
    public M382(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /**
     * 池塘抽样
     * 保证所有节点被返回的概率相等
     *
     * @return
     */
    public int getRandom() {
        //计数
        int count = 0;
        //遍历链表
        ListNode newHead = head;
        //结果
        int res = -1;
        //遍历链表
        while (newHead != null) {
            //计数更新
            count++;
            //更新结果
            //每次以[0,count)的概率更新结果
            if (random.nextInt(count) == 0) {
                res = newHead.val;
            }
            newHead = newHead.next;
        }
        return res;
    }
}
