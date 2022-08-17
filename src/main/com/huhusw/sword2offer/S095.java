package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/qJnOS7/
 * 最长公共子序列
 */
public class S095 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        //dp[i][j]表示s1[0..i]和s2[0..j]之间的最长公共子序列
        int[][] dp = new int[m + 1][n + 1];
        //初始值分别为一个字符串为空的情况
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //如果两个字符串又遇见了相同的字符，那么在s1[0..i-1]和s2[0..j-1]拿到最长子序列加1
                //即dp[i - 1][j - 1]+1
                //否则，取s1[0..i]和s2[0..j-1]、s1[0..i]和s2[0..j-1]之间的最大值，保证右下角的值最大
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
