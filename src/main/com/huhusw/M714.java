package com.huhusw;

import java.util.Map;

public class M714 {
public int maxProfit(int[] prices, int fee) {
    // dp[i][0]：手中没有股票时的最大收益
    // dp[i][1]：手中持有股票时的最大收益
    int dp[][] = new int[prices.length][2];
    // 初始状态
    dp[0][0] = 0;
    dp[0][1] = -prices[0];

    for (int i = 1; i < prices.length; i++) {
        // 状态转移方程
        // 没有股票时，最大收益为无动作和卖出股票的收益之间的最大值
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - fee + prices[i]);
        // 有股票时，最大收益为无动作和买入股票收益之间的最大值
        dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    }
    // 返回最后一次手中没有股票的收益值
    return dp[prices.length-1][0];
}
}
