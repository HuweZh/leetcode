package com.huhusw.offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://www.nowcoder.com/test/question/done?tid=57737731&qid=1453812
 * 压缩算法
 * 将相同的字符串进行压缩成[num|str]的形式，给定一个压缩后的字符串，还原字符串
 * <p>
 * 开始使用栈模拟，样例过了60%，不知道哪里出了问题，应该有些情况没有考虑到
 * 这里也是使用模拟
 */
public class TX01 {
    public static void main(String[] args) {
        TX01 tx01 = new TX01();
        tx01.compress("HG[3|B[2|CA]]F");
    }

    public String compress(String str) {
        if (!str.contains("[")) {
            return str;
        }
        // write code here
        StringBuilder sb = new StringBuilder(str);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[') {
                stack.push(i);
            } else if (str.charAt(i) == ']') {
                int l = stack.pop();
                int r = i;
                String s = helper(str, l, r);
                sb.delete(l, r + 1);
                sb.insert(l, s);
                break;
            }
        }
        return compress(sb.toString());
    }

    public String helper(String str, int l, int r) {
        String[] s = str.substring(l + 1, r).split("\\|");
        int num = Integer.parseInt(s[0]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(s[1]);
        }
        return sb.toString();
    }
}
