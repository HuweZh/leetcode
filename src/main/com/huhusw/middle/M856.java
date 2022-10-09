package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/score-of-parentheses/
 * 括号的分数
 * 一个只包含括号的字符串有两种分数计算方式，AB的分数是A+B,(A)的分数是2*A，（）的分数是1,
 * 给定一个字符串，计算他的分数
 */
public class M856 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
        M856 m856 = new M856();
        m856.scoreOfParentheses("(())");
    }

    /**
     * 计算模式串的分数
     * 分治计算，因为A和B是一个完整的字符串表达式，也就是左右括号包裹着
     * 另左括号为1，右括号为-1，子串的和为0时为一个正确的表达式
     * 子串的长度如果恰好为字符串的长度，那么说明当前只有一个表达式，也就是（A）
     * 否则说明有两种表达式AB的形式，分别计算即可
     * 分治递归
     *
     * @param s 待计算的字符串
     * @return
     */
    public int scoreOfParentheses(String s) {
        if (s.length() == 2) {
            return 1;
        }
        int len = 0;
        int bal = 0;
        for (int i = 0; i < s.length(); i++) {
            bal += s.charAt(i) == ')' ? -1 : 1;
            if (bal == 0) {
                len = i + 1;
                break;
            }
        }
        //(A)的形式，计算中间A的表达式
        if (len == s.length()) {
            return 2 * scoreOfParentheses(s.substring(1, len - 1));
        } else {
            //AB形式，分别计算A和B
            return scoreOfParentheses(s.substring(0, len)) + scoreOfParentheses(s.substring(len));
        }
    }

    /**
     * 栈模拟
     * 将原字符串看成空串+原串的模式
     * 空串和左括号，都在栈中填0，表示当前的模式不满足题意
     * 遇见右括号时，需要弹出数字进行计算
     * 每次弹出的一定是一个合法的字符串，
     * 首先弹出两个括号之间的数字，这个数字的结果只能是2*v或1
     * 然后再弹出左括号与前面弹出的完整表达式相加，再次压栈
     * 栈顶的值就是所求
     *
     * @param s
     * @return
     */
    public int scoreOfParentheses2(String s) {
        Deque<Integer>stack = new LinkedList<>();
        stack.push(0);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(0);
            }else{
                int v = stack.pop();
                int num = stack.pop()+Math.max(2*v,1);
                stack.push(num);
            }
        }
        return stack.peek();
    }
}
