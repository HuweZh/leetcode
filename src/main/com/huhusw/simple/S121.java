package com.huhusw.simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 买卖股票的最好时机
 */
public class S121 {
    /**
     * 买卖股票的利润最大
     * 维护一个历史最低点，每次进行买卖都根据最低点进行
     *
     * @param prices 股票的价格
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        //历史最低点价格，表示[0..i-1]之间的最低价格
        int minPri = Integer.MAX_VALUE;
        //结果
        int res = 0;
        //遍历股票价格
        for (int i = 0; i < prices.length; i++) {
            //计算[0..i-1]之间的最低价格
            if (prices[i] < minPri) {
                minPri = prices[i];
            }
            //计算当前的利润
            else if (res < prices[i] - minPri) {
                res = prices[i] - minPri;
            }
        }
        return res;
    }

    /**
     * 暴力解法，超时
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }

    /**
     * 暴力解法+备忘录，能过
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
//        Map<Integer, Integer> memo = new HashMap<>();
        Set<Integer> memo = new HashSet<>();
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (memo.contains(prices[i])) {
                continue;
            }
            for (int j = i + 1; j < prices.length; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
            memo.add(prices[i]);
        }
        return res;
    }
}
