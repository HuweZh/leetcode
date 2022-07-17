package com.huhusw.sword2offer;

/**
 * https://leetcode.cn/problems/2VG8Kg/
 * 和大于等于target的最短子数组
 * 滑动窗口
 */
public class S008 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int res = nums.length + 1;
        int sum = 0;
        while (right < nums.length) {
            while (right < nums.length && sum < target) {
                sum += nums[right];
                right++;
            }
            res = Math.min(res, right - left + 1);
            while (left < right && sum >= target) {
                sum -= nums[left];
                left++;
            }
            res = Math.min(res, right - left + 1);
        }
        return res == nums.length + 1 ? 0 : res;
    }
}
