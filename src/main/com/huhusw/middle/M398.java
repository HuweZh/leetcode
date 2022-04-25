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


    /**
     * 池塘抽样
     * 在一个无限的序列中，遍历一遍以特定概率找到特定值对应的索引
     */
    //数组
    int[] arr;

    public void solution(int[] nums) {
        //初始化
        arr = nums;
        random = new Random();
    }

    /**
     * 池塘抽样
     * 保证返回特定值对应的索引是概率相同的
     *
     * @param target 特定值
     * @return 对应的索引
     */
    public int pick2(int target) {
        //记录序列中有多少个与target相等
        int count = 0;
        //返回值
        int res = -1;
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            //找到一个相等的值，需要进行状态更新
            if (arr[i] == target) {
                //更新计数
                count++;
                //在[0,count)中选择一个整数，每个整数的概率都是1/count
                //让其等于其中一个最特殊的整数0，其概率为1/count，且保证只有一个元素相等时，一定会有结果
                //所以，res是以1/count的概率进行更新，直到找到所有的target
                //这时候对应的索引就是1/count的概率出现的
                if (random.nextInt(count) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }
}
