package com.huhusw.sword2offer;

/**
 * https://leetcode.cn/problems/QTMn0o/
 * 和为k的子数组个数
 * 前缀和
 */
public class S010 {
    public static void main(String[] args) {
        S010 s010 = new S010();
        s010.subarraySum(new int[]{1, 1, 1}, 2);
    }

    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int[] preSum = new int[nums.length];
        //计算前缀和
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        //遍历前缀和，寻找符合条件
        //preSum[i]-preSum[j]==k
        for (int i = 0; i < nums.length; i++) {
            //更新目标
            int target = preSum[i] - k;
            //说明从0~i数组满足题意
            if (target == 0) {
                res++;
            }
            //遍历剩余的数组
            for (int j = 0; j < i; j++) {
                if (preSum[j] == target) {
                    res++;
                }
            }
        }
        return res;
    }
}
