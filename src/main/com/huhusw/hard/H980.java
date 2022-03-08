package com.huhusw.hard;

/**
 * https://leetcode-cn.com/problems/unique-paths-iii/
 * 不同路径3
 */
public class H980 {
    //备忘录，记录已经被访问过的点
    boolean[][] visited;

    /**
     * 计算从起点到终点的不同路径数量
     * @param grid 网格
     * @return 路径数量
     */
    public int uniquePathsIII(int[][] grid) {
        //行和列
        int m = grid.length;
        int n = grid[0].length;
        //初始化备忘录
        visited = new boolean[m][n];
        //起点和终点
        int x0 = -1;
        int y0 = -1;
        int x1 = -1;
        int y1 = -1;
        //找起点和终点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //起点
                if (grid[i][j] == 1) {
                    x0 = i;
                    y0 = j;
                }
                //终点
                if (grid[i][j] == 2) {
                    x1 = i;
                    y1 = j;
                }
            }
        }
        //深度优先搜索路径数量
        return dfs(grid, x0, y0, x1, y1);
    }

    public int dfs(int[][] grid, int x0, int y0, int x1, int y1) {
        //行和列
        int m = grid.length;
        int n = grid[0].length;
        //超越数组边界，遇到障碍，已经访问过的点，直接返回0
        if (x0 < 0 || y0 < 0 || x0 >= m || y0 >= n || grid[x0][y0] == -1 || visited[x0][y0]) {
            return 0;
        }
        //到达终点
        if (x0 == x1 && y0 == y1) {
            //是否走遍了棋盘
            if (check(grid, x1, y1)) {
                return 1;
            }
            return 0;
        }
        //更新备忘录
        visited[x0][y0] = true;
        //上下左右四个方向都尝试走一遍
        int res = dfs(grid, x0, y0 - 1, x1, y1) + dfs(grid, x0, y0 + 1, x1, y1) + dfs(grid, x0 - 1, y0, x1, y1) + dfs(grid, x0 + 1, y0, x1, y1);
        //回溯备忘录
        visited[x0][y0] = false;
        return res;
    }

    /**
     * 检查是否走完了所有的点
     * @param grid 网格
     * @param x1 终点
     * @param y1 终点
     * @return 是否覆盖所有的格子
     */
    public boolean check(int[][] grid, int x1, int y1) {
        //遍历棋盘
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //终点的备忘录是不更新的，直接跳过
                if (i == x1 && j == y1) {
                    continue;
                }
                //不是障碍但是没有访问过，说明没有访问所有的点，直接返回
                if (grid[i][j] != -1 && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
