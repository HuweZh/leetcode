package com.huhusw.sword2offer;

import com.huhusw.TreeNode;

import java.util.*;

/**
 * https://leetcode.cn/problems/Gu0c2T/
 * 房屋偷盗
 */
public class S089 {
    public static void main(String[] args) {
        S089 s089 = new S089();
        s089.rob(new int[]{1, 2, 3, 1});
    }

    /**
     * 不能偷相邻的两家
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        dp[0][0] = dp[1][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[1][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1][0] = Math.max(dp[i][1], dp[i][0]);
            dp[i + 1][1] = Math.max(dp[i][0], dp[i - 1][1]) + nums[i];
        }
        return dp[nums.length][1];
    }

    /**
     * 环形房子，首尾相接
     */
    int res = 0;

    public int rob2(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        robPart(nums, 0, nums.length - 1);
        robPart(nums, 1, nums.length);
        return res;
    }

    private void robPart(int[] nums, int start, int end) {
        int[] prev = new int[2];
        int[] curr = new int[2];
        prev[0] = 0;
        prev[1] = Integer.MIN_VALUE;
        curr[0] = 0;
        curr[1] = nums[start];
        for (int i = start + 1; i < end; i++) {
            int[] next = new int[2];
            next[0] = Math.max(curr[0], curr[1]);
            next[1] = Math.max(curr[0], prev[1]) + nums[i];
            prev = curr;
            curr = next;
        }
        res = Math.max(res, curr[0]);
        res = Math.max(res, curr[1]);
    }

    /**
     * 二叉树形房子，父子不能同时选中
     */
    Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        //抢,接下来就是要去下下家
        int doIt = root.val + (root.left == null ? 0 : rob3(root.left.left) + rob3(root.left.right)) + (root.right == null ? 0 : rob3(root.right.left) + rob3(root.right.right));
        //不抢，去抢下家
        int notDo = rob3(root.left) + rob3(root.right);
        memo.put(root, Math.max(doIt, notDo));
        return Math.max(doIt, notDo);
    }

}
