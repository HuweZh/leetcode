package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 * 子集
 */
public class M90 {
    //结果
    List<List<Integer>> res = new LinkedList<>();
    //去重
    Set<LinkedList<Integer>> set = new HashSet<>();
    //临时路径
    LinkedList<Integer> temp = new LinkedList<>();

    /**
     * 有重复元素的不重复可能子集
     *
     * @param nums 集合
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //先对集合进行排序
        Arrays.sort(nums);
        //回溯获取子集
        recall(nums, 0);
        return res;
    }

    /**
     * 回溯获取所有可能子集
     *
     * @param nums
     * @param index
     */
    public void recall(int[] nums, int index) {
        //遍历完了数组
        if (index == nums.length) {
            //判断是否已经加入到结果中
            if (!set.contains(temp)) {
                set.add(new LinkedList<Integer>(temp));
                res.add(new LinkedList<Integer>(temp));
                return;
            }
            return;
        }
        //递归
        //添加这个元素
        temp.addLast(nums[index]);
        recall(nums, index + 1);
        temp.removeLast();
        //不添加这个元素
        recall(nums, index + 1);
    }
}
