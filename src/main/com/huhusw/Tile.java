package com.huhusw;

import javax.rmi.CORBA.Tie;

public class Tile {
    public static void main(String[] args) {
        Tile tile = new Tile();
        int i = tile.putTile(3, 2);
        System.out.println(i);
    }

    /**
     * 铺砖
     * 给面积为n*k的地板铺1*k的砖，返回方案数
     * 建议实现，还没有考虑边界情况
     * @param n
     * @param k
     * @return
     */
    public int putTile(int n, int k) {
        //dp数组，dp[i]表示i*k的面积被覆盖的方案数
        int[] dp = new int[n+1];
        //小于k的情况下，只有一种方案，竖着铺
        for (int i = 1; i < k; i++) {
            dp[i] = 1;
        }
        //等于k时，横着铺，竖着铺，两种方案
        dp[k] = 2;
        //剩下的方案进行dp更新
        for (int i = k + 1; i <= n; i++) {
            //当面积为i*k时，有两种情况
            //第一种：铺了一个竖着的，剩下的面积为(i-1)*k，对应dp[i-1]
            //第二种：铺了一个横着的，横着的下面空出来的部分也需要用横着的填充，剩下的面积Wie(i-k)*k，对应dp[i-k]
            dp[i] = dp[i - 1] + dp[i - k];
            //放置数值太大
            dp[i] %= 0x3f3f3f3f;
        }
        //返回结果
        return dp[n];
    }
}
