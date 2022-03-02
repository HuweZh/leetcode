package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 * 最小的删除步骤
 */
public class M583 {
    /**
     * 两个字符串相互转换，最少需要删除几个字符
     * 即求两个字符串的最长公共子序列
     * 动规
     *
     * @param word1 字符串
     * @param word2 字符串
     * @return 最少删除字符的个数
     */
    public int minDistance(String word1, String word2) {
        //字符串长度
        int m = word1.length();
        int n = word2.length();
        //dp数组，dp[i][j]表示s1[0..i-1]和s2[0...j-1]两个字符串之间的最长公共子序列
        //初始状态为一个字符串和一个空串，所以初始值为0
        int[][] dp = new int[m + 1][n + 1];
        //遍历两个字符串
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //两个字符相等，是一个公共字符，记录下来
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //不相等时，取两个子串中间的大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //返回结果
        return n + m - dp[m][n] - dp[m][n];
    }
}
