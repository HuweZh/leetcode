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
     * 凑零钱，得到所有可能的结果
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
