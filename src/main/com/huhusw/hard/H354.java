package com.huhusw.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 */
public class H354 {
    /**
     * 信封套娃，信封只有长宽都小的时候才能套娃
     *
     * @param envelopes 信封
     * @return 返回最多能套几个
     */
    public int maxEnvelopes(int[][] envelopes) {
        //对信封进行排序，按照宽度升序，这样就不用考虑宽度的问题，直接向后遍历，宽度越来越大
        //对于宽度相同的，高度降序，因为向后遍历，所以会先访问到宽度相同中的高度最大的那个信封
        //这样就不需要考虑会不会产生宽度相同的情况
        //问题就被转化为，求高度数组对应的最长递增子序列
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        //提取出高度数组，进行答案的寻找
        int[] nums = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            nums[i] = envelopes[i][1];
        }
        //寻找答案 Nlog(n)
        return getTrue(nums);
        //暴力动规，超时
        // int res = -1;
        // int[] dp = new int[n];
        // Arrays.fill(dp,1);
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < i; j++){
        //         if(envelopes[i][0]>envelopes[j][0]&&envelopes[i][1]>envelopes[j][1]){
        //             dp[i] = Math.max(dp[i],dp[j]+1);
        //         }
        //     }
        //     res = Math.max(res,dp[i]);
        // }
        // return res;
    }

    /**
     * 扑克牌算法求最长递增子序列
     * 规定：
     * 只能把点数小的牌压到点数比它大的牌上。
     * 如果当前牌点数较大没有可以放置的堆，则新建一个堆，把这张牌放进去。
     * 如果当前牌有多个堆可供选择，则选择最左边的堆放置。
     *
     *
     * @param nums
     * @return
     */
    public int getTrue(int[] nums) {
        //牌堆，记录的是牌堆最顶上的值
        int[] tops = new int[nums.length];
        //牌堆指针
        int piles = 0;
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //取出当前元素，作为扑克牌
            int poker = nums[i];
            //二分查找，找最左边的牌堆
            int left = 0;
            //右边界
            int right = piles;
            //二分查找
            while (left < right) {
                int mid = (left + right) / 2;
                //往右边
                if (tops[mid] < poker) {
                    left = mid + 1;
                } else {
                    //左边，其中元素与牌堆顶部值相等时不能放，需要寻找左边的堆
                    right = mid;
                }
            }
            //没找到合适的牌堆，新建一个堆
            if (left == piles) piles++;
            //将扑克牌放置在正确的位置
            tops[left] = poker;
        }
        //牌堆数量就是最长递增子序列的长度
        return piles;
    }
}
