package com.huhusw.offer;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/85e7e341dc764ae1866b9525c1937225
 * 方案总数，从起点到终点的方案数
 * 没读懂题目的意思
 * 看题解的意思是把每一个节点的能量都消耗了一遍，四重循环暴力解决
 */
public class ALI202107 {
    public static void main(String[] args) {
        //输入数据组数
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            T--;
            //每一组的数据
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            //定义dp数组，进行地图的遍历
            int[][] dp = new int[n][m];
            //初始值是(0,0)到(0,0)，步数为1
            dp[0][0] = 1;
            //遍历棋盘
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    //获取当前的能量值
                    int energy = grid[i][j];
                    //将所有能到的点，遍历出来并加上当前点的方案数
                    for (int dx = 0; dx <= energy; dx++) {
                        for (int dy = 0; dy <= energy - dx; dy++) {
                            if (dx == 0 && dy == 0) continue;
                            int nx = i + dx;
                            int ny = j + dy;
                            if (nx >= n || ny >= m) continue;
                            dp[nx][ny] = (dp[i][j] + dp[nx][ny]) % 10000;
                        }
                    }
                }
            }
            System.out.println(dp[n - 1][m - 1]);
        }
    }
}
