package com.huhusw.simple;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * 移除等于val的元素
 */
public class S27 {
    /**
     * 移除数组中等于val的元素，不允许使用额外的空间
     * 在原数组执行操作
     * 快慢指针，快慢指针优化
     * 从两头开始遍历，找到一个符合题意的就覆盖掉
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        //左右
        int left = 0;
        int right = nums.length;
        //遍历数组
        while (left < right) {
            //左边的符合题意，使用右边的值进行覆盖
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                //左边更新
                left++;
            }
        }
        //返回结果
        return left;
    }
}
