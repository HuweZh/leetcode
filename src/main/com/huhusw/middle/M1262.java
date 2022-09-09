package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/greatest-sum-divisible-by-three/
 * 可能被3整除的最大和
 * 给定一个数组，求出其中元素组成的最大和能被3整除
 * dp
 * 看余数，不管加的数有多大，直接看余数，因为数是同余的
 * 就算是有两个想用的值，取余数还是能放在一个篮子里
 */
public class M1262 {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for (int i = 0; i < nums.length; i++) {
            int a = dp[0] + nums[i];
            int b = dp[1] + nums[i];
            int c = dp[2] + nums[i];
            dp[a % 3] = Math.max(dp[a % 3], a);
            dp[b % 3] = Math.max(dp[b % 3], b);
            dp[c % 3] = Math.max(dp[c % 3], c);
        }
        return dp[0];
    }
}
