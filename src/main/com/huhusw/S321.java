package com.huhusw;

public class S321 {

    public static void main(String[] args) {
        S321 s321 = new S321();
        s321.maxSubsequence(new int[]{1,8,3,4,9,5},3);
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        return null;
    }
    public int[] maxSubsequence(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remain = length - k;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                remain--;
            }
        }
        return stack;
    }
}
