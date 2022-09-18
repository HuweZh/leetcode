package com.huhusw.DXM;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            int[] count = new int[26];
            for (int j = 0; j < s.length(); j++) {
                count[s.charAt(j) - 'a']++;
            }
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 26; j++) {
                if (count[j] != 0) {
                    max = Math.max(max, count[j]);
                    min = Math.min(min, count[j]);
                }
            }
            res = Math.max(res, max - min);
        }
        System.out.println(res);
        scanner.close();
    }
}
