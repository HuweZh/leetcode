package com.huhusw.WEBIKE;

import java.util.*;

public class Z03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        sc.close();
        Arrays.sort(nums);

        long res = nums[0];
        for (int i = 0; i < n; i++) {
            nums[i] -= nums[0];
        }
        while (m > 0) {
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) {
                    m -= 1;
                } else {
                    nums[i] -= 1;
                }
            }
            if (m >= 0) {
                res++;
            }
        }
        System.out.println(res);
//        int left = 0;
//        int right = n - 1;
//        while (left < right) {
//            int mid = (left + right) / 2;
//            if (check(nums, mid, 0, m)) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        System.out.println(left+1);
    }

    private static boolean check(long[] nums, int mid, int start, long m) {
        long sum = 0;
        for (int i = start; i <= mid; i++) {
            sum += nums[mid] - nums[i];
            if (sum > m) {
                return false;
            }
        }
        return true;
    }
}
