package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/get-kth-magic-number-lcci/
 * 第k个数
 * 一个数的因数里有3 5 7的数，找出排在第k位的数
 */
public class MS1709 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    /**
     * 优先队列，每次弹出当前队列中最小的数，并记录次数
     * 再加三个数进入队列，为了防止重复，使用set去重
     *
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        queue.offer(1L);
        set.add(1L);
        int count = 0;
        int res = 0;
        int[] dif = new int[]{3, 5, 7};
        while (count != k) {
            long cur = queue.poll();
            res = (int) cur;
            count++;
            for (int i = 0; i < 3; i++) {
                long next = dif[i] * cur;
                if (!set.contains(next)) {
                    set.add(next);
                    queue.offer(next);
                }
            }
        }
        return res;
    }
}
