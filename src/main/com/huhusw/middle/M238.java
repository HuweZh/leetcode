package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class M238 {
    /**
     * 返回一个数组，该数组的各个元素是参数数组中除索引自身外其他元素的乘积
     * 遍历构造左右数组的乘积，该左右数组的乘积是指当前元素的左边的乘积和右边的乘积
     *
     * @param nums 参数数组
     * @return 返回乘积
     */
    public int[] productExceptSelf(int[] nums) {
        //临界情况
        if (nums == null || nums.length == 0) {
            return null;
        }
        //数组长度
        int n = nums.length;
        //左边数组乘积
        int[] L = new int[n];
        //初始化
        L[0] = 1;
        //右边数组的乘积
        int[] R = new int[n];
        //初始化
        R[n - 1] = 1;
        //构造左边数组
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        //构造右边数组
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        //结果
        int[] ans = new int[n];
        //构造结果数组
        for (int i = 0; i < n; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }
}
