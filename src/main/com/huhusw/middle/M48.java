package com.huhusw.middle;

public class M48 {
    public static void main(String[] args) {
        M48 m48 = new M48();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        m48.rotate(matrix);
        System.out.println("nihao");
    }

public void rotate(int[][] matrix) {
    int length = matrix.length;
    // 对角线反转
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < i; j++) {
//                if (i == j) continue;
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    //镜像反转
    for (int i = 0; i < length; i++) {
        for (int j = 0; j < length / 2; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][length - j - 1];
            matrix[i][length - j - 1] = temp;
        }
    }
}
}
