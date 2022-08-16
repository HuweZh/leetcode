package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/cyJERH/
 * 翻转字符的最小次数
 * 从一个只有0和1字符串中翻转成 0...1...的形式
 */
public class S092 {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        //动规
        //dp[i][0]表示长度为i的字符串，第i位是0时需要的最小翻转次数
        // dp[i][1]表示长度为i的字符串，第i位是1时需要的最小翻转次数
        int[][] dp = new int[n + 1][2];
        //长度为0
        dp[0][0] = 0;
        dp[0][1] = 0;
        //遍历字符串
        for (int i = 0; i < n; i++) {
            //本位为0，上一位只能为0
            dp[i + 1][0] = dp[i][0];
            //本位为1，上一位可以是0和1
            dp[i + 1][1] = Math.min(dp[i][0], dp[i][1]);
            //根据本位的真实情况，计算是否需要翻转
            if (s.charAt(i) == '0') {
                //0转1
                dp[i + 1][1] += 1;
            } else {
                //1转0
                dp[i + 1][0] += 1;
            }
        }
        return Math.min(dp[n][0], dp[n][1]);
    }
}
