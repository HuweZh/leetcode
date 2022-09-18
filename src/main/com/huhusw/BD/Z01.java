package com.huhusw.BD;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        int res = 0;
        for (int i = 0; i < s.length() - 4; i++) {
            if (yuan(s, i + 1, i + 2, i + 4) && fu(s, i, i + 3)) {
                res++;
            }
        }
        System.out.println(res);
    }

    private static boolean fu(String s, int i, int i1) {
        if (s.charAt(i) == s.charAt(i1)) {
            return false;
        }
        if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
            return false;
        if (s.charAt(i1) == 'a' || s.charAt(i1) == 'e' || s.charAt(i1) == 'i' || s.charAt(i1) == 'o' || s.charAt(i1) == 'u')
            return false;
        return true;
    }

    private static boolean yuan(String s, int i, int i1, int i2) {
        if (s.charAt(i) == s.charAt(i1) || s.charAt(i) == s.charAt(i2) || s.charAt(i1) == s.charAt(i2)) {
            return false;
        }
        if (s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o' && s.charAt(i) != 'u')
            return false;
        if (s.charAt(i1) != 'a' && s.charAt(i1) != 'e' && s.charAt(i1) != 'i' && s.charAt(i1) != 'o' && s.charAt(i1) != 'u')
            return false;
        if (s.charAt(i2) != 'a' && s.charAt(i2) != 'e' && s.charAt(i2) != 'i' && s.charAt(i2) != 'o' && s.charAt(i2) != 'u')
            return false;
        return true;
    }
}
