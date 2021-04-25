package com.huhusw;

/**
 * @author huhusw
 * @Description
 * @create 2021-04-24 10:27
 */
public class M377 {
    public static void main(String[] args) {
        M377 m377 = new M377();
        int i = m377.combinationSum4(new int[]{1, 2, 3}, 4);
        System.out.println(i);

    }

    public int combinationSum4(int[] nums, int target) {
        //返回结果，dp[i]表示target为i时的总方案数
        int[] dp = new int[target + 1];
        //初始条件，target为0时，只有一种序列满足条件，就是什么都不拿
        dp[0] = 1;
        //遍历一遍数组
        //状态转移方程 dp[i] = dp[i-num](i>=num)
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

}
