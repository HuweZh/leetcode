package com.huhusw.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/subsets/
 */
public class M78 {
    //结果
    List<List<Integer>> res = new ArrayList<>();

    /**
     * 获取当前集合所有可能的子集
     *
     * @param nums 集合
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        //回溯
        recall(nums, 0, new Stack<Integer>());
        return res;
    }

    /**
     * 回溯求所有的子集
     *
     * @param nums  集合
     * @param index 当前索引
     * @param stack 记录选中的元素
     */
    public void recall(int[] nums, int index, Stack<Integer> stack) {
        //遍历了集合
        if (index == nums.length) {
            //添加当前结果
            res.add(new ArrayList<>(stack));
            return;
        }
        //添加当前元素
        stack.push(nums[index]);
        //递归添加下一次的元素
        recall(nums, index + 1, stack);
        //撤销这一次的选择
        stack.pop();
        //不添加当前元素也是一种子集的构成方式
        recall(nums, index + 1, stack);
    }


    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();

    // 主函数
    public List<List<Integer>> subsets2(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    void backtrack(int[] nums, int start) {

        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));

        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
        //后序位置
    }
}
