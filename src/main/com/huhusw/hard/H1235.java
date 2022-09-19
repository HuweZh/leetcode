package com.huhusw.hard;

import java.util.*;

/**
 * https://leetcode.cn/problems/maximum-profit-in-job-scheduling/
 * 规划兼职找工作
 * 工作有开始和结束时间以及对应的收益，求最大收益
 * 工作时间有重叠的不能干
 * 排序+动态规划
 */
public class H1235 {
    public static void main(String[] args) {
        H1235 h = new H1235();
        h.jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70});
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        //将数据整理到一组
        int[][] times = new int[startTime.length + 1][3];
        for (int i = 0; i < startTime.length; i++) {
            times[i + 1][0] = startTime[i];
            times[i + 1][1] = endTime[i];
            times[i + 1][2] = profit[i];
        }
        //保证循环一定能结束，少一次判断
        times[0][1] = -1;
        //排序数据
        Arrays.sort(times, (a, b) -> {
            return a[1] - b[1];
        });
        //动规
        int[] dp = new int[startTime.length + 1];
        //遍历数组
        for (int i = 1; i <= startTime.length; i++) {
            int start = times[i][0];
            int cur = 0;
            //向前遍历第一个与当前区间分离的区间
            for (int j = i - 1; j >= 0; j--) {
                if (times[j][1] <= start) {
                    cur = j;
                    break;
                }
            }
            dp[i] = Math.max(dp[i - 1], dp[cur] + times[i][2]);
//            if (cur != Integer.MIN_VALUE) {
//                dp[i] = Math.max(dp[i - 1], dp[cur] + times[i][2]);
//            } else {
//                dp[i] = dp[i - 1];
//            }

        }
        return dp[startTime.length];
    }
}
