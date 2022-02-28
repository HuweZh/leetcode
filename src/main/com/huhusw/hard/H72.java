package com.huhusw.hard;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class H72 {
    /**
     * 将word1转为word2最少需要几步，即word1和word2之间的距离
     * 递归回溯超时
     * 这里的思想就是，如果碰见两个字符相同，则跳过此字符，不处理
     * 字符不相同的话，增删改三种操作都试一遍，取其中距离最小的
     *
     * @param word1 字符串
     * @param word2 字符串
     * @return 最小距离
     */
    public int minDistance(String word1, String word2) {
        //定义dp数组
        int m = word1.length();
        int n = word2.length();
        //dp[i][j]表示word1[0...i-1]和word2[0...j-1]之间的最短距离
        //当访问到i，j时，只需要判断的情况为i-1和j-1，他们前面的状态是已经是最新的
        //还有初始状态i=0,j=0时，一个是空串，最短的距离就是把另一个字符串都删掉，所以对应是其长度
        int[][] dp = new int[m + 1][n + 1];
        //初始状态
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        //遍历数组，更新状态
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //两个字符相等，不需要管，直接复制之前的状态
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //字符不相同，则需要进行增删改的操作，正好对应了周围的三个状态，最后加上本次的操作数
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
                }
            }
        }
        //返回结果
        return dp[m][n];
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
