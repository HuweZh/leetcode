package com.huhusw.MB;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        if (s.length() == 1 || s.charAt(0) != '1') {
            System.out.println(-1);
            return;
        }
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '3') {
                res++;
            } else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(res);
    }
}
