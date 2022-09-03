package com.huhusw.SHENCE;

import java.util.*;

public class Z03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        long res = 0;
        int index1 = findMax(nums, 0, n - 1);
        int index2 = findMax(nums, 0, index1 - 1);
        int index3 = findMax(nums, index1 + 1, n - 1);
        res = Math.max(nums[index1]+nums[index2]-(index1-index2),nums[index1]+nums[index3]-(index3-index1));
        System.out.println(res);
    }

    private static int findMax(int[] nums, int left, int right) {
        if (left >= right) {
            return -1;
        }
        int max = 0;
        int index = -1;
        for (int i = left; i <= right; i++) {
            if (nums[i] - (i - left) > max) {
                max = nums[i] - (i - left);
                index = i;
            }
        }
        return index;
    }
}
/*
70
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        int left = 0;
        int right = n - 1;
        long res = 0;
        while (left < right) {
            int index = findMax(nums, left, right);
            if (index == -1) {
                break;
            }
            for (int i = 0; i < index; i++) {
                res = Math.max(res, nums[i] + nums[index]-(index-i));
            }
            left = index + 1;
        }
        System.out.println(res);
    }

    private static int findMax(int[] nums, int left, int right) {
        if (left >= right) {
            return -1;
        }
        int max = 0;
        int index = -1;
        for (int i = left; i <= right; i++) {
            if (nums[i] - (i - left) > max) {
                max = nums[i] - (i - left);
                index = i;
            }
        }
        return index;
    }
 */
