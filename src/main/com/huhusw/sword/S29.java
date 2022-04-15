package com.huhusw.sword;

/**
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * 顺时针打印矩阵
 */
public class S29 {

    /**
     * 按照顺时针打印矩阵
     *
     * @param matrix 矩阵
     * @return 顺时针序列
     */
    public int[] spiralOrder(int[][] matrix) {
        //边界情况
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        //记录结果的元素个数
        int count = 0;
        //矩阵的当前坐标
        int x = 0;
        int y = 0;
        //矩阵的所有元素
        int m = matrix.length;
        int n = matrix[0].length;
        //防止重复访问
        boolean[][] visited = new boolean[m][n];
        //方向，0向左 1向下 2向右 3向上
        int direction = 0;
        //结果
        int[] res = new int[m * n];
        //遍历矩阵
        while (count != m * n) {
            //设置已访问过
            visited[x][y] = true;
            //加入到数组
            res[count] = matrix[x][y];
            count++;
            //根据方向判断坐标的变化
            if (direction == 0) {
                //向右到头了，转向下
                if (y == n - 1 || visited[x][y + 1]) {
                    x = x + 1;
                    direction = 1;
                } else {
                    y = y + 1;
                }
            } else if (direction == 1) {
                //向下到头了，转向右
                if (x == m - 1 || visited[x + 1][y]) {
                    y = y - 1;
                    direction = 2;
                } else {
                    x = x + 1;
                }
            } else if (direction == 2) {
                //向右到头了，转向上
                if (y == 0 || visited[x][y - 1]) {
                    x = x - 1;
                    direction = 3;
                } else {
                    y = y - 1;
                }
            } else if (direction == 3) {
                //向上到头了，转向左
                if (x == 0 || visited[x - 1][y]) {
                    y = y + 1;
                    direction = 0;
                } else {
                    x = x - 1;
                }
            }
        }
        return res;
    }
}
