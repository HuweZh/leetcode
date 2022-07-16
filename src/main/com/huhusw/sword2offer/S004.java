package com.huhusw.sword2offer;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/WGki4K/
 * 找出数组中只出现过一次的数
 * 需要注意边界
 */
public class S004 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 3) {
            if (i + 1 < nums.length && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
