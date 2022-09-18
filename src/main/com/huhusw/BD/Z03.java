package com.huhusw.BD;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.*;

public class Z03 {
    static char[][] graph;
    static int n;
    static int m;
    static int res = Integer.MAX_VALUE;
    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;
    static ArrayList<String> stem = new ArrayList<>();
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stem = scanner.nextLine().split(" ");
        n = Integer.parseInt(stem[0]);
        m = Integer.parseInt(stem[1]);
        graph = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            graph[i] = scanner.nextLine().toCharArray();
        }
        scanner.close();
        if (n <= 1 && m <= 1) {
            System.out.println(0);
            return;
        }
        visited[0][0] = true;
        res = bfs(0, 0);
        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    private static int bfs(int i, int i1) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, i1});
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int j = 0; j < size; j++) {
                int[] stem = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newI = stem[0] + dir[k][0];
                    int newJ = stem[1] + dir[k][1];
                    if (newI == n - 1 && newJ == m - 1) {
                        return step;
                    }
                    if (newI >= 0 && newI < n && newJ >= 0 && newJ < m) {
                        if (visited[newI][newJ]) {
                            continue;
                        }
                        if ((graph[stem[0]][stem[1]] == 'r' && graph[newI][newJ] == 'd')
                                || (graph[stem[0]][stem[1]] == 'e' && graph[newI][newJ] == 'r')
                                || (graph[stem[0]][stem[1]] == 'd' && graph[newI][newJ] == 'e')) {
                            continue;
                        }
                        visited[newI][newJ] = true;
                        queue.add(new int[]{newI, newJ});
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    private static void dfs(int i, int j, int step) {
        if (i == n - 1 && j == m - 1) {
            res = Math.min(res, step);
            return;
        }
        for (int k = 0; k < 4; k++) {
            int newI = i + dir[k][0];
            int newJ = j + dir[k][1];
            if (newI >= 0 && newI < n && newJ >= 0 && newJ < m) {
                if (visited[newI][newJ]) {
                    continue;
                }
                if ((graph[i][j] == 'r' && graph[newI][newJ] == 'd') || (graph[i][j] == 'e' && graph[newI][newJ] == 'r') || (graph[i][j] == 'd' && graph[newI][newJ] == 'e')) {
                    continue;
                }
                visited[newI][newJ] = true;
                stem.add(newI + "," + newJ + " " + step);
                dfs(newI, newJ, step + 1);
                stem.remove(stem.size() - 1);
                visited[newI][newJ] = false;
            }
        }
    }
}
