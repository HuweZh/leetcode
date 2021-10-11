package com.huhusw.middle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class M313 {
    public static void main(String[] args) {
        M313 m313 = new M313();
        int i = m313.nthSuperUglyNumber1(15, new int[]{3,5,7,11,19,23,29,41,43,47});
        System.out.println(i);
    }

    //最小堆
    //每次从最小堆中取出最小的超级丑数，与原数组想乘
    //去除重复的积之后，重复过程
    //初始的超级丑数为1
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.offer(1L);
        Set<Long> hash = new HashSet<>();
        hash.add(1L);
        while (n != 1) {
            long min = minHeap.poll();
            for (int temp : primes) {
                long stem = temp * min;
                if (!hash.contains(stem)) {
                    hash.add(stem);
                    minHeap.offer(stem);
                }
            }
            n--;
        }
        return minHeap.poll().intValue();
    }

    //动态规划
    //dp[i]表示第i个超级丑数，初始状态dp[1] = 1
    public int nthSuperUglyNumber1(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        int m = primes.length;
        //dp[i]表示第i个超级丑数，初始状态dp[1] = 1
        int[] dp = new int[n + 1];
        dp[1] = 1;
        //这个数组记录着当前循环状态下，每个位置要用到的超级丑数
        //初始状态为1
        int[] pointers = new int[m];
        Arrays.fill(pointers, 1);

        for (int i = 2; i <= n; i++) {
            int minUgly = Integer.MAX_VALUE;
            //记录本次循环获得的全部丑数
            int[] nums = new int[m];
            for (int j = 0; j < m; j++) {
                nums[j] = dp[pointers[j]] * primes[j];
                //从全部丑数中抽取最小的
                minUgly = Math.min(nums[j],minUgly);
            }
            //本次循环的丑数中有相等的话，在下一次循环时需要考虑较大的丑数，即加1
            for(int j = 0; j < m; j++){
                if(nums[j] == minUgly){
                    pointers[j]++;
                }
            }
            //记录当前的最小丑数
            dp[i] = minUgly;
        }
        return dp[n];
    }


}
