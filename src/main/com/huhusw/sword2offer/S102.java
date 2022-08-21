package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/YaVDxD/
 * 加减目标值
 * 给元素的前面赋值+或-，求等于target的方案数
 */
public class S102 {
    int n;
    int t;
    int res = 0;

    /**
     * 递归回溯
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        t = target;
        n = nums.length;
        backTrack(nums, 0, 0);
        return res;
    }

    /**
     * 递归回溯，这里因为没有剪枝，所以复杂度会很高
     * 可以使用带返回值的dfs，使用map做备忘录，做到剪枝
     *
     * @param nums
     * @param index
     * @param sum
     */
    private void backTrack(int[] nums, int index, int sum) {
        if (index == n) {
            if (sum == t) {
                res++;
            }
            return;
        }
        backTrack(nums, index + 1, sum + nums[index]);
        backTrack(nums, index + 1, sum - nums[index]);
    }
}
