package com.huhusw.sword;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * 栈的压入和弹出
 */
public class S31 {
    /**
     * 判断压入顺序和弹出顺序是否能够同时满足
     * 使用辅助栈模拟顺序
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //辅助栈
        Stack<Integer> stack = new Stack<>();
        //两个数组的索引
        int push = 0;
        int pop = 0;
        int n = pushed.length;
        //循环判断是否应该压栈还是入栈
        while (push != n && pop != n) {
            if (stack.isEmpty() && popped[pop] != pushed[push]) {
                //栈为空，应该压入
                stack.push(pushed[push]);
                push++;
            } else if (popped[pop] != pushed[push] && popped[pop] != stack.peek()) {
                //应该压入
                stack.push(pushed[push]);
                push++;
            } else if (popped[pop] == pushed[push]) {
                //同时向后移
                push++;
                pop++;
            } else if (popped[pop] == stack.peek()) {
                //弹栈
                pop++;
                stack.pop();
            }
        }
        //依次判断
        if (pop == n) {
            return true;
        } else {
            while (!stack.isEmpty()) {
                if (popped[pop] != stack.peek()) {
                    return false;
                }
                pop++;
                stack.pop();
            }
            return true;
        }
    }

    /**
     * 栈模拟精简版
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        //辅助栈
        Stack<Integer> stack = new Stack<>();
        //弹出索引
        int pop = 0;
        //遍历压入数组
        for (int p : pushed) {
            //压栈
            stack.push(p);
            //循环判断是否弹栈
            while (!stack.isEmpty() && stack.peek() == popped[pop]) {
                stack.pop();
                pop++;
            }
        }
        //栈为空代表全部弹出
        return stack.isEmpty();
    }
}
