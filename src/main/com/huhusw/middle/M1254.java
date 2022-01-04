package com.huhusw.middle;

public class M1254 {
    /**
     * 统计岛屿的数量
     * 并查集实现，利用虚拟节点，将边缘节点相连，最后获取联通分量，减去虚拟节点
     *
     * @param grid 网格，0是地，1是水
     * @return 完全被水包围的岛屿数量
     */
    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        UF uf = new UF(grid);
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                uf.union(m * n, i * n);
            }
            if (grid[i][n - 1] == 0) {
                uf.union(m * n, i * n + n - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 0) {
                uf.union(m * n, i);
            }
            if (grid[m - 1][i] == 0) {
                uf.union(m * n, (m - 1) * n + i);
            }
        }
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dir[k][0];
                        int y = j + dir[k][1];
                        if (grid[x][y] == 0) {
                            uf.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        return uf.getCount() - 1;
    }

    /**
     * 并查集
     */
    class UF {
        private int count;
        private int[] parent;
        private int[] size;

        public UF(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[n * m + 1];
            size = new int[n * m + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        count++;
                        parent[i * n + j] = i * n + j;
                        size[i * n + j] = 1;
                    }
                }
            }
            parent[m * n] = m * n;
            size[m * n] = 1;
            count++;
        }

        public int getCount() {
            return count;
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) {
                return;
            }
            if (size[rootI] > size[rootJ]) {
                parent[rootJ] = rootI;
                size[rootI] += rootJ;
            } else {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            }
            count--;
        }

        private int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

    }
}
