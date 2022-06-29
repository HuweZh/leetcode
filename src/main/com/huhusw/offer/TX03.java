package com.huhusw.offer;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/test/question/done?tid=57810387&qid=830863#summary
 * 放假
 * 小q在放假期间也想工作和锻炼，但是不能连续工作和锻炼，求最少休息的天数
 * <p>
 * 这里使用的是状态机，state记录了小q的前一天的状态
 * 0：前一天休息
 * 1：前一天工作
 * 2：前一天锻炼
 * 3：前一天可以工作也可以锻炼
 * 根据当前的营业情况选择今天的转移状态，每次转移到state=0，代表可以休息一天
 */
public class TX03 {
    //结果
    static int res = 0;
    //前一天的状态
    static int state = 0;

    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //工作
        int[] a = new int[n];
        //锻炼
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        sc.close();
        //遍历所有的天数计算其休息的天数
        for (int i = 0; i < n; i++) {
            check(a[i] + b[i] * 2);
        }
        System.out.println(res);
    }

    /**
     * 检查状态，判断小q可以休息的天数
     *
     * @param i
     */
    private static void check(int i) {
        //根据前一天的状态和今天的营业情况进行状态转移
        switch (state) {
            case 0:
            case 3:
                state = i;
                break;
            case 1:
                state = i < 2 ? 0 : 2;
                break;
            case 2:
                state = i % 2;
                break;
        }
        if (state == 0) res++;
    }

    /**
     * 动态规划解题
     * 设置dp数组，dp[i]表示前i天工作或者锻炼的最大天数
     * 当天可以工作时，需要在前几天的休息和锻炼的最大值上加1
     * 当天可以锻炼时，需要在前几天的锻炼和休息的最大值上加1
     * 当天不能休息和锻炼时，需要更新休息对应的最大值
     *
     * @param a
     * @param b
     * @param n
     */
    private static void cal(int[] a, int[] b, int n) {
        int[][] dp = new int[n + 1][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 0;
        for (int i = 0; i < n; i++) {
            //可以工作
            if (a[i] == 1) {
                dp[i + 1][1] = Math.max(dp[i][0], dp[i][2]) + 1;
            }
            //可以锻炼
            if (b[i] == 1) {
                dp[i + 1][2] = Math.max(dp[i][0], dp[i][1]) + 1;
            }
            //更新状态
            dp[i + 1][0] = Math.max(dp[i][0], Math.max(dp[i][1], dp[i][2]));
        }
        //结果
        int ans = n - Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
    }
}
