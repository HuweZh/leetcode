package com.huhusw.OK;

import java.util.*;

public class Z02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(Math.max(getMoney(money, 0, n - 1), getMoney(money, 1, n)));
    }

    private static int getMoney(int[] money, int start, int end) {
        int[][] dp = new int[end - start + 1][2];
        //没有房子，不偷
        dp[0][0] = 0;
        //没有房子不能偷
        dp[0][1] = Integer.MIN_VALUE;
        dp[1][0] = 0;
        dp[1][1] = money[start];
        for (int i = start + 1; i < end; i++) {
            dp[i - start + 1][0] = Math.max(dp[i - start][0], dp[i - start][1]);
            dp[i - start + 1][1] = Math.max(dp[i - start][0] + money[i], dp[i - start - 1][1] + money[i]);
        }
        return Math.max(dp[end - start][0], dp[end - start][1]);
    }
}
