package com.huhusw.simple;

public class S1588 {
    public static void main(String[] args) {
        S1588 s1588 = new S1588();
        s1588.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3});
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;

        int[] odd = new int[50];
        int index = 0;
        for (int i = 1; i <= 100; i++) {
            //奇数
            if ((i & 1) == 1) {
                odd[index++] = i;
            }
        }
        for (int i = 0; i < odd.length; i++) {
            if (arr.length >= odd[i]) {
                for (int j = 0; j < arr.length; j++) {
                    res += arr[j];
                    if (j + odd[i] < arr.length) {
                        for (int k = 1; k < odd[i]; k++) {
                            res += arr[j + k];
                        }
                    }
                }
            } else {
                break;
            }
        }
        return res;
    }

    //暴力
    public int sumOddLengthSubarrays1(int[] arr) {
        int res = 0;

        for (int i = 0; i < arr.length / 2; i++) {
            int stem = 2 * i + 1;
            for (int j = 0; j <= (arr.length - stem); j++) {
                for (int k = 0; k < stem; k++) {
                    res += arr[j + k];
                }
            }
        }
        return res;
    }

    //前缀和
    public int sumOddLengthSubarrays2(int[] arr) {
        int res = 0;

        int[] preSum = new int[arr.length + 1];
        //初始状态为0
        preSum[0] = 0;
        for (int i = 1; i <= arr.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
        //长度区间为[start,end]的元素和为preSum[end+1]-preSum[start]
        for (int start = 0; start < arr.length; start++) {
            for (int length = 1; start + length <= arr.length; length += 2) {
                res += preSum[start + length] - preSum[start];
            }
        }

        return res;
    }
}
