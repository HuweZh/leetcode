package com.huhusw.middle;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 最长递增子序列
 */

public class M300 {
    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        //定义dp数组，dp[i]表示以nums[i]为末尾的最长子序列的长度
        int[] dp = new int[nums.length];
        //初始化为1，代表其本身就是最长子序列的一部分
        Arrays.fill(dp, 1);
        //双层循环进行更新dp数组
        //外层循环遍历整个数组
        for (int i = 0; i < nums.length; i++) {
            //内层循环更新数组
            for (int j = 0; j < i; j++) {
                //只有满足当前元素大于其前面的元素才能进行状态转移
                if (nums[j] < nums[i]) {
                    //更新数组
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        //获取结果
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 贪心+二分求最长递增子序列
     * dp[i]表示长度为i的序列中第i位的最小值
     * 这样表示，dp[1]表示的就是长度为1的子序列，最小值为dp[1]
     * 于是dp数组是一个递增的数组，可以利用二分查找出最后一个小于元素值的索引，并更新
     * 对于大于dp最后一个元素的值，直接拼接在后面
     * 对于小于dp最后一个元素的值，二分查找一个位置更新
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        //边界情况
        if (nums.length == 0) {
            return 0;
        }
        //dp数组，贪心，dp[i]表示长度为i的序列中第i位的最小值
        int[] dp = new int[nums.length + 1];
        //初始值
        dp[1] = nums[0];
        //dp数组中的元素个数
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            //当前元素大于dp数组的最大元素，直接加入
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
            } else {
                //二分查找一个位置，为nums[i]分配
                int l = 1;
                int r = len;
                //最后一个小于nums[i]的索引
                //初始值为0，要是没有找到该位置，就放在第一位
                int pos = 0;
                //二分
                while (l <= r) {
                    //中间
                    int mid = (l + r) >> 1;
                    //中间值小于当前元素，提升左边界并更新pos
                    //否则，更新右边界
                    if (dp[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                //pos指示最后一个小于nums[i]的索引
                //将下一个元素进行更新
                dp[pos + 1] = nums[i];
            }
        }
        //返回最长长度
        return len;
    }
}
