package com.huhusw.XHS;

import java.util.*;

public class Z06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int i1 = 0;
            int i2 = 0;
            while (i1 != s1.length() && i2 != s2.length()) {
                if (s1.charAt(i1) == s2.charAt(i2)) {
                    i1++;
                    i2++;
                } else {
                    i1++;
                }
            }
            if (i2 == s2.length()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        sc.close();
    }
}
