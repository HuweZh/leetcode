package com.huhusw.hard;

/**
 * @author huhusw
 * @Description
 * @create 2021-05-13 10:20
 */
public class H1269 {
    public static void main(String[] args) {
        H1269 h1269 = new H1269();
        int i = h1269.numWays(4, 2);
        System.out.println(i);
    }
    //动态规划，下一步的状态只与当前状态有关
    public int numWays(int steps, int arrLen) {
        int maxColumn = Math.min(arrLen - 1, steps / 2 + 1);
        //dp[i][j]表示第i步到达索引为j的方案数
        int[][] dp = new int[steps+1][maxColumn+1];
        //初始状态,一动不动是一种方案，i=0的其他元素都为0
        dp[0][0] = 1;

        int mod = 1000000007;

        //状态转移方程为 dp[i][j] = dp[i-1][j-1]+dp[i-1][j]+dp[i-1][j+1]
        //分别对应向左、不动、向右，注意边界
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxColumn; j++) {
                dp[i][j] += dp[i - 1][j];
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                dp[i][j] %= mod;
                if (j + 1 <= maxColumn) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
                dp[i][j] %= mod;
            }
        }
        return dp[steps][0];
    }
    /**
     * 因为只用到了两行的数据，所以可以将二维数组压缩成为一位数组
     */
}
