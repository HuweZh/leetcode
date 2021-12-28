package com.huhusw.middle;

import java.util.HashSet;
import java.util.Set;

public class M128 {
    /**
     * 查找一个无序数组中出现的最长连续子序列
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 连续序列为：1 2 3 4
     */
    public int longestConsecutive(int[] nums) {
        //将所有的值放入hashset中，hashset查找元素的效率更高
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }
        //结果
        int res = 0;
        //遍历数组
        for (int num : numSet) {
            //如果比当前数字小1的数不在set中，进行更新
            //如果比当前数字小1的数x在set中，那么最长的序列一定是从x开始进行计算的
            //因此，只有不存在x，我们才从当前的数字去更新结果
            if (!numSet.contains(num - 1)) {
                //当前的序列长度只有num自己
                int curRes = 1;
                //往大数遍历
                int curNum = num + 1;
                //一直查找，直到序列的末尾
                while (numSet.contains(curNum)) {
                    curRes++;
                    curNum++;
                }
                //更新结果
                res = Math.max(res, curRes);
            }
        }
        //返回
        return res;
    }
}
