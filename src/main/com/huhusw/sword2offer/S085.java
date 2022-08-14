package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/IDBivT/
 * 所有的可能括号数
 */
public class S085 {
    //结果
    List<String> res = new ArrayList<>();
    //中途保护序列
    StringBuilder sb = new StringBuilder();
    //回溯的终止条件
    int len;

    public List<String> generateParenthesis(int n) {
        len = n * 2;
        //递归回溯
        backTrack(n, n);
        return res;
    }

    /**
     * 递归回溯
     *
     * @param left
     * @param right
     */
    private void backTrack(int left, int right) {
        //提前终止的条件，左括号的个数一定是小于等于右括号的，否则构造的序列不合法
        if (left > right || left < 0 || right < 0) {
            return;
        }
        //本次递归终止的条件
        if (sb.length() == len) {
            res.add(sb.toString());
            return;
        }
        //左括号的递归和回溯
        sb.append("(");
        backTrack(left - 1, right);
        sb.deleteCharAt(sb.length() - 1);
        //右括号的递归和回溯
        sb.append(")");
        backTrack(left, right - 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
