package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/4sjJUc/
 * 多叉树回溯加剪枝
 */
public class S082 {
    //结果
    List<List<Integer>> res = new ArrayList<>();
    //中间值
    List<Integer> stem = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //先对数组进行排序，方便找到重复元素
        Arrays.sort(candidates);
        //回溯
        backTrack(candidates, target, 0, 0);
        return res;
    }

    /**
     * 多叉树回溯
     *
     * @param candidates
     * @param target
     * @param index
     * @param sum
     */
    private void backTrack(int[] candidates, int target, int index, int sum) {
        //找到一个符合题意的结果
        if (sum == target) {
            res.add(new ArrayList<>(stem));
            return;
        }
        //剪枝
        if (sum > target) {
            return;
        }
        //遍历剩下的元素
        for (int i = index; i < candidates.length; i++) {
            //去重，相同的元素只需要遍历一次
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            //做选择
            sum += candidates[i];
            stem.add(candidates[i]);
            //进行判断
            backTrack(candidates, target, i + 1, sum);
            //撤销选择
            sum -= candidates[i];
            stem.remove(stem.size() - 1);
            //backTrack(candidates,target,i+1,sum);
        }
    }
}
