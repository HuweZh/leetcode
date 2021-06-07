package com.huhusw.middle;

/**
 * @author huhusw
 * @Description
 * @create 2021-06-07 10:41
 */
public class M494 {
    int count = 0;

    public static void main(String[] args) {
        M494 m494 = new M494();
        int targetSumWays = m494.findTargetSumWays2(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(targetSumWays);
    }

    //回溯
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            dfs(nums, target, index + 1, sum + nums[index]);
            dfs(nums, target, index + 1, sum - nums[index]);
        }
    }

    //动态规划
    //本题的目标是从nums数组中找到一个正数集合P和一个负数集合N，使得P-N=target
    //于是sum(nums)-P+N = sum(nums)-target ，即2N=sum-target
    //设dp[i][j]表示在nums(从1开始计数)数组中前i个元素中选取元素和为j的方案数
    //初始状态dp[0][0]=1,第一行其他为0
    public int findTargetSumWays1(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int neg = sum - target;
        if (neg < 0 || (neg % 2) != 0) {
            return 0;
        }
        neg = neg / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            //状态转移方程
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                //j小于num时，直接抄上面的方案数
                dp[i][j] = dp[i - 1][j];
                //j大于等于num时，除了抄上面的方案数，也有可能是通过j-num这个元素直接过来的
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }

    //优化动态规划
    //dp数组只用到了两行，因此可以去掉一个维度，使用滚动的方式完成dp过程
    public int findTargetSumWays2(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int neg = sum - target;
        if (neg < 0 || (neg % 2) != 0) {
            return 0;
        }
        neg = neg / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            //状态转移方程
            int num = nums[i - 1];
            //内层循环倒序，保证得到的值都是上一步的dp[i-1][]的值
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }

}
