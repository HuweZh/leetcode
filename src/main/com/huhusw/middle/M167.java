package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * 两数之和 输入的数组是升序
 */
public class M167 {
    /**
     * 找两个数的和等于target
     * 数组升序排列
     * 双指针
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        //初始化
        int left = 1;
        int right = numbers.length;
        int sum = numbers[left - 1] + numbers[right - 1];
        //题目保证一定有答案
        while (sum != target) {
            //右指针移动
            if (sum > target) {
                right--;
            } else {
                //左指针移动
                left++;
            }
            //更新结果
            sum = numbers[left - 1] + numbers[right - 1];
        }
        //返回结果
        return new int[]{left, right};
    }
}
