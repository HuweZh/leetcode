package com.huhusw.middle;

/**
 * @author huhusw
 * @Description
 * @create 2021-05-09 20:11
 */
public class M1482 {
    public static void main(String[] args) {
        M1482 m1482 = new M1482();
        int i = m1482.minDays(new int[]{62,75,98,63,47,65,51,87,22,27,73,92,76,44,13,90,100,85}, 2, 7);
        System.out.println(i);
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k || bloomDay.length == 0) {
            return -1;
        }
        int left = bloomDay[0];
        int right = bloomDay[0];
        for (int i = 1; i < bloomDay.length; i++) {
            left = Math.min(left, bloomDay[i]);
            right = Math.max(right, bloomDay[i]);
        }
        int count = 0;
//        int x = 1;
        while (left < right) {
//            System.out.println("******************************");
//            System.out.println("第 " + x + " 次比较");
//            System.out.println("left: " + left + "       right: " + right);
//            System.out.println("******************************");
            count = 0;
            int mid = (left + right) / 2;
            int countTemp = 0;
            for (int i = 0; i < bloomDay.length; i++) {
                if (bloomDay[i] <= mid) {
                    countTemp += 1;
                } else {
                    countTemp = 0;
                }
                if (countTemp == k) {
                    count += 1;
                    countTemp = 0;
                }
            }
            if (count >= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
//            x++;
        }
        return left;
    }
}
