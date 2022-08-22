package com.huhusw.LEN;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        while (k > 0) {
            k--;
            int[] stem = new int[n];
            for (int i = 0; i < n; i++) {
                stem[i] = nums[i] % 2;
            }
            for (int i = 0; i < n; i++) {
                int left = (i - 1 + nums.length) % nums.length;
                int right = (i + 1) % nums.length;
                stem[left] += nums[i] / 2;
                stem[right] += nums[i] / 2;
            }
            nums = stem;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
