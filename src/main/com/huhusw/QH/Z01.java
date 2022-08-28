package com.huhusw.QH;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n > 0) {
            n--;
            String s = sc.nextLine();
            String t = sc.nextLine();
            if (s.length() > t.length()) {
                System.out.println("NO");
            } else {
                s = cal(s);
                t = cal(t);
                if (s.equals(t)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }

    private static String cal(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
