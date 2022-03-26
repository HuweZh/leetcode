package com.huhusw.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 数组元素全排列
 * 回溯
 */
public class M46 {
    //结果列表
    List<List<Integer>> res;
    //访问情况
    boolean[] visited;

    /**
     * 获取全排列
     *
     * @param nums 数组
     * @return 全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        //初始化元素
        res = new ArrayList<>();
        visited = new boolean[nums.length];
        //回溯求全排列
        backSearch(new ArrayList<Integer>(), nums);
        return res;
    }

    /**
     * 回溯求全排列
     *
     * @param stem 当前路径
     * @param nums 所有元素
     */
    public void backSearch(List<Integer> stem, int[] nums) {
        //所有的元素都已经遍历到
        if (stem.size() == nums.length) {
            res.add(new ArrayList<>(stem));
            return;
        }
        //遍历元素
        for (int i = 0; i < nums.length; i++) {
            //找未访问过的节点
            if (!visited[i]) {
                //标志位访问过，并加入路径
                visited[i] = true;
                stem.add(nums[i]);
                //递归查找未被访问的点
                backSearch(stem, nums);
                //撤销标志位，回溯
                stem.remove(stem.size() - 1);
                visited[i] = false;
            }
        }
    }
}
