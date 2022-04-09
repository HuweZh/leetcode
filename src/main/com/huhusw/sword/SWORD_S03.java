package com.huhusw.sword;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author huhusw
 * @Date 2020/11/7
 */
public class SWORD_S03 {

    public static void main(String[] args) {

    }

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return 0;
    }

    /**
     * 散列表
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n];
        for (int i = 0; i < n; i++) {
            hash[nums[i]]++;
            if (hash[nums[i]] == 2) {
                return nums[i];
            }
        }
        return 0;
    }
}
