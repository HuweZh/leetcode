package com.huhusw.BY;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t > 0) {
            t--;
            String[] strings = sc.nextLine().split(" ");
            int n = Integer.parseInt(strings[0]);
            int k = Integer.parseInt(strings[1]);
            String str = sc.nextLine();
            int res = 0;
            for (int i = 0; i < str.length() - 1; i++) {
                res += (str.charAt(i) - '0') * 10 + (str.charAt(i + 1) - '0');
            }
            System.out.println(res);
        }
        sc.close();
    }
}
