package com.huhusw.XHS;

import java.util.*;

public class Z02 {
    static int[] nums1;
    static int[] nums2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nums1 = new int[30];
        nums2 = new int[30];
        int res1 = 0;
        int res2 = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x > 7) {
                res1 += x - 7;
                res2 += x - 7;
                x = 7;
            }
            if (x < -7) {
                res1 += (-7 - x);
                res2 += (-7 - x);
                x = -1;
            }
            nums1[x + 7]++;
        }
        sc.close();
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        int c = Integer.MAX_VALUE;
        int d = Integer.MAX_VALUE;
        for (int i = -7; i <= -1; i++) {
            if (nums1[i + 7] != 0) {
                if (dis(-7, a) > dis(-7, i)) a = i;
                if (dis(-1, b) > dis(-1, i)) b = i;
                if (dis(1, c) > dis(1, i)) c = i;
                if (dis(7, d) > dis(7, i)) d = i;
            }
            nums2[i + 7] = nums1[i + 7];
        }
        for (int i = 1; i < 7; i++) {
            if (nums1[i + 7] != 0) {
                if (dis(-7, a) > dis(-7, i)) a = i;
                if (dis(-1, b) > dis(-1, i)) b = i;
                if (dis(1, c) > dis(1, i)) c = i;
                if (dis(7, d) > dis(7, i)) d = i;
            }
            nums2[i + 7] = nums1[i + 7];
        }
        if (nums1[0 + 7] != 0) {
            if (dis(-7, a) > dis(-7, 0)) a = 0;
            if (dis(-1, b) > dis(-1, 0)) b = 0;
            if (dis(1, c) > dis(1, 0)) c = 0;
            if (dis(7, d) > dis(7, 0)) d = 0;
        }
        nums2[0 + 7] = nums1[0 + 7];
        int count = 0;
        res1+=dis(a,-7);
        nums1[a+7]--;
        res1+= dis(b,-1);
        nums1[b+7]--;
    }

    private static int dis(int i, int i1) {
        if (i * i1 < 0) return Math.abs(i) + Math.abs(i1);
        else return Math.abs(i - i1);
    }
}
