package com.huhusw.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * 和为k的子数组
 * 找出数组中所有和为k的子数组
 */
public class M560 {
    public static void main(String[] args) {
        M560 m560 = new M560();
        m560.subarraySum(new int[]{1, 1, 1}, 2);
    }

    /**
     * 前缀和找子数组的复杂度为n方
     * 所以进行优化，使用hash表存储所有的前缀和，并存储其出现的次数
     * 在进行遍历时，只需要找到目标前缀和即可
     *
     * @param nums 数组
     * @param k    和
     * @return 有几个子树组的和为k
     */
    public int subarraySum(int[] nums, int k) {
        //hash表存储
        Map<Integer, Integer> map = new HashMap<>();
        //base case，当前缀和恰好等于k时会用到这个值
        map.put(0, 1);
        //前缀和
        int preSum = 0;
        //结果
        int res = 0;
        //遍历数组
        for (int num : nums) {
            //计算所有元素的前缀和
            preSum += num;
            //子数组的前缀和
            int targetPreSum = preSum - k;
            //查看hash表是否有目标前缀和
            if (map.containsKey(targetPreSum)) {
                res += map.get(targetPreSum);
            }
            //放置当前的前缀和到hash中
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }
}
