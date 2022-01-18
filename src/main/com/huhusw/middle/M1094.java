package com.huhusw.middle;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/car-pooling/
 */
public class M1094 {
    /**
     * 拼车，查看是否能将所有乘客的需求满足
     *
     * @param trips    所有乘客的需求  乘客数量 上车地点 下车地点
     * @param capacity 车的容量
     * @return 是否能运送所有乘客
     */
    public boolean carPooling(int[][] trips, int capacity) {
        //上车小顶堆，按照上车地点升序排列
        Queue<int[]> up = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        //下车小顶堆，按照下车地点升序排列
        Queue<int[]> down = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        //将所有乘客存入队列
        for (int[] trip : trips) {
            up.offer(trip);
            down.offer(trip);
        }
        //遍历所有乘客
        //因为最后一个下车一定晚于最后一个上车
        //所以一定是上车队列先空
        while (!up.isEmpty()) {
            //下车地点小于等于上车地点，乘客下车，容量增加
            if (down.peek()[2] <= up.peek()[1]) {
                int[] stem = down.poll();
                capacity += stem[0];
            } else {
                //上车，容量减小
                int[] stem = up.poll();
                capacity -= stem[0];
            }
            //容量小于0时，证明不能满足需求
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
}
