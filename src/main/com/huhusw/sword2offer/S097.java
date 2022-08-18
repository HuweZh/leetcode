package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/21dk04/
 * 子序列的个数
 */
public class S097 {
    /**
     * 求s中子序列等于t的个数
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (n > m) {
            return 0;
        }
        //dp[i][j]表示s[0..i]中子序列等于t[0..j]的个数
        int[][] dp = new int[m + 1][n + 1];
        //t为空串，为任何字符串的子串
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        //s为空串，不能构成任何子串
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0;
        }
        //更新dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //如果当前遍历的字符相等，那么有两种选择
                //1.将当前字符作为子序列加入，对应dp[i - 1][j - 1]
                //2.不管当前字符，继续向下遍历，对应dp[i - 1][j]
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    //不相等，只有一种选择，舍弃该字符
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
