package com.huhusw.SXF;

import java.util.*;

public class Z02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        int res = 0;
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int l = a[i] - x;
            int h = a[i] + x;
            if (left > h || right < l) {
                left = l;
                right = h;
                res++;
            } else {
                left = Math.max(left, l);
                right = Math.min(right, h);
            }
        }
        System.out.println(res);
    }
}
