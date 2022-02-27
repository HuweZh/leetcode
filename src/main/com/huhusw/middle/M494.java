package com.huhusw.middle;

import java.util.HashMap;
import java.util.Map;

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

    //回溯算法完成
    //返回值
    int res = 0;

    /**
     * 找到数组中的目标和
     *
     * @param nums   数组
     * @param target 目标和
     * @return 返回可以达成目标和的数量
     */
    public int findTargetSumWays3(int[] nums, int target) {
        //回溯
        dfs(nums, 0, target);
        return res;
    }

    /**
     * 回溯算法完成目标和
     *
     * @param nums   数组
     * @param index  当前元素对应的索引
     * @param target 目标和
     */
    public void dfs(int[] nums, int index, int target) {
        //跳出递归
        if (index == nums.length) {
            //满足目标和，更新结果
            if (target == 0) {
                res += 1;
            }
            return;
        }
        //做出选择，当前元素选择减号，直接操作target
        target += nums[index];
        //递归，往后遍历
        dfs(nums, index + 1, target);
        //撤销选择
        target -= nums[index];

        //做出选择，当前元素选择加号，直接操作target
        target -= nums[index];
        //递归，往后遍历
        dfs(nums, index + 1, target);
        //撤销选择
        target += nums[index];
    }

    //制作备忘录，消除重复子问题
    //hash表作为备忘录
    Map<String, Integer> memo;

    public int findTargetSumWays4(int[] nums, int target) {
        memo = new HashMap<>();
        int res = dp(nums, 0, target);
        return res;
    }

    /**
     * 备忘录完成目标和
     *
     * @param nums   数组
     * @param index  当前元素索引
     * @param target 目标和
     * @return 达成目标和的个数
     */
    public int dp(int[] nums, int index, int target) {
        //跳出递归的条件
        if (index == nums.length) {
            //是否能达成目标和
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        //手动制作key
        String key = index + " " + target;
        //备忘录中有值，直接返回
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        //计算不同选择对应的目标和数量，并放入备忘录
        int ans = dp(nums, index + 1, target + nums[index]) + dp(nums, index + 1, target - nums[index]);
        memo.put(key, ans);
        return ans;
    }

    /**
     * 动态规划解决目标和
     * 将原数组分为两个集合，一个添加正号A，一个添加负号B
     * 于是A-B=target => A=target+B => 2A=target+A+B => A=(target+sum)/2
     * 其中A为正号
     *
     * @param nums   数组
     * @param target 目标和
     * @return 解决目标和的个数
     */
    public int findTargetSumWays5(int[] nums, int target) {
        //计算数组和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //这些条件代表着没有满足题意的解
        if (sum < target || (sum + target) % 2 == 1 || (sum + target) < 0) {
            return 0;
        }
        //解决题目
        return getTarget(nums, (sum + target) / 2);
    }

    /**
     * 背包问题
     * 现有一组物品nums，选择是否加入背包正好使重量为sum
     *
     * @param nums
     * @param sum
     * @return
     */
    public int getTarget(int[] nums, int sum) {
        //dp数组
        int[][] dp = new int[nums.length + 1][sum + 1];
        //sum为0时，全部不选是唯一的一种解法
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }
        //遍历物品
        for (int i = 1; i <= nums.length; i++) {
            //遍历重量
            for (int j = 0; j <= sum; j++) {
                //当前的背包容量大于等于当前物品，更新状态
                if (j >= nums[i - 1]) {
                    //这个状态的更新由不放入物品和放入物品两种的和
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    //否则，只能不选择此物品
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        //返回结果
        return dp[nums.length][sum];
    }

    /**
     * 背包问题
     * 现有一组物品nums，选择是否加入背包正好使重量为sum
     * 状态压缩
     *
     * @param nums
     * @param sum
     * @return
     */
    public int getTarget2(int[] nums, int sum) {
        //dp数组
        int[] dp = new int[sum + 1];
        //sum为0
        dp[0] = 1;
        //遍历物品
        for (int i = 1; i <= nums.length; i++) {
            //遍历重量，从后往前遍历，因为要放置使用dp[j - nums[i - 1]]的时候状态已经被更新
            //我们使用的dp[j - nums[i - 1]]应该是上一层的状态，所以我们后面再进行状态的改变，于是要倒着遍历
            for (int j = sum; j >= 0; j--) {
                //当前的背包容量大于等于当前物品，更新状态
                if (j >= nums[i - 1]) {
                    //这个状态的更新由不放入物品和放入物品两种的和
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                } else {
                    //否则，只能不选择此物品
                    dp[j] = dp[j];
                }
            }
        }
        //返回结果
        return dp[sum];
    }
}
