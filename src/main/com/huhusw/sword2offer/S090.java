package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/PzWKhm/
 * 环形房屋盗窃
 */
public class S090 {
    int res = 0;

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //首尾不能同时盗窃，所以分一下范围进行盗窃
        robPart(nums, 0, nums.length - 1);
        robPart(nums, 1, nums.length);
        return res;
    }

    private void robPart(int[] nums, int start, int end) {
        //第一晚抢
        int prev = nums[start];
        //第二晚抢与不抢看金额大小
        int curr = Math.max(prev, nums[start + 1]);
        //剩下的天数都是看两天之前的情况进行决定
        for (int i = start + 2; i < end; i++) {
            int next = Math.max(prev + nums[i], curr);
            prev = curr;
            curr = next;
        }
        res = Math.max(res, curr);
    }
}
