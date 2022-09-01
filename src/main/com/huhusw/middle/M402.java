package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/remove-k-digits/
 * 移掉k个数字
 * 移掉k个数字得到的最小值
 */
public class M402 {
    /**
     * 移掉k个数字后得到最小值
     * 单调栈
     * 最小的值，高位越小越好，所以用栈来保存高位
     * k为0之前，栈里面保证不递减
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        Deque<Integer> stack = new LinkedList<>();
        //遍历
        for (int i = 0; i < num.length(); i++) {
            //是否可以放入栈
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > (num.charAt(i) - '0')) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(num.charAt(i) - '0');
        }
        //还能接着删，删除后面较大的
        while (k > 0) {
            stack.pollLast();
            k--;
        }
        //前导0
        while (!stack.isEmpty() && stack.peekFirst() == 0) {
            stack.pollFirst();
        }
        if (stack.isEmpty()) {
            return "0";
        }
        //结果
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}
