package com.huhusw.XHS;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextLong();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        long stem = n;
        while (stem * 2 < k) {
            stem *= 2;
        }
        while (k > 2 * n) {
            if (k > stem) {
                k -= stem;
            }
            stem /= 2;
        }
        if (k <= n) {
            System.out.println(nums[(int) k - 1]);
        } else {
            System.out.println(nums[(int) (2 * n - k)]);
        }
    }
}
