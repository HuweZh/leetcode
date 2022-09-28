package com.huhusw.simple;

import java.util.*;

/**
 * https://leetcode.cn/problems/check-if-the-sentence-is-pangram/
 * 是否包含全字母
 * 统计计数
 */
public class S1832 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            count[sentence.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
