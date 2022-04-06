package com.huhusw.middle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 组合总数
 */
public class M40 {
    //结果
    List<List<Integer>> res = new LinkedList<>();
    //临时路径
    LinkedList<Integer> temp = new LinkedList<>();

    /**
     * 找到所有不重复的等于target的子集
     *
     * @param candidates 候选集合
     * @param target     目标
     * @return 所有子集
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //先排序
        Arrays.sort(candidates);
        //回溯+剪枝
        recall(candidates, 0, target, 0);
        return res;
    }

    /**
     * 回溯+剪枝
     *
     * @param candidates 候选集合
     * @param index      当前的索引
     * @param target     目标
     * @param sum        当前路径上的和
     */
    public void recall(int[] candidates, int index, int target, int sum) {
        //不满足题意
        if (sum > target) {
            return;
        }
        //满足题意
        if (sum == target) {
            res.add(new LinkedList<>(temp));
            return;
        }
        //遍历数组
        for (int i = index; i < candidates.length; i++) {
            //剪枝
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            //保存路径
            temp.addLast(candidates[i]);
            //并更新中间的状态
            recall(candidates, i + 1, target, sum + candidates[i]);
            //撤销路径
            temp.removeLast();
        }
    }
}
