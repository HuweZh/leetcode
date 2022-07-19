package com.huhusw.sword2offer;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/MPnaiL/
 * s2是否包含s1的其中一种排列
 * 滑动窗口设为n，统计滑动窗口内的字符个数，相等就是true
 */
public class S014 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int n = s1.length();
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < s2.length(); i++) {
            cnt2[s2.charAt(i - n) - 'a']--;
            cnt2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}
