package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/2AoeFn/
 * 路径数目
 */
public class S098 {
    /**
     * 从左上走到右下的方案数，只能向下和向右
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        //dp[i][j]表示走到(i,j)的方案数
        int[][] dp = new int[m][n];
        //向右
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        //向下
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
