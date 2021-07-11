package com.huhusw.middle;

import java.util.Arrays;

public class M274 {
    public static void main(String[] args) {
        M274 m274 = new M274();
        int i = m274.hIndex(new int[]{1, 0, 1, 6, 5});
        System.out.println(i);
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (citations[i] == n - i) {
                return citations[i];
            } else if (citations[i] > n - i) {
                res = Math.max(res, n - i);
            }
        }
        return res;
    }
}
