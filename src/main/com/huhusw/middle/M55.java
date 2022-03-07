package com.huhusw.middle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * 跳跃游戏，初始在索引为0的位置，可以跳不超过当前元素值的步数，是否能到达最后
 */
public class M55 {
    //备忘录
    boolean[] memo;
    boolean[] visited;

    /**
     * 递归，超时
     * 递归计算当前所在索引能否到达最后一格
     *
     * @param nums 数组
     * @return 能否达到最后一格
     */
    public boolean canJump2(int[] nums) {
        //初始化
        memo = new boolean[nums.length];
        visited = new boolean[nums.length];
        //边界条件
        if (nums.length == 1) {
            return true;
        }
        //递归，从索引为0的位置开始，步数为0
        return jump(nums, 0, 0);
    }

    /**
     * 递归计算是否能跳到最后一格
     *
     * @param nums  数组
     * @param index 当前索引
     * @param step  下一步的跳跃步数
     * @return 从当前索引能否跳到最后
     */
    public boolean jump(int[] nums, int index, int step) {
        //跳到最后
        if (index + step == nums.length - 1) {
            return true;
        }
        //跳超了
        if (index + step > nums.length - 1) {
            return false;
        }
        //跳到当前索引
        int curIndex = index + step;
        //访问过，直接返回
        if (visited[curIndex]) {
            return memo[curIndex];
        }
        //递归计算当前索引的跳跃方案
        boolean flag = false;
        for (int i = 1; i <= nums[curIndex]; i++) {
            flag |= jump(nums, curIndex, i);
        }
        //记录值，并返回
        memo[curIndex] = flag;
        visited[curIndex] = true;
        return flag;
    }

    /**
     * 队列计算跳跃游戏
     * 能跳到的索引为true，加入到队列中，再从队列中取出一个索引进行跳跃
     *
     * @param nums 数组
     * @return 能否跳到最后
     */
    public boolean canJump3(int[] nums) {
        //边界条件
        if (nums.length == 1) {
            return true;
        }
        //队列，用以存储能够跳到的格子
        Queue<Integer> queue = new LinkedList<>();
        //数组，记录是否访问过此格子，为了防止重复访问造成重复计算
        boolean[] visited = new boolean[nums.length];
        //初始值
        queue.offer(0);
        visited[0] = true;
        //计算是否能访问到最后一格
        while (!queue.isEmpty()) {
            //取出一个能够够着的索引
            int index = queue.poll();
            //从此索引开始跳跃
            for (int i = 1; i <= nums[index]; i++) {
                //直接跳到最后，返回
                if (index + i == nums.length - 1) {
                    return true;
                }
                //跳不到最后，且跳的格子当前未被访问，记录此格子，加入队列
                else if (index + i < nums.length - 1 && !visited[index + i]) {
                    visited[index + i] = true;
                    queue.offer(index + i);
                }
            }
        }
        //最后还没有到达目标点
        return false;
    }

    /**
     * 贪心
     * 其中一个位置能跳的最远距离大于等于数组长度即可
     * 所以维护一个最远的跳跃距离，在最远跳跃距离内的格子都能跳，借此更新最远距离
     *
     * @param nums 数组
     * @return 能否跳到最后一个格子
     */
    public boolean canJump(int[] nums) {
        //边界条件
        if (nums.length == 1) {
            return true;
        }
        //最远距离
        int max = 0;
        //遍历数组元素
        for (int i = 0; i < nums.length; i++) {
            //最远距离内的格子都能跳到
            if (i <= max) {
                //更新最远距离
                max = Math.max(max, i + nums[i]);
                //能调到最后
                if (max >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
