package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * 路径方案2
 */
public class M63 {
    /**
     * 计算从左上角到右下角所有的路径方案
     * 网格中有障碍物，需要绕行
     * @param obstacleGrid 网格
     * @return 方案数
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //网格的行和列
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //dp数组,dp[i][j]表示(0,0)到(i,j)的路径方案数
        int[][] dp = new int[m][n];
        //首列，遇到障碍物，下面的网格一定去不了
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        //首行，遇到障碍物，右边的网格一定去不了
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        //遍历网格
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //遇到障碍物，跳过
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                //更新数组，障碍物所在的dp为0，可以直接加
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        //返回结果
        return dp[m - 1][n - 1];
    }
}
