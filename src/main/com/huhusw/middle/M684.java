package com.huhusw.middle;

/**
 * 一系列边构成了一个图，我们要做的是删除一条边，将图变成树
 */
public class M684 {
    /**
     * 查找出最后构成环的一条边并返回
     *
     * @param edges 边关系
     * @return 删除边
     */
    public int[] findRedundantConnection(int[][] edges) {
        //边界条件
        if (edges == null || 0 == edges.length) {
            return null;
        }
        //新建并查集类
        UF uf = new UF(edges.length + 1);
        //遍历所有的边
        for (int[] edge : edges) {
            //查到一个已经联通的边，直接返回
            if (uf.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }

    /**
     * 并查集类
     */
    class UF {
        private int n;
        private int[] parent;
        private int[] size;

        public UF(int n) {
            this.n = n;
            size = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = i;
            }
        }

        /**
         * 将合并和判断两个节点是否联通合并
         *
         * @param i 两个节点
         * @param j 两个节点
         * @return 是否联通
         */
        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            //两个节点已经联通，直接返回
            if (rootI == rootJ) {
                return true;
            }
            //不连通的节点搞联通，然后返回
            if (size[rootI] > size[rootJ]) {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
            } else {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            }
            n--;
            return false;
        }

        public int find(int i) {
            while (parent[i] != i) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
    }
}
