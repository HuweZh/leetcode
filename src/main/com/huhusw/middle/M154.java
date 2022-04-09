package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * 寻找旋转数组的最小值2
 */
public class M154 {

    /**
     * 找到旋转数组的最小值
     * 其中数组中包含重复元素
     * <p>
     * 按照153的做法，进行二分，但是需要注意的是，因为存在相同值，我们遇见相等情况是不能确定最小值在左边还是右边
     * 需要额外处理一下，对于每一个截取的区间来说，都是满足153中找到的规律的
     * 既然不能确定最小值在左右哪边，那么我们就换一个值去比较，反正这个值在目前的序列中有备份
     * 所以，我们就一步步缩短右边界
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        //左右边界
        int left = 0;
        int right = nums.length - 1;
        //二分遍历
        while (left <= right) {
            //中点
            int mid = left + (right - left) / 2;
            //找到相等的值，那么说明当前区间这个值有两份，我们舍去一份还是可以完成需求
            //社区右端端点这一份
            if (nums[mid] == nums[right]) {
                right--;
            } else if (nums[mid] < nums[right]) {
                //中点小于右端端点，最小值在左边，缩短右边界
                right = mid;
            } else {
                //中点大于右端端点， 最小值在右边，缩短左边界
                left = mid + 1;
            }
        }
        //返回结果
        return nums[left];
    }
}
