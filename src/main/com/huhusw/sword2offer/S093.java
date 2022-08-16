package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/Q91FMA/
 * 最长的斐波那契数列
 * 找到数组中最长的菲波那切数列
 */
public class S093 {
    public static void main(String[] args) {
        S093 s093 = new S093();
        s093.lenLongestFibSubseq(new int[]{2392, 2545, 2666, 5043, 5090, 5869, 6978, 7293, 7795});
    }

    /**
     * 方法体
     *
     * @param arr 有序数组
     * @return
     */
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        //存储元素对应的索引
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            memo.put(arr[i], i);
        }
        //动规
        //dp[i][j]表示以arr[i]和arr[j]为结尾的斐波那契数列，且i>j，例如8 5 ，可以向前推导3 2 1
        //所以要做的类似两数之和，逐步更新dp数组
        int[][] dp = new int[n][n];
        int res = 0;
        //因为小于2的数组没有意义，从2开始
        for (int i = 2; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                //k是第三个数，且要满足k<j<i
                int k = arr[i] - arr[j];
                //这里k不满足题意
                if (k >= arr[j]) {
                    break;
                }
                //找到了k，更新dp数组
                if (memo.containsKey(k)) {
                    dp[i][j] = Math.max(dp[j][memo.get(k)] + 1, 3);
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
