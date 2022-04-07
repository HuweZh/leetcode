package com.huhusw.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 * 字符串的排列
 */
public class M567 {
    public static void main(String[] args) {
        M567 m567 = new M567();
        m567.checkInclusion("adc", "dcda");
    }

    /**
     * s2中是否有s1字符的排列，中间不能有其他字符
     * 滑动窗口，当更新结果的时候判断窗口的大小是否等于s1的长度
     *
     * @param s1 字符串
     * @param s2 字符串
     * @return s2中是否有s1字符的排列
     */
    public boolean checkInclusion(String s1, String s2) {
        //存储s1的字符和个数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        //标志是否能进行窗口左边界的滑动
        int sum = s1.length();
        //左右边界
        int left = 0;
        int right = 0;
        //遍历s2
        while (right < s2.length()) {
            //滑动右边界
            //当前元素是s1中的字符
            if (map.containsKey(s2.charAt(right))) {
                //当前字符的剩余出现次数
                int count = map.get(s2.charAt(right));
                //还能出现，则标志位减减
                if (count > 0) {
                    sum--;
                }
                //剩余次数减一当如hash
                map.put(s2.charAt(right), --count);
            }
            right++;
            //滑动左边界
            while (sum == 0) {
                //当前元素是s1中的字符，判断是否更新标志位
                if (map.containsKey(s2.charAt(left))) {
                    //剩余出现次数大于等于0，证明可以退出循环，该字符在窗口中出现的频次不够
                    int count = map.get(s2.charAt(left));
                    if (count >= 0) {
                        //判断是否符合题意
                        if (right - left == s1.length()) {
                            return true;
                        }
                        //修改标志位
                        sum++;
                    }
                    //放入hash
                    map.put(s2.charAt(left), ++count);
                }
                left++;
            }
        }
        return false;
    }
}
