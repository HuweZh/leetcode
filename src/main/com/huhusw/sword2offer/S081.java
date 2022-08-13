package com.huhusw.sword2offer;

import java.util.ArrayList;
import java.util.List;

public class S081 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> stem = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, 0, 0);
        return res;
    }

    /**
     * 回溯加剪枝
     * @param candidates
     * @param target
     * @param index
     * @param sum
     */
    private void backTrack(int[] candidates, int target, int index, int sum) {
        //找到结果
        if (sum == target) {
            res.add(new ArrayList<>(stem));
            return;
        }
        //剪枝
        if (sum > target) {
            return;
        }
        //回溯
        for (int i = index; i < candidates.length; i++) {
            //做选择
            sum += candidates[i];
            stem.add(candidates[i]);
            //递归
            backTrack(candidates, target, i, sum);
            //撤销选择
            sum -= candidates[i];
            stem.remove(stem.size() - 1);
        }
    }
}
