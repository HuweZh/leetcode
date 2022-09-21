package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/
 * 搜索旋转排序数组2
 * 一个含有重复元素的排序数组，查找target是否在数组中
 * 二分查找
 * 基本思想是mid分成的两段，肯定有一端是有序的
 * 但是这里多了一个前提，有重复元素，所以 1 1 0 1 1 1 这种数组来说，不能很好的判断序列关系
 * 所以需要加一种情况，既然第左右边界元素相等，那就直接移动左右边界，慢慢收敛
 */
public class M81 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //二分查找
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //多出的情况，移动边界
            //其他情况，按照有序和无序进行划分
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[mid] >= nums[left]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
