package com.huhusw.unity;

import java.util.*;

public class Z02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @return int整型
     */
    public int StrToInt(String s) {
        // write code here
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int sign = 1;
        long num = 0;
        int i = 0;
        while (i < len && s.charAt(i) == ' ') i++;

        if (i < len) {
            if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (s.charAt(i) == '+') {
                i++;
            }
        }
        while (i < len) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + (s.charAt(i) - '0');
                if (sign == -1 && num * (-1) < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                } else if (sign == 1 && num > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                i++;
            } else {
                break;
            }
        }
        int res = (int) num;
        res *= sign;
        return res;
    }
}
