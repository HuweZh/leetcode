package com.huhusw.sword2offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/VabMRr/
 * 找出字符串中的所有变位词
 * 滑动窗口，每次滑动判断字符数量是否相等
 */
public class S015 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if (n < m) {
            return res;
        }
        int[] cntS = new int[26];
        int[] cntP = new int[26];
        for (int i = 0; i < m; i++) {
            cntS[s.charAt(i) - 'a']++;
            cntP[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cntS, cntP)) {
            res.add(0);
        }
        for (int i = m; i < n; i++) {
            cntS[s.charAt(i - m) - 'a']--;
            cntS[s.charAt(i) - 'a']++;
            if (Arrays.equals(cntS, cntP)) {
                res.add(i - m + 1);
            }
        }
        return res;
    }
}
