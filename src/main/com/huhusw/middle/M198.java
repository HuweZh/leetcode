package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * 打家劫舍
 * 规定不能连续盗窃两个相邻家庭
 */
public class M198 {
    /**
     * 打家劫舍，有限状态机
     * 0表示今天不偷 1表示偷
     * ↙ ← ↖
     * 0  →  1
     * 再加上两个状态的自旋，就构成了状态机
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        //创建dp数组，dp[i][0or1]表示前[0..i-1]户能偷得最大财物
        int[][] dp = new int[n + 1][2];
        //初始值，没有家庭给你偷，设置一个取不到的值
        dp[0][0] = Integer.MIN_VALUE;
        //初始值，第一个家庭，选择偷的话，直接偷
        dp[1][0] = nums[0];
        //遍历所有家庭
        for (int i = 2; i <= n; i++) {
            //对当前家庭偷，此状态由两个状态转移得到，前一天没偷，今天偷；前两天偷了，今天偷
            //两者取大值
            dp[i][0] = Math.max(dp[i - 1][1] + nums[i - 1], dp[i - 2][0] + nums[i - 1]);
            //对当前家庭不偷，也是两个状态转移得到，前一天偷了，今天不能偷，前一天没偷，今天不想偷
            //两者取大值
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        //返回两者中的大值
        return dp[n][1] > dp[n][0] ? dp[n][1] : dp[n][0];
    }
}
