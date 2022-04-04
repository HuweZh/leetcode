package com.huhusw.simple;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 * 将0移动到数组末尾，其他元素相对位置不变
 */
public class S283 {
    /**
     * 移动0到末尾，其他元素的相对位置不能改变
     * 相当于将0先在数组中删除，然后后面空出来的位置补0
     * 快慢指针
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        //快慢指针
        int slow = 0;
        int fast = 0;
        //遍历数组
        while (fast < nums.length) {
            //试探数组元素不为0，就往前挤
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            //更新快指针
            fast++;
        }
        //补0
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }
}
