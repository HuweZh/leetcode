package com.huhusw.sword2offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/1fGaJU/
 * 三数之和
 * 找到数组中三个数和为0
 * 双指针
 */
public class S007 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        //排序，保证三个数a<b<c
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<>();
        //第一个数，遍历数组
        for (int i = 0; i < nums.length; i++) {
            //过滤重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //双指针在剩余的数组中找结果
            int target = -nums[i];
            int right = nums.length - 1;
            for (int left = i + 1; left < right; left++) {
                //过滤重复元素
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    continue;
                }
                //判断是否达成退出条件
                while (left < right && nums[left] + nums[right] > target) {
                    right--;
                }
                if (left >= right) {
                    break;
                }
                //到达退出条件
                if (nums[left] + nums[right] == target) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                }
            }
        }
        return res;
    }
}
