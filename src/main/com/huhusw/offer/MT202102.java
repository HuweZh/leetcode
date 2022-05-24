package com.huhusw.offer;

import java.util.*;

/**
 * https://www.nowcoder.com/questionTerminal/0771ab500d424415af6b1aa4c13afcdd
 * 正则序列，设长度为n，且元素值包含[1,n]的序列为正则序列
 * 给定一个序列，求转化为正则序列需要的最小步骤，每一步可以对任意一个元素加一减一
 * <p>
 * 使用set进行元素过滤，过滤掉的元素是正则序列的一部分，剩下的元素是需要被转化的部分
 * 使用贪心，两两转化
 */
public class MT202102 {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //set集合存储正则序列
        Set<Integer> set = new HashSet<>(n);
        //这里使用优先队列进行贪心策略实现
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            set.add(i + 1);
        }
        //输入数据，进行过滤
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (set.contains(x)) {
                set.remove(x);
            } else {
                queue.offer(x);
            }
        }
        //对需要被转化的元素排序
        PriorityQueue<Integer> setQ = new PriorityQueue<>(set);
        int res = 0;
        //贪心
        while (!queue.isEmpty()) {
            res += Math.abs(queue.poll() - setQ.poll());
        }
        System.out.println(res);
    }

    /**
     * 不需要过过滤，根据正则的特点也可以完成要求
     * 对于排序好的正则序列，那么排在第i位的元素值一定为i
     * 否则，就需要转化
     *
     * @param args
     */
    public static void main2(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += Math.abs(i - nums[i]);
        }
        System.out.println(res);
    }
}
