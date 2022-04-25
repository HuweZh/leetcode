package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/random-pick-index/
 * 返回一个随机索引
 * 给定一个数组，然后给定多个数组中的值，返回值对应的索引，题目保证值一定出现，
 * 输出保证索引概率相等
 * <p>
 * 1.Hash映射
 * 2.池塘抽样
 */
public class M398 {
    //hash表
    Map<Integer, List<Integer>> map;
    //随机数
    Random random;

    /**
     * 传入数组构造
     *
     * @param nums 数组
     */
    public M398(int[] nums) {
        //初始化
        map = new HashMap<>();
        random = new Random();
        //遍历数组，构造映射
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }

    /**
     * 给定值，返回随机索引
     *
     * @param target 值
     * @return 随机索引
     */
    public int pick(int target) {
        //值对应的索引列表
        List<Integer> stem = map.get(target);
        //列表中随机返回一个
        return stem.get(random.nextInt(stem.size()));
    }
}
