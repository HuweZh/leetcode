package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/most-profit-assigning-work/
 * 工作中的最大收益
 * 贪心，按照收益最大的进行安排
 */
public class M826 {
    public static void main(String[] args) {
        M826 m826 = new M826();
        m826.maxProfitAssignment(new int[]{2, 4, 6, 8, 10}, new int[]{10, 20, 30, 40, 50}, new int[]{4, 5, 6, 7});
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] work = new int[profit.length][2];
        for (int i = 0; i < profit.length; i++) {
            work[i][0] = difficulty[i];
            work[i][1] = profit[i];
        }
        Arrays.sort(work, (a, b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1];
            }
            return b[0] - a[0];
        });
        Arrays.sort(worker);
        int res = 0;
        int index = 0;
        for (int i = worker.length - 1; i >= 0; i--) {
            while (index < profit.length && work[index][0] > worker[i]) {
                index++;
            }
            if (index == profit.length) {
                break;
            }
            res += work[index][1];
        }
        return res;
    }
}
