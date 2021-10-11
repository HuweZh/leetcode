package com.huhusw.simple;

public class S1480 {
    public static void main(String[] args) {
        S1480 s1480 = new S1480();
        s1480.runningSum(new int[]{1,2,3,4});
    }
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
//        res[0] = nums[0];
//        for (int i = 1; i < n; i++) {
//            res[i] = res[i - 1] + nums[i];
//        }
        for (int i = 0, s = 0; i < n; i++) {
            res[i] = s = s + nums[i];
        }
        return res;
    }
}
