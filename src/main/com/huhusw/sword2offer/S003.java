package com.huhusw.sword2offer;

/**
 * https://leetcode.cn/problems/JFETK5/
 * 计算[0,n]之间每个数的1的个数
 */
public class S003 {
    public static void main(String[] args) {
        S003 s03 = new S003();
        s03.countBits(2);
    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            res[i] = countBits2(i);
        }
        return res;
    }

    public int countBits2(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }

    /**
     * 更快实现
     *
     * @param n
     * @return
     */
    public int countBits3(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }
}
