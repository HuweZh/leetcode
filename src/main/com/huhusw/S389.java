package com.huhusw;

public class S389 {
    public char findTheDifference(String s, String t) {
        // 散列表存储字符数量
        int[] tNums = new int[26];
        //保存t的字符数量
        for (int i = 0; i < t.length(); i++) {
            tNums[t.charAt(i) - 'a']++;
        }
        //减去s的字符数量
        for (int i = 0; i < s.length(); i++) {
            tNums[s.charAt(i) - 'a']--;
        }
        //剩下一个字符就是多的那个
        for (int i = 0; i < 26; i++) {
            if (tNums[i] == 1) {
                return (char) (i + 'a');
            }
        }
        //不会输出的情况
        return '0';
    }
}
