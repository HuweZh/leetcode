package com.huhusw.TXMUSIC;

import java.util.*;

public class Z01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 返回满足题意的最小操作数
     *
     * @param str string字符串 给定字符串
     * @return int整型
     */
    public int minOperations(String str) {
        // write code here
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        int res = 0;
        while (true) {
            int curIndex = check(count);
            if (curIndex == -1) {
                break;
            }
            count[curIndex] -= 2;
            add(count);
            res++;
        }
        return res;
    }

    private void add(int[] count) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (count[i] < min) {
                min = count[i];
                index = i;
            }
        }
        count[index]++;
    }

    private int check(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] > 1) {
                return i;
            }
        }
        return -1;
    }
}
