package com.huhusw;

import javax.sound.midi.SoundbankResource;
import java.util.Map;

/**
 * @Author huhusw
 * @Date 2020/11/8
 */
public class S122 {
    public static void main(String[] args) {
        S122 s122 = new S122();
        int i = s122.maxProfit(new int[]{1, 9, 6, 9, 1, 7, 1, 1, 5, 9, 9, 9});
        int i1 = s122.maxProfitGreed(new int[]{1, 9, 6, 9, 1, 7, 1, 1, 5, 9, 9, 9});
        System.out.println(s122.maxProfitDp(new int[]{1, 9, 6, 9, 1, 7, 1, 1, 5, 9, 9, 9}));
        System.out.println(i);
        System.out.println(i1);
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) {
            return 0;
        }
        int sum = 0;

        int min = prices[0];
        for (int i = 1; i < prices.length - 1; i++) {
            if (prices[i] >= min && prices[i] >= prices[i + 1]) {
                sum += prices[i] - min;
                min = prices[i + 1];
                i++;
            } else if (prices[i] > min) {

            } else {
                min = prices[i];
            }
        }
        if (prices[prices.length - 1] > prices[prices.length - 2]) {
            sum += prices[prices.length - 1] - min;
        }
        return sum;
    }

    // 贪心
    public int maxProfitGreed(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if ((prices[i] - prices[i - 1]) > 0) {
                sum += prices[i] - prices[i - 1];
            }
        }

        return sum;
    }

    //dp
    public int maxProfitDp(int[] prices) {
        // 令状态只有持有股票和现金两种
        // 分别求其转移方程
        // 设置初始状态，持有现金的话，初始状态就为0，持有股票的话初始状态为-p[0]
        // 现金的状态转移方程为：要么继承上次现金，要么持有股票卖出，因为持有股票是以减现金的方式存在，所以卖出是以加现金的方式
        // 于是money = max(money,stock+p[i])
        int money = 0;
        // 类似的，持有股票：要么上次就持有股票，要么上次持有现金买入股票
        int stock = -prices[0];

        // 保存中间状态
        int preMoney = money;
        int preStock = stock;
        for (int i = 1; i < prices.length; i++) {
            //状态转移
            money = Math.max(preMoney, preStock + prices[i]);
            stock = Math.max(preStock, preMoney - prices[i]);

            preMoney = money;
            preStock = stock;
        }
        return money;
    }
}
