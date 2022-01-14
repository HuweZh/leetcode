package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 */
public class M1004 {
    /**
     * 求出数组中最长的连续1序列，其中可以将k个0换成1
     * 转换一下题目要求就是：求一个最长子数组，其中最多不超过k个0
     * 滑动窗口实现
     *
     * @param nums 原数组
     * @param k    k个可替换的值
     * @return 子数组的长度
     */
    public int longestOnes(int[] nums, int k) {
        //数组长度
        int n = nums.length;
        //窗口的左右指针
        int left = 0;
        int right = 0;
        //记录窗口中0的个数
        int zeroCount = 0;
        //结果
        int res = 0;
        //遍历数组
        while (right < n) {
            //右指针主动向前探索
            if (nums[right] == 0) {
                zeroCount++;
            }
            //左指针被迫前进
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            //更新结果
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
