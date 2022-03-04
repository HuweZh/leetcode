package com.huhusw.simple;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/last-stone-weight/
 * 最后一块石头的重量
 */
public class S1046 {
    /**
     * 计算最后一块石头的重量
     * 每次取最重的两个，然后相碰
     *
     * @param stones 石头
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        //优先队列，最大堆
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        //石头放入最大堆
        for (int i = 0; i < stones.length; i++) {
            queue.offer(stones[i]);
        }
        //循环拿出石头
        while (queue.size() > 1) {
            //拿出石头
            int a = queue.poll();
            int b = queue.poll();
            // System.out.println(a+" "+b);
            //石头相撞
            if (a != b) {
                queue.offer(Math.abs(a - b));
            }
        }
        //返回结果
        return queue.isEmpty() ? 0 : queue.peek();
    }
}
