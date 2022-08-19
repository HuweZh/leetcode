package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/0i0mDW/
 * 最小路径和
 */
public class S099 {
    /**
     * 从左上到右下的最小路径和
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //dp[i][j]表示到(i,j)的最小路径和
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //只能向右
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        //只能向左
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        //更新右下的位置
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //从两个方向中选一个小的
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
