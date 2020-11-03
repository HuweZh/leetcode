package com.huhusw;

/**
 * @Author huhusw
 * @Date 2020/11/3
 */
public class S941 {
    public static void main(String[] args) {
        int[] A = {9,8,7,6,5,4,3,2,1,0};
        S941 s941 = new S941();
        boolean b = s941.validMountainArray(A);
        System.out.println(b);
    }

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int max = A[0];
        int min = A[A.length - 1];
        int left = -1;
        int right = -1;
        for (int i = 1; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
            } else {
                left = i - 1;
                break;
            }
        }
        for (int i = A.length - 2; i >= 0; i--) {
            if (min < A[i]) {
                min = A[i];
            } else {
                right = i + 1;
                break;
            }
        }
        return left == right;
    }
}
