package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 */
public class M1143 {
    /**
     * 求两个字符串的最长公共子序列，递归超时
     * 这里是动态规划，递归有助于理解题意
     *
     * @param text1 字符串
     * @param text2 字符串
     * @return 子序列长度
     */
    public int longestCommonSubsequence(String text1, String text2) {
        //dp数组，dp[i][j]代表了text1[0...i-1]和text2[0...j-1]的最长公共子序列长度
        //其中需要注意的是边界，边界i=0或j=0代表有一个是空串，公共序列长度为0
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        //遍历dp数组，进行状态更新
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                //发现两个字符相同，就是由上一个状态加上这个字符构成
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //否则，i移动或者j移动，取决于两者前面的最长序列长度
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
