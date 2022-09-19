package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/check-if-a-string-can-break-another-string/
 * 检查一个字符串是否可以打破另一个字符串
 * 字符串的任意排列所有的字符大于等于另一个字符的任意一种排列称为打破
 * 将字符串进行排序，挨个比较即可
 */
public class M1433 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public boolean checkIfCanBreak(String s1, String s2) {
        //词频统计
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        //构造字符串
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count1[i]; j++) {
                sb1.append((char) (i + 'a'));
            }
            for (int j = 0; j < count2[i]; j++) {
                sb2.append((char) (i + 'a'));
            }
        }
        //判断s1打破s2
        boolean flag = true;
        for (int i = 0; i < s1.length(); i++) {
            if (sb1.charAt(i) >= sb2.charAt(i)) {

            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            return true;
        }
        //判断s2打破s1
        flag = true;
        for (int i = 0; i < s2.length(); i++) {
            if (sb1.charAt(i) <= sb2.charAt(i)) {

            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * 排序对比，一趟排序即可完成
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkIfCanBreak2(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        //两者其中有一个为0表示未走到该分支，说明符合题意
        int more = 0;
        int less = 0;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] > c2[i]) {
                more++;
            } else if (c1[i] < c2[i]) {
                less++;
            }
        }
        return more == 0 || less == 0;
    }
}
