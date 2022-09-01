package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/rotate-array/
 * 旋转数组
 * 将数组的元素整体向右移动k个
 * 模拟，经过三次反转得到
 * 第一次将数组反转
 * 二三次以k为分割，分别反转
 */
public class M189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int stem = arr[start];
            arr[start] = arr[end];
            arr[end] = stem;
            start++;
            end--;
        }
    }
}
