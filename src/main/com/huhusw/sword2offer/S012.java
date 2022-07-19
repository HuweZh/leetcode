package com.huhusw.sword2offer;

/**
 * https://leetcode.cn/problems/tvdfij/
 * 左右子数组和相等
 * 将0看成-1；个数相等转化为连续子数组和为0
 */
public class S012 {
    public static void main(String[] args) {
        S012 s012 = new S012();
        s012.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
    }

    public int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length + 2];
        preSum[1] = nums[0];
        preSum[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        preSum[nums.length + 1] = 0;
        int index = 1;
        while (index <= nums.length) {
            int left = preSum[index - 1];
            int right = preSum[nums.length] - preSum[index];
            if (left == right) {
                return index - 1;
            }
            index++;
        }
        return -1;
    }
}
