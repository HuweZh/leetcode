package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/maximum-length-of-pair-chain/
 * 最长的数对链
 * 数对之间有关系（a，b） a<b 排序的时候按照b排序，保证递增，这样只需要判断前面的a就能找到合适的数对
 * b相等的情况下，a降序，第一个a能满足题意，其他的就不用看了
 */
public class M646 {
    public int findLongestChain(int[][] pairs) {
        //优先队列
        PriorityQueue<int[]> queue = new PriorityQueue<>((a1, a2) -> {
            if (a1[1] != a2[1]) {
                return a1[1] - a2[1];
            }
            return a2[0] - a1[0];
        });
        //放入数据
        for (int[] pair : pairs) {
            queue.offer(pair);
        }
        //初始化
        int[] stem = queue.poll();
        int a = stem[0];
        int b = stem[1];
        int res = 1;
        //遍历后面的元素
        while (!queue.isEmpty()) {
            stem = queue.poll();
            //只需要判断后面的a是不是大于前面的b就可以满足题意
            if (stem[0] > b) {
                res++;
                b = stem[1];
                a = stem[0];
            }
        }
        return res;
    }
}
