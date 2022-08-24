package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/next-permutation/
 * 全排列的下一个，给定一个数组，输出按照字典序排列的下一个
 */
public class M31 {
    /**
     * 对于数组，将其变成按字典序排列的下一个
     * 思路就是从末尾向前找第一个降序的数，此时后半部分是降序排列
     * 在从末尾向前找第一个大于第一个数，交换两个数，此时后半部分还是降序
     * 并将后半部分进行反转，转为升序，即是字典序的下一个
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        //找第一个数
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 可能 5 4 3 2 1 的序列，此时i=-1，将其反转就是答案
        if (i >= 0) {
            //找第二个数
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            // 交换这两个数并反转
            int stem = nums[i];
            nums[i] = nums[j];
            nums[j] = stem;
        }
        //反转后半部分的数
        reverse(nums, i + 1);
    }

    /**
     * 双指针反转[index,n-1]之间的元素
     *
     * @param nums
     * @param index
     */
    private void reverse(int[] nums, int index) {
        int left = index;
        int right = nums.length - 1;
        while (left < right) {
            int stem = nums[left];
            nums[left] = nums[right];
            nums[right] = stem;
            left++;
            right--;
        }
    }
}
