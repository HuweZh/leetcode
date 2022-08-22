package com.huhusw.nio;

import java.util.Locale;
import java.util.Stack;

public class NIO {
    public static void main(String[] args) {
        System.out.println(reverseWord("we   are from   China"));
    }

    /**
     * 反转字符串
     *
     * @param str
     */
    public static String reverseWord(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < n; ) {
            StringBuilder sb = new StringBuilder();
            //空格
            if (!checkWord(chars[i])) {
                while (i < n && !checkWord(chars[i])) {
                    sb.append(chars[i]);
                    i++;
                }
            } else {
                while (i < n && checkWord(chars[i])) {
                    sb.append(chars[i]);
                    i++;
                }
            }
            stack.push(sb.toString());
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private static boolean checkWord(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
