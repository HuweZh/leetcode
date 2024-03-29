package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 跳跃游戏2
 */
public class M45 {
    /**
     * 计算从起点跳到终点需要的最小步数
     *
     * @param nums 数组
     * @return 终点最小步数
     */
    public int jump(int[] nums) {
        //边界
        if (nums.length == 1) {
            return 0;
        }
        //定义dp数组，dp[i]是从起点跳到i的最小步数
        //初始值dp[0]=0
        int[] dp = new int[nums.length];
        //遍历数组的区间，在此区间内的格子一步就能跳到
        //区间右端点
        int max = nums[0];
        //更新右端点
        int newMax = 0;
        //区间左端点
        int index = 1;
        //更新dp数组
        while (true) {
            //在此区间内的格子从上一个格子一步就能跳到
            for (int i = index; i <= max; i++) {
                //到了终点
                if (i == nums.length - 1) {
                    return dp[index - 1] + 1;
                }
                //更新dp为上一个格子的步数加1
                dp[i] = dp[index - 1] + 1;
                //实时更新右端点
                newMax = Math.max(newMax, i + nums[i]);
            }
            //更新左端点和右端点
            index = max + 1;
            max = newMax;
        }
        // return 0;
    }

    /**
     * 局部贪心达到全局最优
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int step = 0;
        int maxPos = 0;
        int end = 0;
        //为什么不访问最后一个元素
        //因为end我们不访问最后一个元素，这是因为在访问最后一个元素之前，
        // 我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。
        // 如果访问最后一个元素，在边界正好为最后一个位置的情况下，我们会增加一次「不必要的跳跃次数」
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                step++;
            }
        }
        return step;
    }
}
