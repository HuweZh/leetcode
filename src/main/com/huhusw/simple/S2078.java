package com.huhusw.simple;

import java.util.*;

/**
 * https://leetcode.cn/problems/two-furthest-houses-with-different-colors/
 * 两栋不同房子之间的距离
 * 暴力循环
 */
public class S2078 {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (colors[i] != colors[j]) {
                    res = Math.max(j - i, res);
                    break;
                }
            }
        }
        return res;
    }
}
