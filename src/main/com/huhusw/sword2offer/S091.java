package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/JEj789/
 * 每个房子刷三种颜色，相邻不能相同颜色
 * 使用dp去计算
 */
public class S091 {
    public int minCost(int[][] costs) {
        int n = costs.length;
        //dp[i][j]表示第i个房子刷第j种颜色的最小花费
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < n; i++) {
            //只要跟前一个房子的颜色不同就行
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}
