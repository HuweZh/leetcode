package com.huhusw.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/contiguous-array/
 */
public class M525 {
    /**
     * 找出数组中0和1数量相等的最长子数组的长度
     * 将0看成-1，那么就是找子数组的元素和为0的长度
     * hash表+前缀和实现
     * hash表存储第一次出现的前缀和的索引，下一次再出现此前缀和，证明中间这一段的元素和为0
     * 这样的话，只需要比较返回值和这一段的长度即可
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        //边界条件
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //hash表
        Map<Integer, Integer> map = new HashMap<>();
        //初始值
        int sum = 0;
        //前缀和为0时对应的索引
        map.put(sum, -1);
        int res = 0;
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //计算前缀和
            int num = nums[i];
            sum += num == 1 ? 1 : -1;
            //前缀和已经在hash表中出现
            if (map.containsKey(sum)) {
                //更新结果
                int preIndex = map.get(sum);
                res = Math.max(res, i - preIndex);
            } else {
                //放入hash
                map.put(sum, i);
            }
        }
        return res;
    }

}
