package com.huhusw.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * 最小覆盖子串
 */
public class H76 {
    public static void main(String[] args) {
        H76 h76 = new H76();
        h76.minWindow("a", "aa");
    }

    /**
     * 找出s中最小覆盖t的子串
     * 滑动窗口，不满足题意时，滑动右边界，直到满足条件
     * 满足条件后滑动左边界，优化目标
     *
     * @param s 字符串
     * @param t 字符串
     * @return 子串
     */
    public String minWindow(String s, String t) {
        //将字符串t转为hash表存储，存储字符出现的次数
        Map<Character, Integer> tMap = new HashMap<>();
        //存储字符出现的次数
        for (int i = 0; i < t.length(); i++) {
            int count = tMap.getOrDefault(t.charAt(i), 0);
            tMap.put(t.charAt(i), count + 1);
        }
        //结果
        String res = s + t;
        //标志是否满足题意，为0时满足题意
        int sum = t.length();
        //窗口的左右边界，[left,right)，左闭右开区间
        int left = 0;
        int right = 0;
        //滑动窗口遍历字符串
        while (right < s.length()) {
            //不满足题意时，滑动右边界
            char c = s.charAt(right);
            //t中含有此字符
            if (tMap.containsKey(c)) {
                //此字符出现的次数
                int count = tMap.get(c);
                tMap.put(c, count - 1);
                //如果出现的次数大于0，证明满足t字符串中的字符未完全匹配
                //将标志位减减
                if (count > 0) {
                    sum--;
                }
            }
            right++;
            //满足题意时，滑动左边界优化目标
            while (sum == 0) {
                c = s.charAt(left);
                //只对t中的字符感兴趣
                if (tMap.containsKey(c)) {
                    int count = tMap.get(c);
                    tMap.put(c, count + 1);
                    //是时候退出了
                    if (count >= 0) {
                        //在退出循环的时候更新结果
                        String temp = s.substring(left, right);
                        res = res.length() < temp.length() ? res : temp;
                        sum++;
                    }
                }
                //滑动边界
                left++;
            }
        }
        //返回结果
        return res;
    }
}
