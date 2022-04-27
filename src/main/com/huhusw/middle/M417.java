package com.huhusw.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 * 太平洋大西洋水流问题
 */
public class M417 {
    /**
     * 题目要求的是一块陆地上的水能向两个海洋流去
     * 对于每一块陆地来说都要判断是否能流到海洋里
     * 比较简单的思路是递归回溯，判断是否能到海洋
     * 对于每一块地都递归回溯的话，逻辑判断比较复杂，而且复杂度较高
     * 所以逆向思维，从紧挨着海洋的边界陆地往中心找
     * 每一块能到达的陆地进行标记，最终汇总标记即可完成是否能到达两个海洋的任务
     */
    //陆地的长宽
    int m, n;
    //陆地
    int[][] heights;
    //方向，每一块陆地都能向上下左右进行移动
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * 找到所有能流向两个海洋的陆地索引
     *
     * @param heights 陆地
     * @return 所有满足题意的陆地
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //赋值
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        //定义两个数组，标记是否能到达陆地
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        //上边界，挨着pacific
        for (int i = 0; i < n; i++) {
            dfs(0, i, pacific);
        }
        //左边界，挨着pacific
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }
        //下边界，挨着atlantic
        for (int i = 0; i < n; i++) {
            dfs(m - 1, i, atlantic);
        }
        //右边界，挨着atlantic
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);
        }
        //遍历两个标志数组，构造结果
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> stem = new ArrayList<Integer>(2);
                    stem.add(i);
                    stem.add(j);
                    res.add(stem);
                }
            }
        }
        //返回结果
        return res;
    }

    /**
     * 递归回溯，找到能到达的陆地
     *
     * @param x     横坐标
     * @param y     纵坐标
     * @param ocean 海洋的标志位
     */
    public void dfs(int x, int y, boolean[][] ocean) {
        //回溯过程中会有多次访问到已经访问过的节点
        //提前结束回溯过程
        if (ocean[x][y]) {
            return;
        }
        //能进递归回溯的函数，已经被判断过能到达，直接修改
        ocean[x][y] = true;
        //遍历四个方向
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            //判断能否进行回溯，这里相当于一个剪枝的过程
            if (newX >= 0 && newY >= 0 && newX < m && newY < n && heights[newX][newY] >= heights[x][y]) {
                dfs(newX, newY, ocean);
            }
        }
    }
}
