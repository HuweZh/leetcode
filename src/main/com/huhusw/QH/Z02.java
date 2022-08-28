package com.huhusw.QH;

import java.util.*;

public class Z02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] info = new int[m][3];
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < m; i++) {
                info[i][j] = sc.nextInt();
            }
        }
        sc.close();

        UF uf = new UF(n);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        for (int[] stem : info) {
            queue.offer(stem);
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int[] stem = queue.poll();
            if (uf.union(stem[0] - 1, stem[1] - 1)) {
                res += stem[2];
            }
        }
        System.out.println(res);
    }

    static class UF {
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

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            parent[rootY] = rootX;
            return true;
        }
    }
}
