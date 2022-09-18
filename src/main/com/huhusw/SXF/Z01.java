package com.huhusw.SXF;

import java.util.*;

public class Z01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a string字符串 字符串1
     * @param b string字符串 字符串2
     * @return int整型
     */
    public int minDistance(String a, String b) {
        // write code here
        int lenA = a.length();
        int lenB = b.length();
        int[][] dif = new int[lenA + 1][lenB + 1];
        for (int i = 0; i < lenA; i++) {
            dif[i][0] = i;
        }
        for (int i = 0; i < lenB; i++) {
            dif[0][i] = i;
        }
        int tmp;
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    tmp = 0;
                } else {
                    tmp = 1;
                }
                dif[i][j] = Math.min(dif[i - 1][j - 1] + tmp, dif[i][j - 1] + 1);
                dif[i][j] = Math.min(dif[i][j], dif[i - 1][j] + 1);
            }
        }
        return dif[lenA][lenB];
    }
}
