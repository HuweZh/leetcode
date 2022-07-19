package com.huhusw.sword2offer;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/A1NYOS/
 * 求0和1数量相等的最长连续子数组
 * 前缀和+hash
 * 将0看成-1，则两个前缀和为0的区间就是数量相等的区间
 * 使用hash表存储第一次出现前缀和的索引
 */
public class S011 {
    public int findMaxLength(int[] nums) {
        int res = 0;
        int counter = 0;
        //hash保存了前缀和第一次出现的索引
        HashMap<Integer, Integer> memo = new HashMap<>();
        //初始化，为0时，需要加1
        memo.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            //遇到1加1，遇到0减1
            if (nums[i] == 1) {
                counter++;
            } else {
                counter--;
            }
            //从memo中取元素
            if (memo.containsKey(counter)) {
                int index = memo.get(counter);
                res = Math.max(res, i - index);
            } else {
                memo.put(counter, i);
            }
        }
        return res;
    }
}
