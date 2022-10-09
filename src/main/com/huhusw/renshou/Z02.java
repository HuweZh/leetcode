package com.huhusw.renshou;

import java.util.*;

public class Z02 {
    static String[] words;
    static int n;
    static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        words = sc.nextLine().split(",");
        sc.close();
        n = s.length();
        System.out.println(dfs(0));
    }

    private static boolean dfs(int index) {
        if (index == n) {
            return true;
        }
        boolean res = false;
        for (int i = 0; i < words.length && !res; i++) {
            if (check(words[i], index)) {
                res |= dfs(index + words[i].length());
            }
        }
        return res;
    }

    private static boolean check(String word, int index) {
        int leftLength = n - index;
        if (word.length() > leftLength) {
            return false;
        }
        for (int i = 0; i < word.length(); i++, index++) {
            if (word.charAt(i) != s.charAt(index)) {
                return false;
            }
        }
        return true;
    }
}
