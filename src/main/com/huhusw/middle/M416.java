package com.huhusw.middle;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * 分割等和子集
 */
public class M416 {
    /**
     * 将nums分割成两个和相等的子集
     * 动规
     *
     * @param nums 数组
     * @return 能否分
     */
    public boolean canPartition2(int[] nums) {
        //计算数组和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //直接返回
        if (sum % 2 == 1) {
            return false;
        }
        //对数组进行排序，计算最大值是否不符合题意
        Arrays.sort(nums);
        if (nums[nums.length - 1] > sum / 2) {
            return false;
        }
        //dp数组，dp[i][j]表示nums[0...i-1]这个子数组能否划出来一个和为j的子集
        boolean[][] dp = new boolean[nums.length][sum / 2 + 1];
        //初始值，和为0时，元素一个都不选就是一种方案，所以值为true
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        //第一行只有一个元素
        dp[0][nums[0]] = true;
        //遍历数组更新dp
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                //和大于当前元素时，可以选择放入元素和不放入元素，其中一个为true就为true
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                } else {
                    //否则，更新为上一次状态
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        //返回结果
        return dp[nums.length - 1][sum / 2];
    }

    /**
     * 动规状态压缩
     * 当前的状态只与上层状态有关
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
        Arrays.sort(nums);
        if (nums[nums.length - 1] > sum / 2) {
            return false;
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        dp[nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            //这里要从后往前遍历，是因为更新状态时用到了dp[j - nums[i]]前面的状态
            //如果先更新前面的状态会导致后面的状态更新时用了当前层的状态
            for (int j = sum / 2; j > 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] | dp[j - nums[i]];
                }
            }
        }
        return dp[sum / 2];
    }
}
