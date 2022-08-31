package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/7LpjUW/
 * 多余的边
 * 树中多了一条边，导致构成了环，请找出这条边
 * 返回边集合的最后一个构成环的边
 */
public class S118 {
    /**
     * 找出构成环的边
     * 并查集
     *
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        //并查集
        UF uf = new UF(n);
        //遍历边集合
        for (int[] edge : edges) {
            //如果两个节点的祖先不一样，说明不是联通的，将其联通
            //但是祖先一样的话代表着，再加入这条边就会构成环，这就是我们要找的边
            if (uf.find(edge[0] - 1) != uf.find(edge[1] - 1)) {
                uf.union(edge[0] - 1, edge[1] - 1);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    class UF {
        int[] parent;
        int n;

        UF(int n) {
            this.n = n;
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
            parent[rootY] = rootX;
            n--;
        }
    }
}
