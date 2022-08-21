package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/gaM7Ch/
 * 最少的硬币数
 */
public class S103 {
    /**
     * 从硬币中选择最小的硬币数构成amount
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount == 0) {
            return 0;
        }
        int n = coins.length;
        //dp[i]表示构成钱数为i需要的最小硬币数
        int[] dp = new int[amount + 1];
        //初始化为最大值
        Arrays.fill(dp, amount + 1);
        //遍历硬币
        for (int i = 0; i < n; i++) {
            if (coins[i] > amount) {
                continue;
            }
            dp[coins[i]] = 1;
            //遍历大于此硬币钱数的情况
            for (int j = coins[i] + 1; j <= amount; j++) {
                dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
            }
        }
        //返回结果
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
