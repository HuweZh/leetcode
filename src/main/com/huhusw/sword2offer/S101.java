package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/NUPfPr/
 * 分割等和子集
 */
public class S101 {

    /**
     * 能否将数组分割成为两个和相等的子集
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int amount = sum / 2;
        int n = nums.length;
        //dp[i][j]表示数组[0..i-1]是否能构成和为j
        boolean[][] dp = new boolean[n + 1][amount + 1];
        //和为0，不选数字即可
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        //遍历数组和钱数
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                //这里只能不选
                if (j < nums[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    //可选可不选，一个为真即可
                    dp[i + 1][j] = dp[i][j] || dp[i][j - nums[i]];
                }
            }
        }
        return dp[n][amount];
    }
}
