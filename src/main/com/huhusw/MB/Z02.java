package com.huhusw.MB;

import java.util.*;
import java.lang.String;

public class Z02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(scores);

        int left = 0;
        int right = left + 2;
        int res = 0;
        while (left < n) {
            if (left + 2 < n && scores[left + 2] - scores[left] <= 10) {
                left += 3;
                res++;
            } else if (left + 1 < n && scores[left + 1] - scores[left] <= 20) {
                left += 2;
                res++;
            } else {
                left++;
                res++;
            }
//            if (scores[right] - scores[left] <= 10 || scores[right] - scores[left] <= 20 || right == left) {
//                res++;
//                right++;
//                left = right;
//            } else {
//                right--;
//            }
//            if (scores[right] - scores[left] <= 10) {
//                if (right - left == 2) {
//                    res++;
//                    right++;
//                    left = right;
//                } else {
//                    right++;
//                }
//            } else if (scores[right] - scores[left] <= 20) {
//                if (right - left == 1) {
//                    res++;
//                    right++;
//                    left = right;
//                } else {
//                    right++;
//                }
//            } else {
//                res++;
//                left++;
//            }
        }
        System.out.println(res);
    }
}
