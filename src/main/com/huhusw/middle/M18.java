package com.huhusw.middle;

import java.util.*;

public class M18 {
    public static void main(String[] args) {
        M18 m18 = new M18();
        m18.fourSum(new int[]{0,0,0,0}, 0);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        //双指针优化四重循环变为三重循环
        for (int i = 0; i < nums.length; i++) {
            //剪枝
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                //剪枝
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        ArrayList stem = new ArrayList<Integer>();
                        stem.add(nums[i]);
                        stem.add(nums[j]);
                        stem.add(nums[left]);
                        stem.add(nums[right]);
//                        Arrays.asList(nums[i],nums[j],nums[left],nums[right]);
                        boolean add = result.add(stem);
                        //防止重复
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left > right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
