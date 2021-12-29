package com.huhusw.middle;

/**
 * 给定矩阵，被X堵死的O被替换为X
 * 边缘的O没有被堵死，而且能帮助它相邻的O不被堵死
 * <p>
 * 可以使用深度优先，查找出所有的O
 * <p>
 * 这里使用并查集，虚拟出一个公共节点，作为所有边缘的节点的祖先节点
 * 然后遍历中间的节点，判断是否相连，
 * 最终只要不跟虚拟节点相连，都是被堵死的节点
 */
public class M130 {
    /**
     * 将堵死的O节点改成X
     *
     * @param board 矩阵
     */
    public void solve(char[][] board) {
        //边界情况
        if (board.length == 0) return;
        //得到矩阵的长宽
        int m = board.length;
        int n = board[0].length;
        //除了矩阵节点，还需要虚拟一个公共祖先，公共祖先为n*m
        UF uf = new UF(n * m + 1);
        //探索首行，尾行
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                uf.union(i, n * m);
            }
            if (board[m - 1][i] == 'O') {
                uf.union((m - 1) * n + i, n * m);
            }
        }
        //探索首列，尾列
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                uf.union(i * n, n * m);
            }
            if (board[i][n - 1] == 'O') {
                uf.union(i * n + n - 1, n * m);
            }
        }
        //四个方向，移动节点
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //矩阵中间的地方进行判断
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                //当前节点为O
                if (board[i][j] == 'O') {
                    //跟其周围的O相连起来
                    for (int k = 0; k < 4; k++) {
                        int x = i + direction[k][0];
                        int y = j + direction[k][1];
                        if (board[x][y] == 'O') {
                            uf.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        //遍历矩阵，没有跟n*m相连的就是被堵死的节点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!uf.connected(i * n + j, n * m)) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    /**
     * 并查集实现
     */
    class UF {
        //图中所有的联通分量
        private int n;
        //每个树的父节点，保证一定存在，单个节点的父节点是自己
        private int[] parent;
        //每棵树的”重量“，初略表示树的复杂程度，合并时，简单的树合并到复杂的树上
        private int[] size;

        /**
         * 构造函数
         *
         * @param n 图中节点个数
         */
        public UF(int n) {
            //初始化变量，所有节点都不连通
            this.n = n;
            parent = new int[n];
            size = new int[n];
            //初始化父节点和重量
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        /**
         * 联通两个节点的API
         *
         * @param i 两个节点
         * @param j 两个节点
         */
        public void union(int i, int j) {
            //找到两个节点的祖先节点
            int rootI = find(i);
            int rootJ = find(j);
            //已经联通，不需要管
            if (rootI == rootJ) {
                return;
            }
            //小树往大树身上合并
            if (size[rootI] > size[rootJ]) {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
            } else {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            }
            //联通分量更新
            n--;
        }

        /**
         * 判断两个节点是否相连
         *
         * @param i 两个节点
         * @param j 两个节点
         * @return 是否相连
         */
        public boolean connected(int i, int j) {
            //找到两个节点的祖先节点
            int rootI = find(i);
            int rootJ = find(j);
            //判断是否为同一个父节点
            return rootI == rootJ ? true : false;
        }

        /**
         * 查找一个节点的父节点
         *
         * @param i 当前节点
         * @return 当前节点的祖先节点
         */
        private int find(int i) {
            //循环查找
            while (parent[i] != i) {
                //路径压缩，将较长的树压缩到可控的常数级别的深度
                parent[i] = parent[parent[i]];
                //向下遍历
                i = parent[i];
            }
            //返回
            return i;
        }
    }
}
