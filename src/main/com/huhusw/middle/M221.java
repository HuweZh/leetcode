package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/maximal-square/
 * 最大面积正方形
 */
public class M221 {
    /**
     * 找矩阵中的最大面积正方形
     * 面积最大对应着边长最大
     * 对于一个在矩阵中的正方形，以当前点为右下角的正方形受制于上，左，左上三个方向
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //新增上面和左边一列，为0，方便处理
        //dp[i][j]表示以matrix[i-1][j-1]为右下角的正方形的最大边长
        //其中dp的状态只与左、上、左上三个方位有关，取三个方位的最小值构成当前点的边长
        int[][] dp = new int[m + 1][n + 1];
        //结果
        int res = 0;
        //遍历矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //更新状态
                if (matrix[i][j] == '1') {
                    //上、左、左上，三个方向中的最小值作为当前点的边长
                    dp[i + 1][j + 1] = min(dp[i][j + 1], dp[i + 1][j], dp[i][j]) + 1;
                    //更新结果
                    res = Math.max(dp[i + 1][j + 1], res);
                }
            }
        }
        //返回面积
        return res * res;
    }

    /**
     * 三数最小值
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int min(int a, int b, int c) {
        return Math.min(a, b) < c ? Math.min(a, b) : c;
    }
}
