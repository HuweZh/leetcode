package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/7p8L0Z/
 * 含有重复元素的数组的全排列
 */
public class S084 {
    //结果
    List<List<Integer>> res = new ArrayList<>();
    //本次遍历的路径
    List<Integer> stem = new ArrayList<>();
    //是否访问过当前的元素
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        //排序，将相同元素放置在一起
        Arrays.sort(nums);
        //开始回溯剪枝
        backTrack(nums);
        return res;
    }

    private void backTrack(int[] nums) {
        //得到结果
        if (stem.size() == nums.length) {
            res.add(new ArrayList<>(stem));
            return;
        }
        //进行同层多叉树遍历
        for (int i = 0; i < nums.length; i++) {
            //判断相同的元素，将相同的元素看成一个整体，第一个选后面的跟着选，前一个不选后面的跟着不选
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            //当前元素用过，不再使用
            if (used[i]) {
                continue;
            }
            //做选择
            used[i] = true;
            stem.add(nums[i]);
            //继续向下
            backTrack(nums);
            //撤销选择
            used[i] = false;
            stem.remove(stem.size() - 1);
        }
    }
}
