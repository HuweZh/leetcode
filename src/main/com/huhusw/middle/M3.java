package com.huhusw.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 无重复字符的最长子串
 */
public class M3 {

    /**
     * 找到s中无重复字符的最长子串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        //hash，监督是否有重复字符
        Set<Character> set = new HashSet<>();
        //右边界
        int right = 0;
        //结果
        int res = 0;
        //枚举左边界
        for (int i = 0; i < s.length(); i++) {
            //i=0是初始化，不会产生重复元素
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            //移动右边界
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            //更新结果，窗口大小
            res = Math.max(res, right - i);
        }
        return res;
    }
}
