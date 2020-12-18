package com.huhusw;

import java.util.Arrays;

public class S1370 {
    public static void main(String[] args) {
        S1370 s1370 = new S1370();
        String leetcode = s1370.sortString("aaaaaaa");
        System.out.println(leetcode);
        System.out.println(leetcode.equals("aaaaaaa"));
        System.out.println(leetcode == "aaaaaaa");
    }

    public String sortString(String s) {
        StringBuilder result = new StringBuilder("");

        int[] word = new int[26];
        for (int i = 0; i < s.length(); i++) {
            word[s.charAt(i) - 'a']++;
        }
//        for (int i = 0; i < s.length(); i++) {
//            System.out.println(word[i]);
//        }
        while (result.length() != s.length()) {
            //前三步，搞定小值
            for (int i = 0; i < 26; i++) {
                if (word[i] != 0) {
                    result.append((char) (i + Integer.valueOf('a')));
                    word[i]--;
                }
            }
            //后面三步，搞定大值
            for (int i = 25; i >= 0; i--) {
                if (word[i] != 0) {
                    result.append((char) (i + Integer.valueOf('a')));
                    word[i]--;
                }
            }
        }
        return result.toString();
    }
}
