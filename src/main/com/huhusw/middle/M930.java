package com.huhusw.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/binary-subarrays-with-sum/
 */
public class M930 {
    /**
     * 统计并返回有多少个和为 goal 的 非空 子数组。
     * nums为二元数组，为0或1
     *
     * @param nums 二元数组
     * @param goal 目标
     * @return 多少个满足题意非空子数组
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        //存储前缀和以及对应的个数
        Map<Integer, Integer> map = new HashMap<>();
        //前缀和
        int sum = 0;
        //初始条件
        map.put(sum, 1);
        //返回值
        int ans = 0;
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //计算前缀和
            sum += nums[i];
            //寻找是否有满足题意的前缀和
            //sum[j]-sum[i] = goal ==> sum[i] = sum[j]-goal
            ans += map.getOrDefault(sum - goal, 0);
            //将此前缀和存入
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        //返回结果
        return ans;
    }
}
