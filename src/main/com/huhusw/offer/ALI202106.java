package com.huhusw.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/e7a006abf5ec412a939f0d33725f06ed
 * 吃糖果，0-1背包
 * 每个人吃的糖果数是固定的，求在m个糖果下，能吃到糖果的最多人数
 * 还有一个条件是：约定，两人绑在一起，要么都吃，要么都不吃，将其数量看成2，丢弃掉其中一个人的需求即可
 * <p>
 * 动规，设dp[j]表示糖果数量为j时，人数为i时的最大人数
 * 本是一个二维数组，由于本次的状态只与上一层有关，可以进行状态压缩
 */
public class ALI202106 {
    public static void main(String[] args) {
        //输入 n 和 m
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //输入n个人的需求量，第二维是为了进行约定的绑定
        int[][] A = new int[n][2];
        for (int i = 0; i < n; i++) {
            A[i][0] = sc.nextInt();
            //初始值为-1
            A[i][1] = -1;
        }
        //输入k个约定
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int a = x > y ? y : x;
            int b = x > y ? x : y;
            //进行绑定，被绑的人会指向另一个人，另一个人的指向为空
            A[a - 1][1] = b - 1;
            A[b - 1][1] = -2;
        }
        //dp数组
        int[] dp = new int[m + 1];
        //遍历所有的人
        for (int i = 0; i < n; i++) {
            //此人的指向为空，跳过
            if (A[i][1] == -2) {
                continue;
            }
            int a = 0;
            int count = 0;
            //初始值，代表，这个人没有被约定，价值就是1
            //否则，约定过的价值为2
            if (A[i][1] == -1) {
                a = A[i][0];
                count = 1;
            } else {
                a = A[i][0] + A[A[i][1]][0];
                count = 2;
            }
            //更新dp，从后往前
            for (int j = m; j >= a; j--) {
                dp[j] = Math.max(dp[j], dp[j - a] + count);
            }
        }
        System.out.println(dp[m]);
    }
}
