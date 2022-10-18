package com.huhusw.TX;

import java.util.*;

public class Z02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] - a[1] != b[0] - b[1]) {
                return b[0] - b[1] - (a[0] - a[1]);
            } else {
                return b[0] - b[1];
            }
        });
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{nums[i], Integer.bitCount(nums[i]), i});
        }
        while (k != 0) {
            k--;
            int[] poll = queue.poll();
            nums[poll[2]] = poll[1];
            queue.offer(new int[]{nums[poll[2]], Integer.bitCount(nums[poll[2]]), poll[2]});
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        System.out.println(sum);
    }
}
