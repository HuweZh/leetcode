package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class M209 {
    /**
     * 找到子数组中元素和大于等于target的最小长度
     * 使用滑动窗口实现
     *
     * @param target 目标
     * @param nums   数组
     * @return 最短子数组大于等于目标
     */
    public int minSubArrayLen(int target, int[] nums) {
        //边界条件
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //数组长度
        int n = nums.length;
        //滑动窗口起始和结束
        int start = 0;
        int end = 0;
        //结果
        int ans = Integer.MAX_VALUE;
        //子数组的和
        int sum = 0;
        //遍历数组
        while (end < n) {
            //数组和小于目标时，往后滑动
            sum += nums[end];
            end++;
            //数组和大于目标是，上界往下滑
            while (sum >= target) {
                ans = Math.min(ans, end - start);
                sum -= nums[start];
                start++;
            }
        }
        //返回结果
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
