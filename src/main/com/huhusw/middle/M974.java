package com.huhusw.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 */
public class M974 {
    public static void main(String[] args) {
        M974 m974 = new M974();
        m974.subarraysDivByK(new int[]{4,5,0,-2,-3,1},5);
    }
    /**
     * 找出能被k整除的子数组个数
     * 设p[i]是前i个元素的前缀和
     * 满足题意的要求是(p[i]-p[j])%k==0，可以转为p[i]%k == p[j]%k
     * 所以只需要判断每一个前缀和与k之间的余数即可
     *
     * @param nums 原数组
     * @param k    被整除的数
     * @return 子数组的个数
     */
    public int subarraysDivByK(int[] nums, int k) {
        //记录余数和子数组的对应个数
        Map<Integer, Integer> map = new HashMap<>();
        //初始化
        map.put(0, 1);
        //数组长度
        int n = nums.length;
        //前缀和
        int sum = 0;
        //结果
        int ans = 0;
        //遍历数组
        for (int i = 0; i < n; i++) {
            //计算前缀
            sum += nums[i];
            //计算余数，因为负数的余数也是负数，所以处理一下
            int module = (sum % k + k) % k;
            //获取之前的子数组个数加到结果上
            ans += map.getOrDefault(module, 0);
            //更新此余数对应的子数组个数
            map.put(module, map.getOrDefault(module, 0) + 1);
        }
        return ans;
    }
}
