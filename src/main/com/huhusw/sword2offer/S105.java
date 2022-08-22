package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/ZL6zAn/
 * 岛屿的最大面积
 */
public class S105 {
    //并查集记录岛屿，并记录面积
    class UF {
        int n;
        int[] parent;
        int[] size;
        int max;

        UF(int n) {
            this.n = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            max = 0;
        }

        public int find(int index) {
            while (parent[index] != index) {
                parent[index] = parent[parent[index]];
                index = parent[index];
            }
            return index;
        }

        public void union(int x, int y, int flag) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
                if (flag == 1) {
                    max = Math.max(size[rootY], max);
                }
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                if (flag == 1) {
                    max = Math.max(size[rootX], max);
                }
            }
            n--;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int x) {
            max = Math.max(x, max);
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int n = grid.length;
        int m = grid[0].length;
        UF uf = new UF(m * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                uf.setMax(grid[i][j]);
                for (int k = 0; k < 4; k++) {
                    int newI = i + dir[k][0];
                    int newJ = j + dir[k][1];
                    if (newI < 0 || newI >= n || newJ < 0 || newJ >= m) {
                        continue;
                    }
                    if (grid[i][j] == grid[newI][newJ]) {
                        uf.union(i * m + j, newI * m + newJ, grid[i][j]);
                    }
                }
            }
        }
        return uf.getMax();
    }

    /**
     * 深度优先搜索获取岛屿面积
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        int res = 1;
        //将搜索过的岛屿变成海洋，放置重复搜索，也防止在主循环中重复计算
        grid[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            res += dfs(grid, i + dir[k][0], j + dir[k][1]);
        }
        return res;
    }
}
