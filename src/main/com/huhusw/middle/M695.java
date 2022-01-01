package com.huhusw.middle;

/**
 * 找出地图中岛屿面积最大的值
 */
public class M695 {
    /**
     * 返回地图中岛屿面积最大的值
     *
     * @param grid 地图
     * @return 面积最大的岛屿对应的面积
     */
    public int maxAreaOfIsland(int[][] grid) {
        //边界条件
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //初始化并查集类
        UF uf = new UF(grid);
        int m = grid.length;
        int n = grid[0].length;
        //遍历地图
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //找到了岛屿
                if (grid[i][j] == 1) {
                    //修改当前的状态
                    grid[i][j] = 2;
                    //判断上下左右是否有联通的岛屿
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        uf.union(i * n + j, (i + 1) * n + j);
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        uf.union(i * n + j, (i - 1) * n + j);
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        uf.union(i * n + j, i * n + j - 1);
                    }
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        uf.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }
        //直接返回
        return uf.getMax();
    }

    /**
     * 并查集类
     * 题目要求返回岛屿面积最大的区域，其实就是节点最多的联通区域，利用一个变量保存
     */
    class UF {
        private int count;
        private int[] parent;
        private int[] size;
        //保存节点最多的岛屿
        private int max;

        /**
         * 构造函数
         *
         * @param grid 地图
         */
        public UF(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            size = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    count += grid[i][j];
                    if (grid[i][j] == 1) {
                        parent[i * n + j] = i * n + j;
                        size[i * n + j] = 1;
                        max = 1;
                    }
                }
            }
        }

        public int getMax() {
            return max;
        }

        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) {
                return true;
            }
            if (size[rootI] > size[rootJ]) {

                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
                if (size[rootI] > max) {
                    max = size[rootI];
                }
            } else {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
                if (size[rootJ] > max) {
                    max = size[rootJ];
                }
            }
            count--;
            return false;
        }

        private int find(int i) {
            while (parent[i] != i) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
    }
}
