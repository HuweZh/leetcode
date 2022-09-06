package com.huhusw.XHS;

import java.util.*;

public class Z04 {
    public static void main(String[] args) {
        for (long i = 1; i <10000; i++) {
            cal(6, 6, i, new int[]{1, 2, 3,4,5,6});
        }
//        cal(3, 3, (long) Integer.MAX_VALUE + 1000, new int[]{1, 2, 3});
    }

    public static void cal(int n, int m, long k, int[] nums) {
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
