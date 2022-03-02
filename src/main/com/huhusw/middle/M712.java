package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings/
 * 删除字符的和
 */
public class M712 {
    /**
     * 使s1等于s2，最小需要删除的字符的和
     * 求的是公共最长子序列
     * 动规
     *
     * @param s1 字符串
     * @param s2 字符串
     * @return 删除字符的和
     */
    public int minimumDeleteSum(String s1, String s2) {
        //字符数量
        int m = s1.length();
        int n = s2.length();
        //dp数组，dp[i][j]表示s1[0...i-1]和s2[0...j-1]的最长公共子序列
        int[][] dp = new int[m + 1][n + 1];
        //遍历字符串，更新数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //找到相同的字符，加上该字符的ASCII
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    //没找到，就用较大的值
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        //计算全部字符的ASCII
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += s1.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            sum += s2.charAt(i);
        }
        //剪去公共部分就是所得
        return sum - dp[m][n] - dp[m][n];
    }
}
