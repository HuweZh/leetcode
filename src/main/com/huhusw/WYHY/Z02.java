package com.huhusw.WYHY;

import java.util.*;

public class Z02 {
    static int res = 0;
    static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static Map<String, Integer> memo;
    static Set<Integer> set;
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            n--;
            res = 0;
            memo = new HashMap<>();
            set = new HashSet<>();
            int m = sc.nextInt();
            matrix = new int[1001][1001];
            int[][] grid = new int[m][4];
            for (int i = 0; i < m; i++) {
                grid[i][0] = sc.nextInt();
                grid[i][1] = sc.nextInt();
                grid[i][2] = sc.nextInt();
                grid[i][3] = sc.nextInt();
            }
            int count = 0;
            for (int i = 0; i < m; i++) {
                int area = (grid[i][3] - grid[i][1]) * (grid[i][2] - grid[i][0]);
                boolean first = true;
                for (int j = grid[i][0]; j < grid[i][2]; j++) {
                    for (int k = grid[i][1]; k < grid[i][3]; k++) {
                        String key = j + "," + k;
                        if (memo.containsKey(key)) {
                            if (first) {
                                res += memo.get(key) + area;
                                first = false;
                            }
                            count++;
                        } else {
                            memo.put(key, area);
                        }
                    }
                }
            }
//            for (Map.Entry<Integer, Integer> entry : memo.entrySet()) {
//                int key = entry.getKey();
//                if (set.contains(key)) {
//                    continue;
//                }
//                if (entry.getValue() == 2) {
//                    dfs(key);
//                }
//            }
            System.out.println(res - count);
        }
        sc.close();
    }

//    private static void dfs(int key) {
//        res += memo.get(key);
//        set.add(key);
//        for (int k = 0; k < 4; k++) {
//            int newKey = key + dir[k][0] * 1001 + dir[k][1];
//            if (set.contains(newKey) || !memo.containsKey(newKey)) {
//                continue;
//            }
//            dfs(newKey);
//        }
//    }

}
