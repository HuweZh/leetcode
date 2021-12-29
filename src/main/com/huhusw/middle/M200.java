package com.huhusw.middle;

public class M200 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        //构建并查集
        UF uf = new UF(grid);
        int m = grid.length;
        int n = grid[0].length;
        //遍历岛屿
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //当前为陆地节点，修改其标志，防止重复遍历，然后查找周围节点是否为陆地，加到一起
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        uf.union(i * n + j, (i + 1) * n + j);
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        uf.union(i * n + j, (i - 1) * n + j);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        uf.union(i * n + j, i * n + j + 1);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        uf.union(i * n + j, i * n + j - 1);
                    }
                }
            }
        }
        return uf.getCount();
    }

    /**
     * 并查集实现
     */
    class UF {
        private int count;
        private int[] parent;
        private int[] size;

        /**
         * 传入岛屿数组，除了常规的初始化操作之外，我们只保留需要的陆地部分，海水部分不需要
         *
         * @param grid 数组
         */
        public UF(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            size = new int[m * n];
            count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        size[i * n + j] = 1;
                        count++;
                    }
                }
            }
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
                size[rootI] += size[rootJ];
            } else {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            }
            count--;
        }

        private int find(int i) {
            while (parent[i] != i) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public boolean connected(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            return rootI == rootJ ? true : false;
        }
    }
}
