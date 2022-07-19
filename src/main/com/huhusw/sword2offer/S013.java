package com.huhusw.sword2offer;

/**
 * https://leetcode.cn/problems/O4NDxx/
 * 二维数组的子矩阵和
 * 可以使用一维前缀和进行线性时间优化
 * 也可以使用二维前缀和进行常数时间的优化
 */
public class S013 {
    private int[][] suma;

    public void NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        suma = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            suma[i][1] = matrix[i][0];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                suma[i][j + 1] = suma[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 > row2 || col1 > col2) {
            return 0;
        }
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            res += suma[i][col2 + 1] - suma[i][col1];
        }
        return res;
    }
}
