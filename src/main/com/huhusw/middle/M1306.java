package com.huhusw.middle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/jump-game-iii/
 * 跳跃游戏3
 */
public class M1306 {
    /**
     * 可以向两边跳跃，问是否能跳到元素值为0的索引
     * 广度优先搜索
     *
     * @param arr   数组
     * @param start 起始索引
     * @return 是否能满足题意
     */
    public boolean canReach(int[] arr, int start) {
        //边界条件
        if (arr[start] == 0) {
            return true;
        }
        //是否访问过此索引，放置重复访问
        boolean[] visited = new boolean[arr.length];
        //初始化
        visited[start] = true;
        //队列，实现广度优先搜索
        Queue<Integer> queue = new LinkedList<>();
        //初始化
        queue.offer(start);
        //搜索
        while (!queue.isEmpty()) {
            //弹出一个值
            int index = queue.poll();
            //向右跳，并且没有访问过
            if (index + arr[index] < arr.length && !visited[index + arr[index]]) {
                //找到了满足题意的元素
                if (arr[index + arr[index]] == 0) {
                    return true;
                }
                //加入队列，更新状态
                queue.offer(index + arr[index]);
                visited[index + arr[index]] = true;

            }
            //向左跳，且未被访问过
            if (index - arr[index] >= 0 && !visited[index - arr[index]]) {
                //找到了满足题意的元素
                if (arr[index - arr[index]] == 0) {
                    return true;
                }
                //加入队列，更新状态
                queue.offer(index - arr[index]);
                visited[index - arr[index]] = true;

            }
        }
        //没有满足题意的索引
        return false;
    }
}
