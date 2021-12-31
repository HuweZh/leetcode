package com.huhusw.middle;

/**
 * 统计地图中出现的地区数量
 */
public class M547 {
    /**
     * 给定一个相连关系图，判断这个地区中不同地区的数量
     *
     * @param isConnected 地区关系图，isConnected[i][j]=1代表i和j相连，是同一个地区
     * @return 返回地区的数量
     */
    public int findCircleNum(int[][] isConnected) {
        //边界条件
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        //创建并查集
        UF uf = new UF(isConnected.length);
        //遍历地图确定地区相连的情况
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected.length; j++) {
                //将两个地区连起来
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        //返回最后不相连的地区数量
        return uf.getCount();
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
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int getCount() {
            return n;
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
                size[rootJ] += rootI;
            }
            n--;
        }

        public int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
    }
}
