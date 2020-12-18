package com.huhusw;

public class S389 {
    public char findTheDifference(String s, String t) {
        int[] tNums = new int[26];
        for (int i = 0; i < t.length(); i++) {
            tNums[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            tNums[s.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (tNums[i] == 1) {
                return (char) (i + 'a');
            }
        }
        return 'a';
    }
}
