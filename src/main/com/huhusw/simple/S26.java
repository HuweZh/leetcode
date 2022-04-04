package com.huhusw.simple;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 删除重复元素
 */
public class S26 {
    /**
     * 再不使用额外空间的要求上实现删除重复元素
     * 快慢指针，快指针往前试探，慢指针指向目前没有重复的元素
     *
     * @param nums 数组
     * @return 删除后的数组
     */
    public int removeDuplicates(int[] nums) {
        //快慢指针
        int slow = 0;
        int fast = 0;
        //遍历数组
        while (fast < nums.length) {
            //找到不重复元素，更新慢指针
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            //快指针往前试探
            fast++;
        }
        // for(int i : nums){
        //     System.out.print(i + " ");
        // }
        //返回结果
        return slow + 1;
    }
}
