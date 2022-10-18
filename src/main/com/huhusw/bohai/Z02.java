package com.huhusw.bohai;

import java.util.*;

public class Z02 {
    static long n;
    static long s;
    static long a;
    static long b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        s = sc.nextLong();
        a = sc.nextLong();
        b = sc.nextLong();
        sc.close();
        for (long i = s - n * b; i <= s + n * a; i++) {
            find(1, i, i);
        }
        System.out.println(id % 100000007);
    }

    static long id = 0;

    private static void find(long d, long ss, long sum) {
        if (d == n && sum == s) {
            id++;
            id %= 100000007;
        } else if (d > n) {
            return;
        } else {
            long s1 = ss + a;
            find(d + 1, s1, sum + s1);
            long s2 = ss - b;
            find(d + 1, s2, sum + s2);

        }
    }
}
