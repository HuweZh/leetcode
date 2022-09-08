package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/beautiful-arrangement-ii/
 * 优美的数列2
 * 将1-n排成一个数列，两个相邻元素的绝对值不同的个数恰好为k
 * 逻辑题
 * 前面的差值都为1，后半部分的差值为2-k，正好符号题意
 */
public class M667 {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int index = 0;
        for (int i = 1; i < n - k; i++) {
            res[index] = i;
            index++;
        }
        for (int i = n - k, j = n; i <= j; i++, j--) {
            res[index] = i;
            index++;
            if (i != j) {
                res[index] = j;
                index++;
            }
        }
        return res;
    }
}
