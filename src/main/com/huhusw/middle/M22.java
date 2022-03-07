package com.huhusw.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 生成括号
 */
public class M22 {
    //结果
    List<String> res;

    /**
     * 提供n个括号，生成所有的可能排序
     *
     * @param n 括号个数
     * @return 所有的排序
     */
    public List<String> generateParenthesis(int n) {
        //初始化结果
        res = new ArrayList<>();
        //生成所有可能的结果
        generate("", n, n);
        return res;
    }

    /**
     * 生成有left个左括号和right个右括号的所有可能结果
     *
     * @param str   占位作用
     * @param left  左括号个数
     * @param right 右括号个数
     */
    public void generate(String str, int left, int right) {
        //所有的括号用完了
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        //左右括号个数相等，只能使用左括号
        if (left == right) {
            generate(str + "(", left - 1, right);
        }
        //左括号个数小于右括号个数，可以使用左括号也可以使用右括号
        else {
            //使用左括号
            if (left > 0) {
                generate(str + "(", left - 1, right);
            }
            //使用右括号
            generate(str + ")", left, right - 1);
        }
    }
}
