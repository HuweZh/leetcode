package com.huhusw.dd;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int u = sc.nextInt();
        int v = sc.nextInt();
//        int[] a = new int[n];
        long sumA = 0;
        for (int i = 0; i < n; i++) {
//            a[i] = sc.nextInt();
            sumA += sc.nextInt();
        }
//        int[] b = new int[n];
        long sumB = 0;
        for (int i = 0; i < n; i++) {
//            b[i] = sc.nextInt();
            sumB += sc.nextInt();
        }
        sc.close();

        int a = (int) (sumA / x);
        if (sumA % x != 0) {
            a += 1;
        }
        int b = (int) (sumB / y);
        if (sumB % y != 0) {
            b += 1;
        }
        long sum = a + b;
        long res = 0;
        if (v < u) {
            res = ((sum + 1) / 2) * v;
        } else if (v > u && v < 2 * u) {
            res = (sum / 2) * v;
            res += sum % 2 == 0 ? 0 : u;
        } else if (v > 2 * u) {
            res = sum * u;
        }
        System.out.println(res);
    }
}
