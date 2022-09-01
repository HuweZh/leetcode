package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 寻找旋转数组中的最小值
 */
public class M153 {
    /**
     * 对一个升序数组进行旋转，将若干个元素旋转到数组的后方
     * 找到这个数组中的最小值
     * <p>
     * 这个数组有一个特点，对于第一个元素来说，最小值左边的元素都是大于等于这个值，右边则相反
     * 对于最后一个元素也是如此
     * 所以利用这个特点可以进行二分查找
     *
     * @param nums 旋转后的数组
     * @return
     */
    public int findMin(int[] nums) {
        //数组长度
        int n = nums.length;
        //选最后一个元素作为基准进行二分
        int target = nums[n - 1];
        //左右边界
        int left = 0;
        int right = n - 1;
        //循环判断
        while (left <= right) {
            //中点
            int mid = left + (right - left) / 2;
            //正好找到基准， 证明基准就是最小值
            if (nums[mid] == target) {
                return target;
            } else if (nums[mid] < target) {
                //小于基准，说明当前在最小值的右边，缩小右边界
                right = mid - 1;
            } else {
                //大于基准，说明在最小值的左边，缩小左边界
                left = mid + 1;
            }
        }
        //直接返回左边界对应值
        return nums[left];
    }

    /**
     * 实时更新基准值，保证基准是在查找过程中逐步变小
     *
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //基准值为右侧边界
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
