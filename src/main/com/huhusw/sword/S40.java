package com.huhusw.sword;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 输出前k个小数
 */
public class S40 {
    //排序输出
    public int[] getLeastNumbers2(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 最大堆输出
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            res[index] = queue.poll();
            index++;
        }
        return res;
    }
}
