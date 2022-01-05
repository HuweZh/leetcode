package com.huhusw.middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 最下生成树，并查集实现
 */
public class M1584 {
    /**
     * 对于二维坐标中的点，返回连接所有点的最小生成树值
     * 每个点之间的距离由曼哈顿距离计算
     * 贪心思想，将距离最短的点先加入生成树，持续添加符合要求的最短的点
     *
     * @param points 所有的点
     * @return 最小生成树对应的距离
     */
    public int minCostConnectPoints(int[][] points) {
        //边界条件
        if (points == null || points.length == 0) {
            return 0;
        }
        //点的个数
        int n = points.length;
        //并查集
        UF uf = new UF(n);
        //保存所有的边
        List<int[]> edges = new ArrayList<>();
        //遍历所有的点
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //两个点，以及两个点之间的距离
                edges.add(new int[]{i, j, Math.abs(points[j][0] - points[i][0]) + Math.abs(points[i][1] - points[j][1])});
            }
        }
        //按照距离升序排列，便于遍历，Lambda表达式
//        Collections.sort(edges, (a, b) -> {
//            return a[2] - b[2];
//        });
        //按照距离升序排列，便于遍历，普通写法
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        //结果
        int mst = 0;
        //遍历边
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            //新加入的边，保存这个边的权重
            if (!uf.union(u, v)) {
                mst += edge[2];
            }
        }
        return mst;
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
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
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
            return false;
        }
    }
}
