package com.huhusw.hard;

//买卖股票的时机赚取最大利润
public class H123 {
    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
     * 买卖股票3
     * 限制交易次数为2
     * 有限状态机
     * ↗→ buy →↘
     * 0→0         1→1
     * ↖← sell ←↙
     * 0表示未持有股票，1表示持有股票
     * 有两种状态可得到状态为0，自旋或者sell
     * 有两种状态可得到状态为1，自旋或者buy
     * 转移方程依次得到
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        //定义dp数组，dp[i][j][0 or 1]表示前[1..i]天，在交易次数j的限制下，未持有或持有股票的最大利润
        //注意，其中的j表示最大交易次数
        int[][][] dp = new int[n + 1][3][2];
        //初始值，第0天股票交易未开始，所以不能持有股票
        for (int i = 0; i < 3; i++) {
            //此时不能买卖，为0
            dp[0][i][0] = 0;
            //不能持有，取一个得不到的值
            dp[0][i][1] = Integer.MIN_VALUE;
        }
        //初始值，0次交易的限制下，不能交易
        for (int i = 0; i <= n; i++) {
            //不能交易，为0
            dp[i][0][0] = 0;
            //不能持有，取一个取不到的值
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        //遍历状态，遍历数组
        for (int i = 1; i <= n; i++) {
            //遍历交易次数
            for (int j = 1; j < 3; j++) {
                //转移方程
                //未持有，可能前一天就未持有，也可能前一天持有今天卖掉
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                //持有，可能前一天就持有，也可能前一天未持有今天买入，需要注意交易次数的变化，增加了一此交易，对应的值应当是上一个交易
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }
        //返回最终的结果
        return dp[n][2][0];
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     * 买卖股票2
     * 这里较3的变化为k的取值为无穷大
     * 所以k-1和k是相等的，直接将k这个指标去掉
     * 转移方程相同
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
        }
        return dp[n][0];
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
     * 买卖股票4
     * 相较3的变化为增加k的限制，这里直接将k替换3中的k=2即可
     * 转移方程无变化
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }
        return dp[n][k][0];
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
     * 含手续费的买卖股票
     * 每一个完整的买卖需要上交一个手续费
     * 在状态方程中剪去即可，k为无穷，直接取消此指标
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        //这里可能因为手续费的问题导致数值进位转正，所以取一个稍微小一点的负值
        dp[0][1] = 0x96969696;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
        }
        return dp[n][0];
    }

    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
     * 含有冷冻期的买卖股票
     * 卖出的下一天不能买入
     * 转移方程稍微变一下，买入的时候将前一天转移到前两天即可
     * k为无穷，取消指标
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            //第一次的买卖不含冷冻期
            if (i - 2 < 0) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i - 1]);
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1]);
        }
        return dp[n][0];
    }
}
