package com.huhusw.middle;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 * 最小路径和
 */
public class M120 {
    /**
     * 计算自顶向下最小路径和，可以向下和下右进行移动
     * 动规
     * 自底向上遍历会更快
     *
     * @param triangle 三角数组
     * @return 路径和
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        //计算行和列
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        //dp数组，dp[i][j]表示从(0,0)到(i,j)的最小路径和
        int[][] dp = new int[m][n];
        //初始值
        dp[0][0] = triangle.get(0).get(0);
        //遍历数组
        for (int i = 1; i < m; i++) {
            int stem = triangle.get(i).size();
            for (int j = 0; j < stem; j++) {
                //只能向下
                if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
                } else if (j == stem - 1) {
                    //只能下右
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];
                } else {
                    //取小值
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        //找到最后一行的最小值
        int min = 0x35353535;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[m - 1][i]);
        }
        return min;
    }
}
