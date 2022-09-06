package com.huhusw.hard;

import java.util.*;

/**
 * https://leetcode.cn/problems/count-unique-characters-of-all-substrings-of-a-given-string/
 * 字符串中所有子串的唯一的字符
 * 统计一个字符串的所有子串中字符只出现一次的数量
 * 这里使用数学手段 xxxabadefaxxx 最中间的一个a是单个字符
 * 它的贡献是前后两个a之间的一部分，超过这部分，a就有两个，不会有贡献了
 * 即 badef 这个字符串包含a的全部贡献，有多少次贡献呢？
 * 前半段两个a的距离乘以后半段两个a的距离
 */
public class H828 {
    public int uniqueLetterString(String s) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
                map.get(c).add(-1);
            }
            map.get(c).add(i);
        }
        int res = 0;
        for (Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> lists = entry.getValue();
            lists.add(s.length());
            for (int i = 1; i < lists.size() - 1; i++) {
                res += (lists.get(i) - lists.get(i - 1)) * (lists.get(i + 1) - lists.get(i));
            }
        }
        return res;
    }
}
