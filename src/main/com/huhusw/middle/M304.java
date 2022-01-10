package com.huhusw.middle;

public class M304 {
    /**
     * 实现二维数组的API，给定两个坐标，返回其中所有元素的和
     */
    class NumMatrix {
        //二维数组的前缀和
        //preSum[i][j]表示从原点(0,0)到坐标(i,j)的元素和
        private int[][] preSum;

        /**
         * 构造函数
         *
         * @param matrix 二维数组
         */
        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            //初始化前缀和
            preSum = new int[m + 1][n + 1];
            //赋值
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
                }
            }
        }

        /**
         * 计算两个坐标中的元素和
         * 都从原点出发，所求部分就是大矩形剪去两个小矩形加上一个小矩形
         *
         * @param row1 两个坐标
         * @param col1 两个坐标
         * @param row2 两个坐标
         * @param col2 两个坐标
         * @return 两个坐标之间的元素和
         */
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
        }
    }

}
