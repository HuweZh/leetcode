package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/fpTFWP/
 * 最长的递增路径
 * dfs搜索，并保存中间的状态，防止重复遍历，记忆化搜索
 */
public class S112 {
    //    int n;
//    List<Integer>[] edge;
//    Map<Integer, Integer> memo;
//
//    /**
//     * 建图完成记忆化搜索
//     * @param matrix
//     * @return
//     */
//    public int longestIncreasingPath(int[][] matrix) {
//        int m = matrix.length;
//        n = matrix[0].length;
//        edge = new List[m * n];
//        for (int i = 0; i < m * n; i++) {
//            edge[i] = new ArrayList<>();
//        }
//        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < 4; k++) {
//                    int newI = i + dir[k][0];
//                    int newJ = j + dir[k][1];
//                    if (newI < 0 || newI >= m || newJ < 0 || newJ >= n) {
//                        continue;
//                    }
//                    if (matrix[i][j] > matrix[newI][newJ]) {
//                        edge[newI * n + newJ].add(i * n + j);
//                    } else if (matrix[i][j] < matrix[newI][newJ]) {
//                        edge[i * n + j].add(newI * n + newJ);
//                    }
//                }
//            }
//        }
//        memo = new HashMap<>();
//        int res = 1;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                res = Math.max(res, dfs(matrix, i, j));
//            }
//        }
//        return res;
//    }
//
//    private int dfs(int[][] matrix, int i, int j) {
//        if (memo.containsKey(i * n + j)) {
//            return memo.get(i * n + j);
//        }
//        int res = 0;
//        for (int stem : edge[i * n + j]) {
//            int newI = stem / n;
//            int newJ = stem % n;
//            res = Math.max(res, dfs(matrix, newI, newJ));
//        }
//        memo.put(i * n + j, 1 + res);
//        return 1 + res;
//    }
    public static void main(String[] args) {
        S112 s112 = new S112();
        s112.longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}});
    }

    int n;
    int m;
    int[][] memo;
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * 记忆化搜索
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        memo[i][j]++;
        for (int[] stem : dir) {
            int newI = i + stem[0];
            int newJ = j + stem[1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && matrix[newI][newJ] > matrix[i][j]) {
                memo[i][j] = Math.max(memo[i][j], dfs(matrix, newI, newJ) + 1);
            }
        }
        return memo[i][j];
    }
}
