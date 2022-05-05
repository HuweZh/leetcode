package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/subarray-product-less-than-k/
 * 乘积小于k的子数组
 */
public class M713 {

    /**
     * 找到数组中的乘积小于k的连续子数组个数
     * 暴力枚举，双重for循环查找子数组个数
     *
     * @param nums 数组
     * @param k    阈值
     * @return 连续子数组个数
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //结果
        int res = 0;
        //每次循环时的初始值
        int sum = 1;
        //外层循环，控制循环的次数
        for (int i = 0; i < nums.length; i++) {
            sum = 1;
            //内层循环，查找子数组的个数
            for (int j = i; j < nums.length; j++) {
                //开始乘
                sum *= nums[j];
                //满足题意
                if (sum < k) {
                    res++;
                } else {
                    //不满足题意，直接退出
                    break;
                }
            }
        }
        //返回结果
        return res;
    }

    /**
     * 滑动窗口
     * 在[i,j]区间内，元素乘积记为sum
     * 如果sum<k，直接就可以加上这个子数组的所有连续子数组的方案数
     * 如果sum>k，移动左端点i，直到i=l时满足题意，那么[l.j]就是我们在这个区间内的方案数
     * 对于右端点j+1来说，i<l的情况可以直接排除，因为所有元素都是正数，所以区间越短，乘积越小
     * 于是就可以设定一个窗口[i,j]，右端点一直增大，左端点也一直增大，一次遍历解决问题
     *
     * @param nums 数组
     * @param k    阈值
     * @return 连续子数组的个数
     */
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        //结果
        int res = 0;
        //sum
        int sum = 1;
        //左端点
        int i = 0;
        //遍历数组，同时设置右端点
        for (int j = 0; j < nums.length; j++) {
            //[i,j]区间的乘积
            sum *= nums[j];
            //滑动左端点
            while (i <= j && sum >= k) {
                sum /= nums[i];
                i++;
            }
            //加上当前的方案数
            res += j - i + 1;
        }
        return res;
    }

    /**
     * 二分查找
     * 对于连续子数组的乘积，严格小于k这个不等式来说
     * 两边同时取对数，就变成了连续子数组的和严格小于log(k)
     * 而且，数组元素都是正数，前缀和是一个递增数组
     * 对于区间[i,j]来说，找到最小满足题意的i=l
     * 那么就是[l,j]满足题意，计算其方案数
     *
     * @param nums 数组
     * @param k    阈值
     * @return 方案数
     */
    public int numSubarrayProductLessThanK3(int[] nums, int k) {
        //结果
        int res = 0;
        //定义前缀和数组
        int n = nums.length;
        double[] logPreSum = new double[n + 1];
        //计算前缀和
        for (int i = 0; i < n; i++) {
            logPreSum[i + 1] = logPreSum[i] + Math.log(nums[i]);
        }
        //计算阈值
        double logk = Math.log(k);
        //遍历数组，即设定右端点
        for (int i = 0; i < n; i++) {
            //左右端点
            int l = 0;
            int r = i + 1;
            //index就是在[i,j]区间内满足题意的最小值
            int index = i + 1;
            //sum_j-sum_l<logk=>sum_l>sum_j-logk
            //所以求得l的方式变为一个不等式，不等式右边的值为val
            //但是由于double的精度问题，加上一个1e-10以防万一
            double val = logPreSum[index] - logk + 1e-10;
            //二分查找
            while (l <= r) {
                //中间值
                int mid = l + (r - l) / 2;
                //找l，找到最小的l
                //当前已经满足题意，继续向左半部分寻找
                if (logPreSum[mid] > val) {
                    r = mid - 1;
                    index = mid;
                } else {
                    //右半部分
                    l = mid + 1;
                }
            }
            //加上当前区间的方案数
            res += i + 1 - index;
        }
        return res;
    }
}
