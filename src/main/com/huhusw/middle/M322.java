package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/coin-change/
 */
public class M322 {
    /**
     * 零钱兑换
     *
     * @param coins  硬币的种类
     * @param amount 凑整的钱数
     * @return 然后最小的硬币个数
     */
    public int coinChange(int[] coins, int amount) {
        //base case
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;
        //新建备忘录，dp[i]表示凑成i这么多钱最少需要多少硬币
        int[] dp = new int[amount + 1];
        //初始化为最大值，最大值就是全是硬币为1的情况
        for (int i = 0; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        //凑成0需要0个硬币
        dp[0] = 0;
        //计算后面需要的硬币个数
        for (int i = 1; i <= amount; i++) {
            //遍历硬币的种类
            for (int coin : coins) {
                if (i - coin >= 0) {
                    //状态转移方程
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }

            }
        }
        //返回结果
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
