package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 查找有序数组中的第一个和最后一个的位置
 */
public class M34 {
    /**
     * 搜索nums中第一次和最后一次出现target的位置
     *
     * @param nums   有序数组
     * @param target 目标值
     * @return 第一次和最后一次的位置
     */
    public int[] searchRange(int[] nums, int target) {
        //结果
        int[] res = {-1, -1};
        //边界情况
        if (nums.length == 0) {
            return res;
        }
        //二分查找
        int left = 0;
        int right = nums.length - 1;
        //先查找第一次出现的位置，注意此时的遍历区间为[left,right]，闭区间
        //注意区间有关我们进行区间压缩
        while (left <= right) {
            //获得中点
            int mid = left + (right - left) / 2;
            //找到这个元素，无法确定是否为第一次出现，所以向左压缩区间，再次查找
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                //压缩左区间
                right = mid - 1;
            } else {
                //压缩右区间
                left = mid + 1;
            }
        }
        //进行值的判断，while的退出条件是left>right，所以可能出现left超出数组长度的情况
        if (left == nums.length || nums[left] != target) {
            res[0] = -1;
        } else {
            res[0] = left;
        }
        //查找最后一次出现的位置
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //无法确定是否为最后一次的情况，所以向左压缩区间
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //while退出的条件是left>right，所以right也有超出区间的可能
        if (right == -1 || nums[right] != target) {
            res[1] = -1;
        } else {
            res[1] = right;
        }
        return res;
    }
}
