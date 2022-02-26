package com.huhusw.middle;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-falling-path-sum/
 */
public class M931 {
    //备忘录
    int[][] memo;

    /**
     * 最小下沉路径，动态规划
     *
     * @param matrix 矩阵
     * @return 最小路径和
     */
    public int minFallingPathSum(int[][] matrix) {
        //初始化备忘录为一个不在题目数值范围内的数
        memo = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(memo[i], 33333);
        }
        //结果变量初始化为一个比较大的数
        int res = 33333;
        //遍历最后一行，进行结果的更新
        for (int j = 0; j < matrix.length; j++) {
            res = Math.min(res, dp(matrix, matrix.length - 1, j));
        }
        return res;
    }

    /**
     * 该函数计算从当前位置(i,j)出发，最小路径和
     * 根据主函数的遍历次序，我们是由下向上遍历
     *
     * @param matrix 矩阵
     * @param i      当前位置
     * @param j      当前位置
     * @return 最小路径和
     */
    int dp(int[][] matrix, int i, int j) {
        //边界条件
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix.length) {
            return 44444;
        }
        //递归到第一行，停止递归，直接返回0
        if (i == 0) {
            return matrix[0][j];
        }
        //备忘录中的值已经被改变，说明该路径被计算过，防止重复计算
        if (memo[i][j] != 33333) {
            return memo[i][j];
        }
        //更新备忘录
        //备忘录的值是由当前位置的值，加上三条可能路径值的最小值
        memo[i][j] = matrix[i][j] + min(dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j), dp(matrix, i - 1, j + 1));
        //返回结果
        return memo[i][j];
    }

    /**
     * 求三个值中的最小值
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
