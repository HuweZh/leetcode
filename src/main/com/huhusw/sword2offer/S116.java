package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/bLyHh0/
 * 省份数量
 * 相连的两个城市构成一个省份，求构成省份的数量
 */
public class S116 {
    /**
     * 并查集
     */
    class UF {
        int[] parent;
        int count;

        UF(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            count--;
        }

        public int get() {
            return count;
        }
    }

    /**
     * 获取省份数量，遍历相邻的城市，插入并查集
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.get();
    }
}
