package com.huhusw.middle;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 最长递增子序列
 */

public class M300 {
    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        //定义dp数组，dp[i]表示以nums[i]为末尾的最长子序列的长度
        int[] dp = new int[nums.length];
        //初始化为1，代表其本身就是最长子序列的一部分
        Arrays.fill(dp, 1);
        //双层循环进行更新dp数组
        //外层循环遍历整个数组
        for (int i = 0; i < nums.length; i++) {
            //内层循环更新数组
            for (int j = 0; j < i; j++) {
                //只有满足当前元素大于其前面的元素才能进行状态转移
                if (nums[j] < nums[i]) {
                    //更新数组
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        //获取结果
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
