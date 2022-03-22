package com.huhusw.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 * 为运算表达式设计优先级
 */
public class M241 {
    public static void main(String[] args) {
        M241 m241 = new M241();
        m241.diffWaysToCompute("2*3-4*5");
    }

    /**
     * 不同的计算优先级得到的答案
     *
     * @param expression 表达式
     * @return 所有可能的答案
     */
    public List<Integer> diffWaysToCompute(String expression) {
        //边界情况
        if (expression.length() == 0) {
            return new ArrayList<>();
        }
        //结果
        List<Integer> res = new ArrayList<>();
        //只是一个数字
        if (expression.indexOf("*") == -1 && expression.indexOf("+") == -1 && expression.indexOf("-") == -1) {
            res.add(Integer.parseInt(expression));
            return res;
        }
        List<Integer> res1;
        List<Integer> res2;
        //遍历表达式
        for (int i = 0; i < expression.length(); i++) {
            //判断是否为运算符，以运算符为中点，划分为左右两侧
            if (isOp(expression.charAt(i))) {
                //左侧的计算结果
                res1 = diffWaysToCompute(expression.substring(0, i));
                //右侧的计算结果
                res2 = diffWaysToCompute(expression.substring(i + 1, expression.length()));
                //遍历两侧的结果进行计算
                for (int j = 0; j < res1.size(); j++) {
                    for (int k = 0; k < res2.size(); k++) {
                        res.add(cal(res1.get(j), res2.get(k), expression.charAt(i)));
                    }
                }
            }
        }
        //返回结果
        return res;
    }

    /**
     * 根据符号的不同选择计算的方式
     *
     * @param num1
     * @param num2
     * @param c
     * @return
     */
    public int cal(int num1, int num2, char c) {
        switch (c) {
            case '*':
                return num1 * num2;
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
        }
        return 0;
    }

    /**
     * 判断字符是否为运算符
     *
     * @param c
     * @return
     */
    public boolean isOp(char c) {
        if (c == '*' || c == '+' || c == '-') {
            return true;
        }
        return false;
    }
}
