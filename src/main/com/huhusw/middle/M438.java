package com.huhusw.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * 找到字符串中所有的字母异位词
 */
public class M438 {
    /**
     * 找到s中所有可能出现的p的全排列，返回索引
     *
     * @param s 字符串
     * @param p 字符串
     * @return 全排列出现的索引
     */
    public List<Integer> findAnagrams(String s, String p) {
        //结果
        List<Integer> res = new ArrayList<>();
        //保存p的字符和出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        //窗口是否满足题意的标志
        int sum = p.length();
        //左右边界
        int left = 0;
        int right = 0;
        //临时变量
        char c;
        int count;
        //遍历s字符串
        while (right < s.length()) {
            //滑动右边界
            c = s.charAt(right);
            right++;
            //检查是否需要更新标志
            if (map.containsKey(c)) {
                count = map.get(c);
                if (count > 0) {
                    sum--;
                }
                map.put(c, --count);
            }
            //标志位信号，滑动左边界
            while (sum == 0) {
                c = s.charAt(left);
                //是否需要更新标志位
                if (map.containsKey(c)) {
                    count = map.get(c);
                    if (count >= 0) {
                        //找到了一个全排列的位置，左边界就是出现的索引
                        if ((right - left) == p.length()) {
                            res.add(left);
                        }
                        sum++;
                    }
                    map.put(c, ++count);
                }
                left++;
            }
        }
        return res;
    }
}
