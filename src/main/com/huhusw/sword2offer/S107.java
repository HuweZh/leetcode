package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/2bCMpM/
 * 矩阵中的距离，求出所有1到最近0的距离
 */
public class S107 {
    public static void main(String[] args) {
        S107 s107 = new S107();
        s107.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
    }

    /**
     * 从1开始广度遍历，需要考虑的情况太多，而且超时，这不是一个好办法
     * 转换思路，从终点遍历，遍历到的地方进行步数的计算即可，情况简单，不需要额外的判断
     *
     * @param mat
     * @return
     */
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        //距离矩阵
        int[][] res = new int[m][n];
        //方向
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        //防止重复遍历
        boolean[][] visited = new boolean[m][n];
        //队列，转入所有的终点
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //遇见终点
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    res[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }
        //bfs
        while (!queue.isEmpty()) {
            int[] stem = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newI = stem[0] + dir[i][0];
                int newJ = stem[1] + dir[i][1];
                //更新矩阵
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visited[newI][newJ]) {
                    visited[newI][newJ] = true;
                    res[newI][newJ] = res[stem[0]][stem[1]] + 1;
                    queue.offer(new int[]{newI, newJ});
                }
            }
        }
        return res;
    }
}
