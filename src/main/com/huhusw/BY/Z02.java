package com.huhusw.BY;

import java.util.*;

public class Z02 {
    static Set<Integer> memo = new HashSet<>();
    static int n;
    static int m;
    static int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static Map<Integer, int[]> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        n = Integer.parseInt(nums[0]);
        m = Integer.parseInt(nums[1]);
        String[] grid = new String[n];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine();
        }
        sc.close();
        calWord(grid);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean[][] visited = new boolean[n][m];
                if (dfs(grid, i, j, visited)) {
                    memo.add(i * m + j);
                }
            }
        }
        System.out.println(m * n - memo.size());
    }

    private static void calWord(String[] grid) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //传送带
                if (grid[i].charAt(j) != '.' && grid[i].charAt(j) != 'O') {
                    int key = i * m + j;
                    int stemI = i;
                    int stemJ = j;
                    switch (grid[i].charAt(j)) {
                        case 'U':
                            stemI += 1;
                            break;
                        case 'D':
                            stemI -= 1;
                            break;
                        case 'L':
                            stemJ += 1;
                            break;
                        case 'R':
                            stemJ -= 1;
                            break;
                    }
                    //撞墙
                    if (stemI < 0 || stemI >= n || stemJ < 0 || stemJ >= m) {
                        map.put(key, null);
                    } else {
                        //没有撞墙
                        map.put(key, new int[]{stemI, stemJ});
                    }
                }
            }
        }
    }

    private static boolean dfs(String[] grid, int i, int j, boolean[][] visited) {
        if (memo.contains(i * m + j)) {
            return true;
        }
        if (grid[i].charAt(j) == 'O') {
            return true;
        }
        int key = i * m + j;
        int[] stem = new int[]{i, j};
        Set<Integer> stemSet = new HashSet<>();
        stemSet.add(key);
        while (map.containsKey(key)) {
            stem = map.get(key);
            //撞墙
            if (stem == null) {
                return false;
            }
            key = stem[0] * m + stem[1];
            //出现环
            if (stemSet.contains(key)) {
                return false;
            }
        }
        visited[stem[0]][stem[1]] = true;
        boolean res = false;
        for (int k = 0; k < 4; k++) {
            int newI = stem[0] + dir[k][0];
            int newJ = stem[1] + dir[k][0];
            if (newI < 0 || newI >= n || newJ < 0 || newJ >= m) {
                continue;
            }
            if (visited[newI][newJ]) {
                continue;
            }
            res = res || dfs(grid, newI, newJ, visited);
        }
        visited[i][j] = false;
        if (res) {
            memo.add(i * m + j);
        }
        return res;
    }

}
