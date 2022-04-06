package com.huhusw.middle;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * 组合总和
 */
public class M39 {
    //结果
    List<List<Integer>> res = new LinkedList<>();
    //临时路径
    LinkedList<Integer> temp = new LinkedList<>();
    //当前路径总和
    int sum = 0;

    /**
     * 获取数组中等于target的组合
     * 其中集合中的元素可以无限使用
     *
     * @param candidates 集合
     * @param target     目标值
     * @return 所有的组合数
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //回溯+剪枝
        dfs(candidates, target, 0);
        return res;
    }

    /**
     * 回溯+剪枝找到所有等于target的组合
     * 其中剪枝是指当前路径的和超过了target，进行剪枝回溯
     * 每次递归的时候都应该传入当前元素以及后面的元素
     *
     * @param candidates 源集合
     * @param target     目标
     * @param start      其实索引，每次递归都要递归到当前元素
     */
    public void dfs(int[] candidates, int target, int start) {
        //满足题意
        if (sum == target) {
            res.add(new LinkedList<>(temp));
            return;
        }
        //剪枝，否则这个递归树会一直生长下去
        if (sum > target) {
            return;
        }
        //遍历数组元素
        for (int i = start; i < candidates.length; i++) {
            sum += candidates[i];
            temp.add(candidates[i]);
            //这里递归的时候需要将当前元素一并传入
            dfs(candidates, target, i);
            sum -= candidates[i];
            temp.removeLast();
        }
    }
}
