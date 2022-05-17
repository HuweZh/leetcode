package com.huhusw.offer;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/aaefe5896cce4204b276e213e725f3ea
 * 二叉树的个数
 * 给定一个节点数n和高度m，求在指定节点数不超过m的二叉树的个数
 * <p>
 * 动规，dp[i][j] 表示节点数为i，高度为j时的方案数
 * dp[i][j]的求法为前i-1个节点在高度为j-1时的方案总数
 * 遍历i-1个节点，分别充当左右节点，设k为左子树的节点数
 * 则dp[k][j-1]*dp[i-1-k][j-1]就是左右子树的构造方案数
 */
public class ALI202103 {
    public static void main(String[] args) {
        //输入n和m
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        //定义dp数组
        long[][] dp = new long[n + 1][m + 1];
        //当节点为0时，设置默认值为1，因为后面是需要的乘法
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 1;
        }
        //取余
        final int MOD = 1000000007;
        //外层循环，节点个数
        for (int i = 1; i <= n; i++) {
            //内层循环，高度
            for (int j = 1; j <= m; j++) {
                //节点间的循环
                for (int k = 0; k < i; k++) {
                    //更新dp[i][j]，根据左右子树的方案数
                    dp[i][j] = (dp[i][j] + dp[k][j - 1] * dp[i - k - 1][j - 1] % MOD) % MOD;
                }
            }
        }
        //结果
        System.out.println(dp[n][m]);
    }
}
