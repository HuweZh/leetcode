package com.huhusw.dd;

import java.util.*;

public class Z02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] samples = new int[n];
        for (int i = 0; i < n; i++) {
            samples[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(samples);
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < n) {
            if (samples[right] - samples[left] <= k) {
                right++;
                res = Math.max(res, right - left);
            } else {
                left++;
            }
        }
        System.out.println(res);
    }
}
