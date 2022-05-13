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

    /**
     * 贪心+二分
     * 其实本质也是扑克牌算法
     * 但是会好理解一点
     * dp[i]表示长度为i的子序列中第i位的最小值为dp[i]
     * 对所有的信封按照宽度进行排序，那么就相当于找长度的最大递增子序列
     *
     * @param envelopes
     * @return
     */
    public int maxEnvelopes2(int[][] envelopes) {
        //边界情况
        if (envelopes.length == 0) {
            return 0;
        }
        //对信封排序，宽度升序，长度降序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        //定义dp数组 dp[i]表示长度为i的子序列中第i位的最小值为dp[i]
        int n = envelopes.length;
        int[][] dp = new int[n + 1][2];
        //初始值
        dp[1] = envelopes[0];
        //结果值
        int len = 1;
        //遍历数组
        for (int i = 1; i < n; i++) {
            //如果大于，直接进行追加
            //否则，二分检索dp数组中最后一个小于当前元素的索引，更新其下一位
            if (dp[len][1] < envelopes[i][1]) {
                dp[++len] = envelopes[i];
            } else {
                //左右边界，闭区间
                int l = 1;
                int r = len;
                //定位的索引，初始值为0，若找不到值，更新第一位
                int pos = 0;
                //二分检索
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    //当前元素大于dp的中位，更新左边界和索引值
                    //否则更新右边界
                    if (dp[mid][1] < envelopes[i][1]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                //更新dp数组
                dp[pos + 1] = envelopes[i];
            }
        }
        return len;
    }
}
