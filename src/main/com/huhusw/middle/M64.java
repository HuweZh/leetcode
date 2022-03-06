package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 最小路径和
 */
public class M64 {
    /**
     * 计算左上角走到右下角的最小路径和，只能向下和向右走
     * 动规
     *
     * @param grid 网格
     * @return 走到右下角的最小路径和
     */
    public int minPathSum(int[][] grid) {
        //定义dp数组，dp[i][j]表示从(0,0)走到(i,j)的最小路径和
        int[][] dp = new int[grid.length][grid[0].length];
        //初始值，要向下和向右走，所以要计算出最上面和最左面的值，防止越界
        //最上面和最左边的值都是只能向右和向下走，所以是第一行和第一列的累加值
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] += grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] += grid[0][i] + dp[0][i - 1];
        }
        // for(int i = 0; i < grid.length; i++){
        //     for(int j = 0; j < grid[0].length; j++){
        //         System.out.print(dp[i][j] + " ,");
        //     }
        //     System.out.println();
        // }
        //遍历剩余的网格，更新dp数组
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                //从向下和向右中取小值
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
