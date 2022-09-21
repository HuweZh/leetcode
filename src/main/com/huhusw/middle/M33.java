package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * 搜索旋转排序数组
 * 一个有序数组，经过旋转变成了前半部分有序后半部分有序的情况
 * 求target的索引
 * 二分查找
 */
public class M33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public int search(int[] nums, int target) {
        //左右边界
        int left = 0;
        int right = nums.length - 1;
        //二分查找
        //基本思想是，整个数组由mid分为两部分，两部分一定有一个是有序的
        //left-mid  mid-right
        //有序的部分继续按照二分查找，非有序的部分，继续由mid划分
        while (left <= right) {
            //mid
            int mid = (left + right) / 2;
            //找到，直接返回
            if (nums[mid] == target) {
                return mid;
            }
            //left-mid有序，且target落在有序区间内
            else if (nums[mid] >= nums[0] && nums[mid] > target && nums[0] <= target) {
                right = mid - 1;
            }
            //target没有在有序区间内
            else if (nums[mid] >= nums[0]) {
                left = mid + 1;
            }
            //mid-right有序，且target落在有序区间内
            else if (nums[mid] < nums[0] && target < nums[0] && target > nums[mid]) {
                left = mid + 1;
            }
            //target没有在有序区间内
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
