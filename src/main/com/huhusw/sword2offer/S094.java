package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/omKAoA/
 * 最少分割回文串
 * 将一个字符串分割更回文子串，最小的分割次数
 */
public class S094 {
    public int minCut(String s) {
        if (s.length() == 1) {
            return 0;
        }
        int n = s.length();
        //dp计算所有的子串是否为回文串
        //dp[i][j]表示s[i..j]是否为回文串
        boolean[][] flag = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(flag[i], true);
        }
        //计算所有的子串是否为回文串
        //i使用的是i+1行的状态，所以需要倒叙计算，j则相反
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                //flag[i + 1][j - 1]表示中间的是否为回文串,(s.charAt(i) == s.charAt(j))表示两端字符能否构成回文串
                flag[i][j] = flag[i + 1][j - 1] & (s.charAt(i) == s.charAt(j));
            }
        }
        //动态规划计算
        //dp[i]表示s[0..i]之间满足题意的最小分割次数
        int[] dp = new int[n];
        Arrays.fill(dp, 0x7f7f7f7f);
        for (int i = 0; i < n; i++) {
            //如果0..i本身就是回文串，不需要分割
            if (flag[0][i]) {
                dp[i] = 0;
            } else {
                //否则，需要分割，将0..i分成三段，0..j,j+1..i-1,i 只有j+1..i-1是回文串，才考虑分割一次，0..j使用dp[j]表示
                for (int j = 0; j < i; j++) {
                    if (flag[j + 1][i]) {
                        dp[i] = Math.min(dp[j] + 1, dp[i]);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
