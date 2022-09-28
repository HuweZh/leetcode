package com.huhusw.XHS;

import java.util.*;

public class Z08 {
    final static int N = 100010;
    final static int M = N << 1;
    static int n;
    static int m;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int idx = 0;
    static int[] depth = new int[N];
    static int[][] fa = new int[N][20];
    static int[] dist = new int[N];

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    static void dfs(int u, int father) {
        for (int i = h[u]; i != 0; i = ne[i]) {
            int j = e[i];
            if (j == father) continue;
            dist[j] = dist[u] + 1;
            dfs(j, u);
        }
    }

    static void bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int t = queue.poll();
            for (int i = h[t]; i != 0; i = ne[i]) {
                int j = e[i];
                if (depth[j] > depth[t] + 1) {
                    depth[j] = depth[t] + 1;
                    fa[j][0] = t;
                    for (int k = 1; k <= 19; k++) {
                        fa[j][k] = fa[fa[j][k]][k - 1];
                    }
                    queue.offer(j);
                }
            }
        }
    }

    static void init(int root) {
        Arrays.fill(depth, 0x3f3f3f3f);
        depth[0] = 0;
        depth[root] = 1;
        bfs(root);
    }

    static int lca(int x, int y) {
        if (depth[x] < depth[y]) {
            int stem = depth[x];
            depth[x] = depth[y];
            depth[y] = stem;
        }
        for (int k = 19; k >= 0; --k) {
            if (depth[fa[x][k]] >= depth[y]) {
                x = fa[x][k];
            }
        }
        if (x == y) {
            return x;
        }
        for (int k = 19; k >= 0; --k) {
            if (fa[x][k] != fa[y][k]) {
                x = fa[x][k];
                y = fa[y][k];
            }
        }
        return fa[x][0];
    }

    static int getDis(int a, int b) {
        return dist[a] + dist[b] - 2 * dist[lca(a, b)];
    }

    public static void main(String[] args) {
        ArrayList<Integer>arr = new ArrayList<>();
        arr.add(0);
        arr.add(10);
        arr.add(10);
        arr.remove(Integer.valueOf(10));
        System.out.println("asdasda");
    }
}
