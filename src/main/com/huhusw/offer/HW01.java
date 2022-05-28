package com.huhusw.offer;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/fe298c55694f4ed39e256170ff2c205f
 * 汽水瓶，使用三个空瓶可以跟老板换一个新的汽水
 * 可以向老板借空汽水瓶，但是要换，求最多喝到多少汽水
 * 对于3的倍数，可以直接喝并且直接兑换，剩下的重复操作，直到手里的空瓶小于3
 * 等于2时，可以借一个，并还
 * 小于2时，不能借，停止循环
 */
public class HW01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入
        while (sc.hasNext()) {
            int n = sc.nextInt();
            //题目要求
            if (n == 0) {
                return;
            }
            //结果
            int res = 0;
            while (true) {
                //先算能换的瓶子树
                res += n / 3;
                //剩余的瓶子数
                n = n / 3 + n % 3;
                //边界情况
                if (n == 2) {
                    System.out.println(res + 1);
                    break;
                } else if (n < 2) {
                    System.out.println(res);
                    break;
                }
            }
        }
    }

    /**
     * 有递推公式
     * f(0)=0
     * f(1)=0
     * f(2)=1
     * f(3)=f(1)+1  相当于3个瓶子换一个汽水，手里还剩1个瓶子
     * f(4)=f(2)+1  相当于3个瓶子换一个汽水，手里还剩2个瓶子
     * f(5)=f(3)+1  相当于3个瓶子换一个汽水，手里还剩3个瓶子
     * ...
     * f(n)=f(n-2)+1
     *
     * @param args
     */
    public static void main2(String[] args) {
        int[] res = new int[101];
        res[2] = 1;
        for (int i = 3; i < 101; i++) {
            res[i] = res[i - 2] + 1;
        }
        Scanner sc = new Scanner(System.in);
        //输入
        while (sc.hasNext()) {
            int n = sc.nextInt();
            //题目要求
            if (n == 0) {
                return;
            }
            //结果
            System.out.println(res[n]);
        }
    }
}
