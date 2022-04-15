package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * 螺旋矩阵
 */
public class M59 {
    /**
     * 输入n，构造一个n方阵，元素从1到n*n，顺时针排列
     *
     * @param n 输入
     * @return 构造方阵
     */
    public int[][] generateMatrix(int n) {
        //结果
        int[][] res = new int[n][n];
        //遍历时防止重复遍历
        boolean[][] visited = new boolean[n][n];
        //计数开始
        int count = 1;
        //当前访问的位置
        int x = 0;
        int y = 0;
        //方向  0向右 1向下 2向左 3向上
        int direction = 0;
        //遍历
        while (count <= n * n) {
            //修改状态
            visited[x][y] = true;
            //赋值
            res[x][y] = count;
            //更新
            count++;
            //根据方向更新坐标
            if (direction == 0) {
                if (y == n - 1 || visited[x][y + 1]) {
                    direction = 1;
                    x = x + 1;
                } else {
                    y = y + 1;
                }
            } else if (direction == 1) {
                if (x == n - 1 || visited[x + 1][y]) {
                    direction = 2;
                    y = y - 1;
                } else {
                    x = x + 1;
                }
            } else if (direction == 2) {
                if (y == 0 || visited[x][y - 1]) {
                    direction = 3;
                    x = x - 1;
                } else {
                    y = y - 1;
                }
            } else if (direction == 3) {
                if (x == 0 || visited[x - 1][y]) {
                    direction = 0;
                    y = y + 1;
                } else {
                    x = x - 1;
                }
            }
        }
        return res;
    }
}
