package com.huhusw.unity;

import sun.util.resources.cldr.ig.CurrencyNames_ig;

import java.math.BigInteger;
import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Z01 z01 = new Z01();
        System.out.println(z01.FillArray(new int[]{0, 4, 5}, 6));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a int整型一维数组
     * @param k int整型
     * @return int整型
     */
    public int FillArray(int[] a, int k) {
        int start = 1;
        int end = k;
        int count = 0;
        BigInteger res = BigInteger.ONE;

        int[] a1 = new int[a.length + 2];
        a1[0] = 1;
        a1[a.length + 1] = k;
        System.arraycopy(a, 0, a1, 1, a.length);

        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != 0) {
                if (count == 0) {
                    start = Math.max(1, a1[i]);
                } else {
                    end = Math.min(a1[i], k);
                    res = res.multiply(BigInteger.valueOf(partialFillArray(start, count, end)));
                    count = 0;
                    start = end;
                }
            } else {
                count++;
            }
        }
        return mod(res);
    }

    private static final long MOD = 1000000007L;
    private static final int THRESHOLD = 10;

    private int partialFillArray(int start, int count, int end) {
        int n = end - start + 1;
        if (count < THRESHOLD || n < THRESHOLD)
            return partialFillArray(n, count);
        else
            return bigIntPartialFillArray(n, count);
    }

    private int bigIntPartialFillArray(int n, int count) {
        BigInteger[] arr = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            arr[i] = BigInteger.ONE;
        }
        for (int i = 1; i < count; i++) {
            for (int j = n - 2; j >= 0; j--) {
                arr[j] = arr[j].add(arr[j + 1]);
            }
        }
        BigInteger sum = Arrays.stream(arr).reduce(BigInteger.ZERO, (x, y) -> x = x.add(y));
        return mod(sum);
    }

    private int mod(BigInteger sum) {
        return sum.remainder(BigInteger.valueOf(MOD)).intValue();
    }

    private int partialFillArray(int n, int count) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }
        for (int i = 1; i < count; i++) {
            for (int j = n - 2; j >= 0; j--) {
                arr[j] = arr[j] + arr[j + 1];
            }
        }
        return Arrays.stream(arr).sum();
    }
}
