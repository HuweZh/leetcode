package com.huhusw.sword;

/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * 奇数在前偶数在后
 */
public class S21 {
    /**
     * 调整数组位置，使用奇数在前，偶数在后
     *
     * @param nums 数组
     * @return 调整后的数组
     */
    public int[] exchange(int[] nums) {
        //边界情况
        if (nums == null || nums.length == 0) {
            return nums;
        }
        //左右指针
        int left = 0;
        int right = nums.length - 1;
        //遍历数组
        while (true) {
            //找到左边不符合题意的索引
            while (left < nums.length && nums[left] % 2 == 1) {
                left++;
            }
            //找到右边不符合题意的索引
            while (right >= 0 && nums[right] % 2 == 0) {
                right--;
            }
            //退出条件
            if (left >= right) {
                break;
            }
            //交换两个值
            swap(nums, left, right);
        }
        //返回
        return nums;
    }

    /**
     * 交换数组中的两个索引值
     *
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
