package com.huhusw.middle;

/**
 * 将同行同列的石头移出
 * <p>
 * 通过证明得出，最多移出的石头数量=总数量-联通分量的数量
 * 即到最后，一个联通分量剩下一个石头
 */
public class M947 {
    /**
     * 移除同行同列的石头
     * 同横纵坐标认为是同行同列
     *
     * @param stones 石头对应的二维坐标位置
     * @return
     */
    public int removeStones(int[][] stones) {
        //边界情况
        if (stones == null || stones.length == 0) {
            return 0;
        }
        //总石头个数
        int n = stones.length;
        //新建并查集
        UF uf = new UF(n);
        //遍历所有石头
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //判断同行同列
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    uf.union(i, j);
                }
            }
        }
        //返回结果
        return n - uf.getCount();
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

        private int find(int i) {
            while (parent[i] != i) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public int getCount() {
            return n;
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
            } else {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            }
            n--;
            return false;
        }
    }
}
