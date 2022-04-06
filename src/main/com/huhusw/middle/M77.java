package com.huhusw.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/combinations/submissions/
 * 长度固定的所有可能子集
 */
public class M77 {
    //结果
    List<List<Integer>> res = new ArrayList<>();

    /**
     * 在[1,n]集合中获取长度为k的子集
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        //回溯获取子集
        recall(n, k, 0, new Stack<Integer>());
        return res;
    }

    public void recall(int n, int k, int index, Stack<Integer> stack) {
        //找到一个满足题意的情况，直接返回
        if (stack.size() == k) {
            res.add(new ArrayList<>(stack));
            return;
        }
        //剪枝
        //若遍历到末尾或者当前的遍历结果加上剩下的个数不满足题意，直接返回
        if (index == n || stack.size() + n - index < k) {
            return;
        }
        //不加当前元素递归
        recall(n, k, index + 1, stack);
        //加上当前元素递归
        stack.push(index + 1);
        recall(n, k, index + 1, stack);
        stack.pop();
    }
}
