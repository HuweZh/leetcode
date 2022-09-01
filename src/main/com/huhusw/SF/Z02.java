package com.huhusw.SF;

import java.util.*;

public class Z02 {
    class Node {

    }
/*
小红有一棵圣诞树，圣诞树由n个节点组成，每个节点上都有一些愿望（整数，可能为负数，即圣诞树回馈小红一个愿望）。小红想要实现树上的所有愿望。她可以做一些操作，每次操作可以选择一个包含节点1的子图，并将子图的所有节点的愿望数量+1或-1（实现或回馈）。请问小红至少要操作多少次，才能让所有节点的愿望为0。

子图是指有一个图，它的节点和边都是原树的子集。
 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n; i++) {
            int num = sc.nextInt() - 1;
            parent[i] = num;
            set.add(num);
        }
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                queue.add(i);
            }
        }
        long sum = 0;
        while (!queue.isEmpty()) {
            int stem = queue.poll();
            if (nums[stem] == 0 || stem == 0) {
                continue;
            }
            sum += Math.abs(nums[stem]);
            int index = stem;
            while (index != parent[index]) {
                nums[parent[index]] -= nums[stem];
                index = parent[index];
            }
            nums[stem] = 0;
            queue.add(parent[stem]);
        }
        sum += Math.abs(nums[0]);
        System.out.println(sum);
    }
}
