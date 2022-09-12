package com.huhusw.simple;

import java.util.*;

/**
 * https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/
 * 特殊数组的特征值
 */
public class S1608 {
    public int specialArray(int[] nums) {
        int n = nums.length;
        for (int x = 0; x <= n; x++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] >= x) {
                    count++;
                }
            }
            if (count == x) {
                return x;
            }
        }
        return -1;
    }
}
