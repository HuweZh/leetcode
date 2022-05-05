package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/
 * 乘积小于k的子数组
 */
public class M713 {

    /**
     * 找到数组中的乘积小于k的连续子数组个数
     * 暴力枚举，双重for循环查找子数组个数
     *
     * @param nums 数组
     * @param k    阈值
     * @return 连续子数组个数
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //结果
        int res = 0;
        //每次循环时的初始值
        int sum = 1;
        //外层循环，控制循环的次数
        for (int i = 0; i < nums.length; i++) {
            sum = 1;
            //内层循环，查找子数组的个数
            for (int j = i; j < nums.length; j++) {
                //开始乘
                sum *= nums[j];
                //满足题意
                if (sum < k) {
                    res++;
                } else {
                    //不满足题意，直接退出
                    break;
                }
            }
        }
        //返回结果
        return res;
    }
}
