package com.huhusw.sword;

/**
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * 子数组的最大和
 */
public class S42 {
    /**
     * 子数组的最大和
     * 动规，dp[i] 表示以nums[i]为结尾的子数组的最大和
     * dp[i]有两种选择，第一种链接到前面的元素形成更大的子数组
     * 第二种自成一派，新开辟一个子数组
     *
     * @param nums 数组
     * @return 最大和
     */
    public int maxSubArray(int[] nums) {
        //定义dp数组，并初始化
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        //更新dp数组
        for (int i = 1; i < n; i++) {
            //状态转移方程，分别对应两种情况，取较大的值
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        //获取结果
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
