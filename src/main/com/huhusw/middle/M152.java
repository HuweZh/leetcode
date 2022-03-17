package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * 子数组的最大乘积
 */
public class M152 {
    /**
     * 计算子树组的最大乘积
     * 动规
     * 但是需要注意的是，使用一个dp数组保存最大值太片面
     * 例如一个数组[-2,3,-4]
     * 其最大乘积应该是三数之积，如果只有一个dp数组，那么就会在3为的位置停顿，因为3大于两侧的乘积
     * 所以我们需要另一个数组，额外存储最小值
     * 每次的状态转移就从三个数值里面转
     * 可以进行状态压缩，当前元素只与前一个元素有关
     *
     * @param nums 数组
     * @return 子数组的最大乘积
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        //保留最大值的dp数组，dp[i]表示前i个元素所形成的子数组的最大乘积
        int[] dpMax = new int[n];
        //保留最小值的dp数组，dp[i]表示前i个元素所形成的子数组的最小乘积
        int[] dpMin = new int[n];
        //返回值
        int res = Integer.MIN_VALUE;
        //初始化两个数组
        for (int i = 0; i < n; i++) {
            dpMax[i] = nums[i];
            dpMin[i] = nums[i];
            res = Math.max(nums[i], res);
        }
        for (int i = 1; i < n; i++) {
            //更新状态
            dpMax[i] = max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i], nums[i]);
            dpMin[i] = min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i], nums[i]);
            res = Math.max(dpMax[i], res);
        }
        return res;
    }

    /**
     * 三数最大值
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int max(int a, int b, int c) {
        return Math.max(a, b) > c ? Math.max(a, b) : c;
    }

    /**
     * 三数最小值
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int min(int a, int b, int c) {
        return Math.min(a, b) < c ? Math.min(a, b) : c;
    }
}
