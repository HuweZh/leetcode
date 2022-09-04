package com.huhusw.JD;

import java.util.*;

/*
小红拿到一个数组，她每次可以进行如下操作之一
选择x，分裂成1和x-1
选择x，分裂成a和b，a*b=x

小红希望用最少的操作次数，将数组元素全变成1
 */
public class Z02 {
    public static void main(String[] args) {
        int[] dp = new int[100000];
        for (int i = 2; i <= 100000; i++) {
            dp[i] = test(i);
        }
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long res = 0;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int[] cal = cal(a);
            if (cal.length == 0) {
                res += 1 + dp[a - 1];
            } else {
                res += Math.min(1+dp[a-1],dp[cal[0]+dp[cal[1]]]);
            }
        }
        System.out.println(res);
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            queue.offer(sc.nextInt());
//        }
//        sc.close();
//
//        int res = 0;
//        while (!queue.isEmpty()) {
//            int num = queue.poll();
//            if (num == 1) {
//                continue;
//            }
//            int[] nums = cal(num);
//            if (nums.length == 0) {
//                //分裂为1 和 x-1
//                queue.add(num - 1);
//            } else {
//                //分裂为两数之积
//                queue.offer(nums[0]);
//                queue.offer(nums[1]);
//            }
//            res += 1;
//        }
//        System.out.println(res);
//    }

    private static int[] cal(int num) {
        int end = ((int) Math.sqrt(num)) + 1;
        for (int i = end; i > 1; i--) {
            if (num % i == 0) {
                return new int[]{i, num / i};
            }
        }
        return new int[0];
    }


    private static int test(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        int res = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num == 1) {
                continue;
            }
            int[] nums = cal(num);
            if (nums.length == 0) {
                //分裂为1 和 x-1
                queue.add(num - 1);
            } else {
                //分裂为两数之积
                queue.offer(nums[0]);
                queue.offer(nums[1]);
            }
            res += 1;
        }
        return res;
    }
}
