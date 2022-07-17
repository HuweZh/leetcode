package com.huhusw.sword2offer;

/**
 * https://leetcode.cn/problems/ZVAVXX/
 * 乘积小于k的连续子数组个数
 * 滑动窗口
 */
public class S009 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 1;
            //滑动窗口
            int right = i;
            while (sum < k) {
                sum *= nums[right];
                //符合条件
                if (sum < k) {
                    res++;
                }
                right++;
                if (right >= nums.length) {
                    break;
                }
            }
        }
        return res;
    }
}
