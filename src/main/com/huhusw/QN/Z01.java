package com.huhusw.QN;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Z01 z01 = new Z01();
        int i = z01.maxScore(10, new int[][]{{1, 1}, {2, 3}, {3, 5}, {5, 10}, {7, 9}, {8, 10}});
        System.out.println(i);
//        10,[[1,1],[2,3],[3,5],[5,10],[7,9],[8,10]]
    }

    public int maxScore(int energy, int[][] actions) {
        // write code here
        int res = 0;
        int[][] dp = new int[actions.length + 1][energy + 1];
        for (int i = 1; i <= actions.length; i++) {
            for (int j = 1; j <= energy; j++) {
                if (j >= actions[i - 1][0]) {
                    //拿或不拿
                    dp[i][j] = Math.max(dp[i - 1][j - actions[i - 1][0]] + actions[i - 1][1], dp[i - 1][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[actions.length][energy];
    }
}
