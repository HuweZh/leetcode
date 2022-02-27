package com.huhusw.middle;

import java.util.Arrays;
import java.util.Map;

public class M516 {
    public static void main(String[] args) {
        M516 m516 = new M516();
        int bbbab = m516.longestPalindromeSubseq("bbbab");
        System.out.println(bbbab);
    }

    //动态规划
    //设dp[i][j]为原字符串索引为i和j之间的最长回文子序列，设0<=i<=j<n
    //则状态dp[0][n-1]即为所求
    //单个字符就是最短的回文子序列，所以dp[i][i] = 1
    //循环遍历字符串的时候，可能存在两种情况
    //1.s[i]==s[j]，那么他俩可以作为两个回文字符加到原序列中，dp[i][j] = dp[i+1][j-1]+2
    //2.s[i]!=s[j]，那么他俩中不能同时作为回文字符，更新当前状态 dp[i][j] = max(dp[i+1][j],dp[i][j-1])
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        //注意循环顺序
        for (int i = n - 1; i >= 0; i--) {
            //初始状态
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                //状态转移
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    /**
     * 状态压缩
     *
     * @param s 字符串
     * @return 最长回文子序列
     */
    public int longestPalindromeSubseq2(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        //注意循环顺序
        for (int i = n - 1; i >= 0; i--) {
            //初始状态
            int pre = 0;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                char c2 = s.charAt(j);
                //状态转移
                if (c1 == c2) {
                    dp[j] = pre + 2;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = temp;
            }
        }
        return dp[n - 1];
    }
}
