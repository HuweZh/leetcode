package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/GzCJIP/
 * 爬楼梯的最小花费
 * 每节楼梯都有花费，可以选择跳一阶还是两阶，求最小的花费
 */
public class S088 {
    /**
     * 最小花费
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        //dp数组，dp[i]表示跳到第i阶楼梯的最小花费
        int[] dp = new int[cost.length + 1];
        //可以直接跳到，不需要花费
        dp[0] = 0;
        dp[1] = 0;
        //后续楼梯需要花费
        for (int i = 2; i <= cost.length; i++) {
            //可以选择从一阶还是两阶跳过来
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        //返回结果
        return dp[cost.length];
    }

    /**
     * 滚动数组优化
     * @param cost
     * @return
     */
    public int minCostClimbingStairs2(int[] cost) {
        int dp0 = 0;
        int dp1 = 0;
        int res = 0;
        //后续楼梯需要花费
        for (int i = 2; i <= cost.length; i++) {
            //可以选择从一阶还是两阶跳过来
            res = Math.min(dp1 + cost[i - 1], dp0 + cost[i - 2]);
            dp0 = dp1;
            dp1 = res;
        }
        //返回结果
        return res;
    }
}
