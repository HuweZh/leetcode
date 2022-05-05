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

    /**
     * 滑动窗口
     * 在[i,j]区间内，元素乘积记为sum
     * 如果sum<k，直接就可以加上这个子数组的所有连续子数组的方案数
     * 如果sum>k，移动左端点i，直到i=l时满足题意，那么[l.j]就是我们在这个区间内的方案数
     * 对于右端点j+1来说，i<l的情况可以直接排除，因为所有元素都是正数，所以区间越短，乘积越小
     * 于是就可以设定一个窗口[i,j]，右端点一直增大，左端点也一直增大，一次遍历解决问题
     *
     * @param nums 数组
     * @param k    阈值
     * @return 连续子数组的个数
     */
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        //结果
        int res = 0;
        //sum
        int sum = 1;
        //左端点
        int i = 0;
        //遍历数组，同时设置右端点
        for (int j = 0; j < nums.length; j++) {
            //[i,j]区间的乘积
            sum *= nums[j];
            //滑动左端点
            while (i <= j && sum >= k) {
                sum /= nums[i];
                i++;
            }
            //加上当前的方案数
            res += j - i + 1;
        }
        return res;
    }
}
