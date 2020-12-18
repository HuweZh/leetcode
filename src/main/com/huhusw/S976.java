package com.huhusw;

import java.util.Arrays;

public class S976 {
    public int largestPerimeter(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int length = 0;
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return length;
    }
}
