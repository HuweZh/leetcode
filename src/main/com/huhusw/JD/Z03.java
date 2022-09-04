package com.huhusw.JD;

import java.util.*;
/*
定义一个括号串的权值为，他的最长合法括号子序列的长度，例如())())的权值为4，最长合法子序列为()()
现在求一个给定括号串的所有子串权值之和
 */
public class Z03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                res += cal(s, i, j);
            }
        }
        System.out.println(res);
    }

    private static long cal(String s, int i, int j) {
        int count = 0;
        for (int k = i; k <= j - 1; ) {
            if (s.charAt(k) == '(' && s.charAt(k + 1) == ')') {
                count++;
                k += 2;
            }
            k++;
        }
        return 2 * count;
    }
}
