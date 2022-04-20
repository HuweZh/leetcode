package com.huhusw.middle;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/longest-absolute-file-path/
 * 文件的最长路径
 */
public class M388 {
    /**
     * 找出文件的最长路径长度
     * 输入:"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext
     *
     * @param input 输入文件目录
     * @return 最长的文件路径长度
     */
    public int lengthLongestPath(String input) {
        //使用栈模拟
        Stack<Integer> stack = new Stack<>();
        //当前遍历的位置
        int pos = 0;
        //全部的长度
        int n = input.length();
        //结果
        int res = 0;
        //遍历输入
        while (pos < n) {
            //根据\t计算深度，每一个\t加一层深度
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                depth++;
                pos++;
            }
            //判断当前遍历的是文件夹还是文件，并计算长度
            int len = 0;
            boolean isFile = false;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                pos++;
                len++;
            }
            //跳过换行符
            pos++;
            //根据输入可知，栈是深度优先遍历的文件和文件夹
            //这里判断突然出现的文件夹转换
            while (stack.size() >= depth) {
                stack.pop();
            }
            //上一层有文件夹，需要补充一个斜杠加到结果上
            if (!stack.isEmpty()) {
                len += stack.peek() + 1;
            }
            //是文件，就记录一下结果，文件夹压入栈
            if (isFile) {
                res = Math.max(res, len);
            } else {
                stack.push(len);
            }
        }
        return res;
    }
}
