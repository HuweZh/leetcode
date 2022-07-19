package com.huhusw.sword2offer;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/wtcaE1/
 * 不含重复字符的最长字符串
 * 滑动窗口
 */
public class S016 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int res = 0;
        Set<Character> memo = new HashSet<>();
        while (right < n) {
            char c = s.charAt(right);
            if (memo.contains(c)) {
                res = Math.max(res, memo.size());
                memo.remove(s.charAt(left));
                left++;
            } else {
                memo.add(c);
                right++;
            }
        }
        res = Math.max(res, memo.size());
        return res;
    }
}
