package com.huhusw.middle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 * 全排列2
 */
public class M47 {
    //是否访问过当前元素
    boolean[] visited;
    //结果
    List<List<Integer>> res = new LinkedList<>();
    //临时记录
    LinkedList<Integer> temp = new LinkedList<>();

    /**
     * 获取不重复的全排列
     *
     * @param nums 可能含有重复元素的集合
     * @return 不重复的全排列
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        visited = new boolean[nums.length];
        //排序，将数值相等的放在一起
        Arrays.sort(nums);
        //回溯+剪枝
        dfs(nums);
        return res;
    }

    /**
     * 回溯加剪枝完成全排列
     *
     * @param nums
     */
    public void dfs(int[] nums) {
        //遍历了所有的元素
        if (temp.size() == nums.length) {
            res.add(new LinkedList<>(temp));
            return;
        }
        //遍历
        for (int i = 0; i < nums.length; i++) {
            //访问过的不在访问
            if (visited[i]) {
                continue;
            }
            //看到相同的元素，只要第一个没被访问，后面的都不被访问，保证了相同元素的访问顺序
            //保证访问的时候一起都被访问，不访问，都不访问  剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            //添加当前元素，递归
            temp.add(nums[i]);
            visited[i] = true;
            dfs(nums);
            temp.removeLast();
            visited[i] = false;
        }
    }
}
