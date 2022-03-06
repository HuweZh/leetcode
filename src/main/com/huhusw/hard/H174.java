package com.huhusw.hard;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/dungeon-game/
 * 地下城游戏
 */
public class H174 {
    //备忘录，消除重复子问题
    int[][] memo;

    /**
     * 计算骑士救出公主需要的最小血量
     *
     * @param dungeon 地牢的怪物分布
     * @return 骑士的最小血量
     */
    public int calculateMinimumHP(int[][] dungeon) {
        //初始化备忘录
        int m = dungeon.length;
        int n = dungeon[0].length;
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        //dp
        return dp(dungeon, 0, 0);
    }

    /**
     * dp函数，定义dp(i,j)为从(i,j)到救出公主需要的最小血量，于是题目的结果就是dp(0,0)
     * 普通的定义dp[i][j]为起点到(i,j)的血量，不行，因为不能确定到达该点的方向，需要考虑的情况很是麻烦
     * 反向定义会使问题变得简单
     * dp[i][j]的值取决于dp[i+1][j]和dp[i][j+1]，状态转移靠的就是这两个状态
     * 在知道dp[i+1][j]和dp[i][j+1]的情况下，怎么计算dp[i][j]呢？
     * 按照正常顺序，dp[i][j]+（dungeon[i+1][j] or dungeon[i][j+1]）=dp[i+1][j]和dp[i][j+1]
     * 所以反向应当相减
     *
     * @param dungeon 地牢
     * @param i       位置
     * @param j       位置
     * @return 从(i, j)到救出公主需要的最小血量
     */
    public int dp(int[][] dungeon, int i, int j) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        //base case
        //达到公主的牢房，此时只有一个房间，直接根据地牢值返回
        if (i == m - 1 && j == n - 1) {
            return dungeon[i][j] > 0 ? 1 : 1 - dungeon[i][j];
        }
        //超过了边界，返回一个不会取到的值
        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }
        //备忘录中有，直接返回，消除重复子问题
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        //在两个状态中选择血量需求量小的去计算当前地牢所需要的血量，两个状态返回的结果肯定都是正值
        int res = Math.min(dp(dungeon, i + 1, j), dp(dungeon, i, j + 1)) - dungeon[i][j];
        //当前地牢所需要的血量为负值时，不符合题意
        memo[i][j] = res > 0 ? res : 1;
        //返回当前结果
        return memo[i][j];
    }
}
