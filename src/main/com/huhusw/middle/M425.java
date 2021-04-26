package com.huhusw.middle;

import java.util.Arrays;
import java.util.Comparator;

public class M425 {
    public static void main(String[] args) {
//        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483646}};
        M425 m425 = new M425();
        int minArrowShots = m425.findMinArrowShots(points);
        System.out.println("hello");
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
//        for (int i = 0; i < points.length; i++) {
//            System.out.println(points[i][1]);
//        }
        int max = points[0][1];
        int index = 1;
        int count = 0;
        while (true) {
            for (int i = index; i < points.length; i++) {
                if (points[i][0] > max) {
                    max = points[i][1];
                    count++;
                    index++;
                    break;
                }
                index++;
            }
            if (index >= points.length) {
                break;
            }
        }
        return ++count;
    }

    // 优化，其实跟上面的思路差不多，只是会简洁一点
    public int findMinArrowShotsOpt(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}
