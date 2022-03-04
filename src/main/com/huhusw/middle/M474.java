package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 */
public class M474 {
    /**
     * 找数组元素中在限定情况下的最大子集
     * 背包问题的变种，容量变成了m个0和n个1
     * 动规
     *
     * @param strs 数组
     * @param m    0的限制
     * @param n    1的限制
     * @return 最大子集
     */
    public int findMaxForm2(String[] strs, int m, int n) {
        //dp数组，dp[i][j][k]表示前i个元素在j个0和k个1的限制下最大子集的个数
        //初始值为i=0，这时候数组没有元素，所以无论jk怎么选值，最大子集都是0，
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        //遍历数组
        for (int l = 0; l < strs.length; l++) {
            //遍历限制条件
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    //计算当前元素1和0的个数
                    int[] count = getZeroAndOne(strs[l]);
                    //当前满足条件
                    if (i >= count[0] && j >= count[1]) {
                        //更新dp，在不选择和选择之间取大值
                        dp[l + 1][i][j] = Math.max(dp[l][i][j], dp[l][i - count[0]][j - count[1]] + 1);
                    } else {
                        //只能不选择
                        dp[l + 1][i][j] = dp[l][i][j];
                    }
                }
            }
        }
        //返回结果
        return dp[strs.length][m][n];
    }

    /**
     * 动规+滚动数组
     * 从上面的解法来看，当前数组只与上一层数组相关，使用滚动数组的方式解决
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        //定义dp数组，dp[i][j]表示限制条件i个0和j个1
        //初始值为0，权当是因为数组中没有值
        int[][] dp = new int[m + 1][n + 1];
        //遍历数组
        for (int l = 0; l < strs.length; l++) {
            //计算1和0的个数
            int[] count = getZeroAndOne(strs[l]);
            //滚动数组
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    //在选择与不选择之间取大值
                    dp[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 计算0和1的个数
     *
     * @param str 字符串
     * @return 字符串中0和1的个数
     */
    public int[] getZeroAndOne(String str) {
        int[] res = new int[2];
        for (int i = 0; i < str.length(); i++) {
            res[str.charAt(i) - '0']++;
        }
        return res;
    }
}
