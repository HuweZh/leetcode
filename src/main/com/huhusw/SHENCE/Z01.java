package com.huhusw.SHENCE;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.length() > 27) {
                System.out.println(-1);
                continue;
            }
            if (s.charAt(0) == '.' || s.charAt(s.length() - 1) == '.') {
                System.out.println(-1);
                continue;
            }
            if (!check(s)) {
                System.out.println(-1);
                continue;
            }
            String[] strings = s.split("\\.");
            if ("0".equals(strings[0])) {
                System.out.println(-1);
                continue;
            }
            boolean flag = false;
            long res = 0;
            for (String s1 : strings) {
                if ("".equals(s1)) {
                    res = res * 256;
                } else {
                    if (s1.length() > 3 || Integer.parseInt(s1) < 0 || Integer.parseInt(s1) > 255) {
                        flag = true;
                    }
                    if (s1.length() > 1 && s1.charAt(0) == '0') {
                        flag = true;
                    }
                    res = res * 256 + Integer.parseInt(s1);
                }

            }
            if (flag) {
                System.out.println(-1);
            } else {
                System.out.println(res);
            }
        }
        sc.close();
    }

    private static boolean check(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i) == '.' || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
                return false;
            }
        }
        return true;
    }
}
