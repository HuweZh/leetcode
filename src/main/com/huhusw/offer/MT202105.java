package com.huhusw.offer;

import java.util.Scanner;

/**
 * 烤蛋糕
 * 一家店铺每天烤n个蛋糕，现在烤了m个
 * 客人要求，想要最轻和最重的蛋糕，且重量恰好为a和b
 * 签到题
 */
public class MT202105 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //输入
            String[] str = sc.nextLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int a = Integer.parseInt(str[2]);
            int b = Integer.parseInt(str[3]);
            //计算a和b的大小
            int MIN = Math.min(a, b);
            int MAX = Math.max(a, b);
            str = sc.nextLine().split(" ");
            int min = 1001;
            int max = -1;
            int count = 2;
            //记录当前烤出来的最轻和最重，后面没烤的肯定能满足要求
            for (int i = 0; i < m; i++) {
                min = Math.min(min, Integer.parseInt(str[i]));
                max = Math.max(max, Integer.parseInt(str[i]));
            }
            //当前的已经超出范围
            if (min < MIN || max > MAX) {
                System.out.println("NO");
            } else {
                //计算是否有满足题意的蛋糕数量
                if (min == MIN) {
                    count--;
                }
                if (max == MAX) {
                    count--;
                }
                count -= n - m;
                //满足题意
                if (count <= 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
