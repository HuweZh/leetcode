package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/maximum-matrix-sum/
 * 最大矩阵和0
 */
public class M1975 {
    /**
     * 计算最大矩阵和
     * 你可以为两个相邻元素同时乘以负一
     * 这样就有三个推论：1.任意两个负数都能变成正数 2.任意两个数能交换正负号 3.存在0，整个方阵都变为非负
     *
     * @param matrix 矩阵
     * @return 矩阵的最大和
     */
    public long maxMatrixSum(int[][] matrix) {
        //矩阵的行和列
        int n = matrix.length;
        //结果
        long res = 0;
        //矩阵中的最小值
        int minVal = 0x7fffffff;
        //矩阵中的负数个数
        int countNeg = 0;
        //遍历矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //先全加一遍
                res += Math.abs(matrix[i][j]);
                //更新负数的个数
                if (matrix[i][j] < 0) {
                    countNeg++;
                }
                //更新最小值
                if (Math.abs(matrix[i][j]) < minVal) {
                    minVal = Math.abs(matrix[i][j]);
                }
            }
        }
        //负数为偶数个，就能全变成正数
        //负数为奇数个，将最小的变成负数即可
        return countNeg % 2 == 0 ? res : res - 2 * minVal;
    }
}
