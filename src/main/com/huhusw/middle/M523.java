package com.huhusw.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huhusw
 * @Description
 * @create 2021-06-02 10:55
 */
public class M523 {
    //前缀和+哈希表
    public boolean checkSubarraySum(int[] nums, int k) {
        //任何一个连续的子区间都能由前缀和数组得到
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        //哈希表，存储余数冲突的值
        Map<Integer, Integer> map = new HashMap<>();
        //初始化，索引为0的前缀和不符合题意
        map.put(0, -1);
        //前缀和
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int yushu = sum % k;
            //之前存储过相同的余数
            if (map.containsKey(yushu)) {
                int preIndex = map.get(yushu);
                if (i - preIndex >= 2) {
                    return true;
                }
            } else {
                map.put(yushu, i);
            }
        }
        return false;
    }
}
