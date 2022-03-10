package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/interleaving-string/
 * 交错字符串
 */
public class M97 {
    /**
     * 判断s1和s2交错是否能构成s3
     *
     * @param s1 字符串
     * @param s2 字符串
     * @param s3 字符串
     * @return s1和s2是否能构成s3
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        //边界条件
        if (m + n != s3.length()) {
            return false;
        }
        //定义dp数组，dp[i][j]表示s1[0..i]和s2[0..j]是否能构成s3[0..i+j]
        //如果s1[i]==s3[i+j]，那么dp[i][j]=dp[i-1][j]
        //如果s2[j]==s3[i+j]，那么dp[i][j]=dp[i][j-1]，两者一个为true即可
        boolean[][] dp = new boolean[m + 1][n + 1];
        //两个空串构成空串为true
        dp[0][0] = true;
        //遍历两个字符串
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //s3索引
                int l = i + j - 1;
                //保证不越界
                if (i > 0) {
                    //s1[i-1]==s3[i+j-1]的情况
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(l));
                }
                if (j > 0) {
                    //s2[j-1]==s3[i+j-1]的情况
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(l));
                }
            }
        }
        //返回结果
        return dp[m][n];
    }
}
