package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 * 区间覆盖
 * 排序加贪心
 * 按照左边界进行排序，判断右边界是否交叠即可
 */
public class M452 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] > b[0]) {
                return 1;
            } else if (a[0] < b[0]) {
                return -1;
            }
            return 0;
        });
        int res = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i - 1][1] >= points[i][0]) {
                //这里需要更新右边界，因为可能有全包的情况
                points[i][1] = Math.min(points[i - 1][1], points[i][1]);
            } else if (points[i - 1][1] < points[i][0]) {
                res++;
            }
        }
        return res;
    }
}
