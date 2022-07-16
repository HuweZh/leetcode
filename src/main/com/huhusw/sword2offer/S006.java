package com.huhusw.sword2offer;

/**
 * https://leetcode.cn/problems/kLl5u1/
 * 给定升序数组，找两个索引对应的和为target
 * 双指针
 */
public class S006 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (true) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{left, right};
    }
}
