package com.huhusw.sword2offer;

import com.huhusw.sword.S09;

import java.util.*;

/**
 * https://leetcode.cn/problems/IY6buf/
 * 字符串交织
 * 前两个字符串交叉是否能形成第三个字符串
 */
public class S096 {
    /**
     * 前两个字符串交叉是否能形成第三个字符串
     * 动规
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();
        if (m + n != l) {
            return false;
        }
        //dp[i][j]表示s1[0..i-1]和s2[0..j-1]能否构成s3[0..i+j-2]
        boolean[][] dp = new boolean[m + 1][n + 1];
        //初始两个字符串都为空，肯定能构成空的第三个字符串
        dp[0][0] = true;
        //单独一个字符串构成s3的情况
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] & (s3.charAt(i - 1) == s1.charAt(i - 1));
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] & (s3.charAt(j - 1) == s2.charAt(j - 1));
        }
        //遍历两个字符串进行判断是否能构成s3
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //可能是s1的字符相等也可能是s2的字符相等，一个相等即为true
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[m][n];
    }
}
