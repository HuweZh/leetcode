package com.huhusw.TYY;

import java.util.*;

public class Z03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int n = sc.nextInt();
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }
        n = sc.nextInt();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }
        sc.close();
        int[][] dp = new int[n + 1][total + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= total; j++) {
                if (j >= cost[i]) {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - cost[i]] + value[i]);
                } else {
                    dp[i + 1][j] = dp[i][j];
                }
            }
        }
        System.out.println(dp[n][total]);
    }
}
