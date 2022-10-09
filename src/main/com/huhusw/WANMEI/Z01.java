package com.huhusw.WANMEI;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Z01 z01 = new Z01();
        z01.lastGarbageSize(new int[]{30, 45, 12, 23, 8});
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param garbages int整型一维数组
     * @return int整型
     */
    public int lastGarbageSize(int[] garbages) {
        // write code here
        int sum = 0;
        for (int i = 0; i < garbages.length; i++) {
            sum += garbages[i];
        }
        int n = garbages.length;
        int m = sum / 2;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j < garbages[i]) {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    dp[i + 1][j] = dp[i][j] || dp[i][j - garbages[i]];
                }
            }
        }
        for (int i = m; i >= 0; i--) {
            if (dp[n][i]) {
                return sum - 2 * i;
            }
        }
        return 0;
    }
}
