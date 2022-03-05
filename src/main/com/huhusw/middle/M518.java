package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/coin-change-2/
 */
public class M518 {
    public static void main(String[] args) {
        M518 m518 = new M518();
        m518.change(5, new int[]{1, 2, 5});
    }

    /**
     * 动规凑零钱
     *
     * @param amount 钱数
     * @param coins  硬币
     * @return 方案数
     */
    public int change3(int amount, int[] coins) {
        //dp数组，dp[i][j]表示前i个硬币可以凑成j元的方案数
        int[][] dp = new int[coins.length + 1][amount + 1];
        //初始值
        // dp[0][..]表示没有硬币，凑钱，初始值为0
        // dp[..][0]表示硬币凑0元，方案数为1，一个都不选
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        //遍历两层状态，更新数组
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                //只有钱数大于硬币的金额时，才可能会用到硬币
                if (j >= coins[i - 1]) {
                    //不选择此硬币和选择此硬币的两个方案加在一起构成当前状态
                    //不选此硬币，继承上一层的状态
                    //选择此硬币，就是在当前层选择状态
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    //直接继承
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        //返回结果
        return dp[coins.length][amount];
    }

    /**
     * 凑零钱，得到所有可能的结果
     * 状态压缩
     *
     * @param amount 钱数
     * @param coins  硬币种类
     * @return 所有可能的结果
     */
    public int change(int amount, int[] coins) {
        //备忘录，dp[i]表示金额为i时的方案数
        int[] dp = new int[amount + 1];
        //初始化，金额为0时，只有一种方案，就是一个硬币都不选
        dp[0] = 1;
        //遍历硬币
        for (int coin : coins) {
            //遍历大于当前硬币的所有金额，只有大于此硬币的金额才能用到此硬币
            for (int i = coin; i <= amount; i++) {
                //将可能的结果加到当前的备忘录上
                //dp[0]就是一个硬币的方案
                //其他的就是在当前金额上减去一个硬币的量，加到当前金额
                dp[i] += dp[i - coin];
            }
        }
        //返回
        return dp[amount];
    }
}
