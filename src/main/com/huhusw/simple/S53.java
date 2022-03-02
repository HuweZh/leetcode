package com.huhusw.simple;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 最大子数组和
 */
public class S53 {
    /**
     * 求nums的最大子数组和
     *
     * @param nums 数组
     * @return 最大子数组和
     */
    public int maxSubArray(int[] nums) {
        //dp数组，定义dp[i]是以nums[i]为末尾的最大子数组和
        int[] dp = new int[nums.length];
        //初始，只有一个元素时，其最大子数组和就是本身
        dp[0] = nums[0];
        //遍历数组
        for (int i = 1; i < nums.length; i++) {
            //当前元素要么链接上一个子数组成为尾巴，要么切断联系，自己成为一个新数组，取两者的大值
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        //得到结果
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
