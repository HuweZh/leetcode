package com.huhusw.simple;

public class S303 {
    /**
     * https://leetcode-cn.com/problems/range-sum-query-immutable/
     * 自定义一个类，构造时给定一个数组
     * 实现API：给定数组索引i j。返回数组中[i,j]之间的元素和
     */
    class NumArray {
        //自定义前缀和
        private int[] preSum;

        //构造函数
        public NumArray(int[] nums) {
            int n = nums.length;
            //初始化前缀和
            preSum = new int[n + 1];
            //前缀和赋值
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        /**
         * 给定区间，计算区间内的元素和
         *
         * @param left  区间
         * @param right 区间
         * @return 元素和
         */
        public int sumRange(int left, int right) {
            //直接利用前缀和，时间复杂度为常数
            return preSum[right + 1] - preSum[left];
        }
    }

}
