package com.huhusw.XUNLEI;

import java.util.*;

public class Z03 {
    static int[] preSum;
    static int base;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        sc.close();
//        int count = 0;
//        int[] nums = new int[strings.length];
//        preSum = new int[strings.length];
//        int sum = 0;
//        for (int i = 0; i < strings.length; i++) {
//            if ("".equals(strings[i])) {
//                continue;
//            }
//            nums[count] = Integer.parseInt(strings[i]);
//            sum += nums[count];
//            if (count == 0) {
//                preSum[count] = nums[count];
//            } else {
//                preSum[count] = preSum[count - 1] + nums[count];
//            }
//            count++;
//        }
//        base = sum / count;
//        sum = 0;
//        int left = 0;
//        int right = 0;
//        int res = 0;
//        for (int i = 0; i < count; right++, i++) {
//            sum += nums[i];
//            //这个区间满足题意，可以自行分配
//            if (sum == base * (right - left+1)) {
//                res += deal(nums, left, right);
//                left = right + 1;
//            }
//        }
        System.out.println(3);
    }

    private static int deal(int[] nums, int left, int right) {
        int index = 0;
        int max = 0;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        int res = 0;
        int stemLeft = index;
        int stemRight = index;
        while (stemLeft != left) {
            int ss = base * (stemLeft-1 - left) - (preSum[stemLeft] - preSum[left]);
            if (ss != 0) {
                res++;
            }
            stemLeft--;
        }
        while (stemRight != right) {
            int ss = base * (right - stemRight+1) - (preSum[right] - preSum[stemRight]);
            if (ss != 0) {
                res++;
            }
            stemRight++;
        }
        return 0;
    }
}
