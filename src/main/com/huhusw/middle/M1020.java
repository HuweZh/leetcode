package com.huhusw.middle;

/**
 * 找到不能到达网格边界的陆地的个数
 */
public class M1020 {

    public static void main(String[] args) {
        M1020 m1020 = new M1020();
        m1020.numEnclaves(new int[][]{
                {0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0},
                {1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1},
                {1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                {0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1}
        });
    }

    /**
     * 不能通过移动到达网格边界的陆地的个数
     *
     * @param grid 网格
     * @return 陆地个数
     */
    public int numEnclaves(int[][] grid) {
        //边界条件
        if (grid == null || grid.length <= 1 || grid[0].length <= 1) {
            return 0;
        }
        //新建并查集
        UF uf = new UF(grid);
        //遍历网格
        int m = grid.length;
        int n = grid[0].length;
        //首列尾列，连接虚拟节点
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                uf.union(i * n, n * m);
            }
            if (grid[i][n - 1] == 1) {
                uf.union(i * n + n - 1, m * n);
            }
        }
        //首行尾行，连接虚拟节点
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                uf.union(j, n * m);
            }
            if (grid[m - 1][j] == 1) {
                uf.union((m - 1) * n + j, n * m);
            }
        }
        //网格的中间部分
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + direction[k][0];
                        int y = j + direction[k][1];
                        if (grid[x][y] == 1) {
                            uf.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        //返回
        return uf.getCount();
    }

    /**
     * 并查集，
     * 新建虚拟节点，连接到虚拟节点的陆地都能到达网格边界
     */
    class UF {
        private int count;
        private int countOne;
        private int[] parent;
        private int[] size;

        public UF(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            this.count = n * m + 1;
            countOne = 0;
            parent = new int[count];
            size = new int[count];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        countOne++;
                        parent[i * n + j] = i * n + j;
                        size[i * n + j] = 1;
                    }
                }
            }
            parent[n * m] = n * m;
            size[n * m] = 0;
        }

        public int getCount() {
            int rootIndex = find(count - 1);
            return countOne - size[rootIndex];
        }

        private int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
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
        }
    }
}
