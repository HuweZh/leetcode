package com.huhusw.WY;

import java.util.*;

public class Z04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        int res = 0;
        int third = 0;
        int second = 1;
        int first = 1;
        for (int i = 0; i < n; i++) {
            if (i != n - 1 && nums[i] == nums[i + 1]) {
                first++;
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (nums[j] >= nums[i]) {
                    continue;
                }
                if (j != n - 1 && nums[j] == nums[j + 1]) {
                    second++;
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] == nums[i]) {
                        third++;
                    }
                }
                res += first * second * third;
                third = 1;
            }
            second = 1;
            first = 1;
        }
        System.out.println(res);
    }
}
