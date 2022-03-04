package com.huhusw.middle;

/**
 * @author huhusw
 * @Description
 * @create 2021-06-08 12:59
 */
public class M1049 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        System.out.println(a | b);
        M1049 m1049 = new M1049();

        System.out.println(m1049.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }

    //动态规划+数学证明
    //dp[i+1][j]表示前i个石头能否凑成和为j
    //状态转移方程：如果j<stones[i]，只能放过，不选，此时dp[i+1][j] = dp[i][j]
    //如果j>=stones[i]，有两种选择，选或者不选，选择这块石头，则dp[i+1][j] = dp[i][j-stones[i]]
    //不选这块石头，则dp[i+1][j] = dp[i][j]，只要两种选择有一个成立，那么dp[i+1][j]就能凑成，变为1
    //初始状态dp[0][0]=1
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int m = sum / 2;
        int n = stones.length;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                //状态转移
                if (j < stones[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = dp[i][j] | dp[i][j - stones[i]];
                }
            }
        }
        for (int i = m; i >= 0; i--) {
            if (dp[n][i] == 1) {
                return sum - 2 * i;
            }
        }
        return 0;
    }

    //动态规划只用到了一行的值，可以优化空间
    public int lastStoneWeightII1(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int m = sum / 2;
        int n = stones.length;
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= stones[i]; j--) {
                //状态转移
                dp[j] = dp[j] | dp[j - stones[i]];
            }
        }

        for (int i = m; i >= 0; i--) {
            if (dp[i] == 1) {
                return sum - 2 * i;
            }
        }
        return 0;
    }

    /**
     * 最后一块石头的重量
     * 就是将石头分成两堆，两堆的重量相近
     * 动规
     *
     * @param stones 石头
     * @return 两堆的重量差
     */
    public int lastStoneWeightII2(int[] stones) {
        //全部石头重量
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        //定义dp数组,dp[i][j]表示前i块石头是否能凑成重量为j，j最大定义为所有石头重量的一半
        boolean[][] dp = new boolean[stones.length + 1][sum / 2 + 1];
        //初始值，没有石头可供选择，也没有重量要求，此时为true，其余为false
        dp[0][0] = true;
        //遍历石头和重量
        for (int i = 1; i <= stones.length; i++) {
            for (int j = 0; j < sum / 2 + 1; j++) {
                //当要求重量大于石头时，才能有选择，选择中有一个为true就是true
                if (j >= stones[i - 1]) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - stones[i - 1]];
                } else {
                    //只能放弃
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        //找到这一堆能凑成的最大值并返回
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[stones.length][i]) {
                return sum - i - i;
            }
        }
        return 0;
    }

    /**
     * 本层状态只与上一层有关，可使用滚动数组压缩存储空间
     *
     * @param stones
     * @return
     */
    public int lastStoneWeightII3(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int i = 1; i <= stones.length; i++) {
            //倒叙更新数组
            for (int j = sum / 2; j >= stones[i - 1]; j--) {
                dp[j] = dp[j] | dp[j - stones[i - 1]];
            }
        }
        int pos = 0;
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[i]) {
                return sum - i - i;
            }
        }
        return 0;
    }
}
