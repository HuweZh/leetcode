package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/D0F0SV/
 * 排列的数目
 */
public class S104 {
    /**
     * 动规求排列的数目
     *
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        //dp[i]表示目标为i时的排列数目
        //试想一个排列符合题意，那么排列的最后一个元素一定是nums数组中的，假设为num
        //则一定有i>=num
        //对所有的num进行遍历，就是dp[i]的方案数
        int[] dp = new int[target + 1];
        //初始化，目标为0时，只能一个也不选
        dp[0] = 1;
        //遍历进行更新
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
