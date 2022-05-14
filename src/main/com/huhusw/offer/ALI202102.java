package com.huhusw.offer;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/3b6dc1447d6d4ac4b9c2d45f1d4637ea
 * 数学问题
 * 给定x+y=A x*y=B，求x^n+y^n为多少
 * 对于题目本身来说，可以进行数学运算去化简
 * 化简的结果是 f[i] = A*f[i-1]-B*f[i-2] 成为一个递归数列
 * 因为溢出的问题，要特殊处理
 */
public class ALI202102 {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        final int mod = 1000000007;
        while (T > 0) {
            T--;
            //输入A B n三个数
            String[] s = sc.nextLine().split(" ");
            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);
            int n = Integer.parseInt(s[2]);
            //两个特殊情况
            if (n == 1) {
                System.out.println(2);
                return;
            }
            if (n == 2) {
                System.out.println(A);
                return;
            }
            //递归数列，因为只用到了三个数，所以这里使用三个数进行处理
            long dp1 = 2L;
            long dp2 = (long) A;
            long dp = 0L;
            //遍历n
            for (int i = 2; i <= n; i++) {
                //计算当前的i，按照数列的规则，但是相减可能会得到负数，所以加上一个mod
                dp = ((A * dp2) % mod - (B * dp1) % mod + mod) % mod;
                //更新两个值
                dp1 = dp2;
                dp2 = dp;
            }
            //结果
            System.out.println(dp);
        }
    }
}
