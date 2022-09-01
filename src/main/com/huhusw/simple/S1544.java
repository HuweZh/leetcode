package com.huhusw.simple;

import java.util.*;

/**
 * https://leetcode.cn/problems/make-the-string-great/
 * 整理字符串
 * 相邻的字符为大小写可以删除
 * 模拟
 */
public class S1544 {
    public String makeGood(String s) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) ('a' + i), (char) ('A' + i));
            map.put((char) ('A' + i), (char) ('a' + i));
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.offerLast(s.charAt(i));
            } else {
                if (map.get(s.charAt(i)) == stack.peekLast()) {
                    stack.pollLast();
                } else {
                    stack.offerLast(s.charAt(i));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.poll());
        }
        return sb.toString();
    }
}
