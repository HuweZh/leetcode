package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/house-robber-ii/
 * 打家劫舍2
 * 首尾相连
 */
public class M213 {
    /**
     * 房屋的首尾相连在一起，偷第一家就不能偷最后一家
     * 动规
     *
     * @param nums 邻居价值
     * @return 最大价值
     */
    public int rob(int[] nums) {
        //边界条件
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        //如果偷第一家，那么最后一家不能偷，即偷窃目标为[0...n-2]
        //如果不偷第一家，那么偷窃范围为[1...n-1]，两种情况下取大值
        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }

    /**
     * 偷窃[start,end]内的目标最大金额
     *
     * @param nums 目标
     * @param start 起始
     * @param end 终点
     * @return 返回当前范围内的最大价值
     */
    public int robRange(int[] nums, int start, int end) {
        int n = end - start;
        // 定义dp数组，dp[i][0or1]表示[0..i-1]（要映射到函数的范围）之间的最大价值
        int[][] dp = new int[n + 2][2];
        //初始值，没有目标偷窃，订一个取不到的值
        dp[0][0] = Integer.MIN_VALUE;
        //只能偷第一家
        dp[1][0] = nums[start];
        //对应dp的下标，与题目的范围形成映射
        int index = 2;
        //遍历范围
        for (int i = start + 2; i <= end + 1; i++) {
            //更新dp状态，偷窃的状态转移只能由上一天未偷窃和前两天偷窃转移，不偷窃同理
            dp[index][0] = Math.max(dp[index - 1][1] + nums[i - 1], dp[index - 2][0] + nums[i - 1]);
            dp[index][1] = Math.max(dp[index - 1][1], dp[index - 1][0]);
            //下标更新
            index++;
        }
        //返回大值
        return dp[n + 1][0] > dp[n + 1][1] ? dp[n + 1][0] : dp[n + 1][1];
    }
}
