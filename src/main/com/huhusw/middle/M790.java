package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/domino-and-tromino-tiling/
 * 多米诺和托米诺平铺
 */
public class M790 {
    /**
     * 平铺的方案数
     * 地板的面积为2*n
     * 砖块的规格有两种，一种是多米诺，一种是托米诺
     * 可以任意旋转，最终将整块地板铺满
     * 返回方案总数
     *
     * @param n 地板的长度
     * @return 铺设的方案数
     */
    public int numTilings(int n) {
        //边界情况
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 5;
        }
        //dp数组，dp[i]表示面积为i*2时的方案数
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        final int M = 1000000007;
        //更新dp
        for (int i = 4; i <= n; i++) {
            //通过计算得状态转移方程
            //本题有两个dp数组，在计算过程中将第二个dp数组消去了
            //可以想想一下，dp数组就是托米诺的情况，dp2数组是携带托米诺的情况
            //托米诺的情况可以从多米诺和托米诺情况构成
            /**
             * dp[i]
             * =dp[i-1]+dp[i-2]+2*dp2[i-2]
             * =2*dp[i-1]+dp[i-2]+2*(dp2[i-3]+dp[i-3])-dp[i-1]
             * =2*dp[i-1]+dp[i-2]+2*(dp2[i-3]+dp[i-3])-dp[i-2]-dp[i-3]-2*dp2[i-3]
             * =2*dp[i-1]+dp[i-3]
             */
            dp[i] = 2 * dp[i - 1] % M + dp[i - 3] % M;
            dp[i] %= M;
        }
        return dp[n];
    }
}
