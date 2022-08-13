package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/VvJkup/
 * 多叉树回溯剪枝
 */
public class S083 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> stem = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backTrack(nums);
        return res;
    }

    private void backTrack(int[] nums) {
        if (stem.size() == nums.length) {
            res.add(new ArrayList<>(stem));
            return;
        }
        //从多叉树中选择一个进行回溯
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            stem.add(nums[i]);
            used[i] = true;
            backTrack(nums);
            stem.remove(stem.size() - 1);
            used[i] = false;
        }
    }
}
