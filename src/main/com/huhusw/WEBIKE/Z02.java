package com.huhusw.WEBIKE;

import java.util.*;

public class Z02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> {
            int a1 = a[2] / ((a[1] - a[0]));
            int b1 = b[2] / ((b[1] - b[0]));
            if (a1 != b1) {
                return (b1 - a1);
            }
            if (a[2] != b[2]) {
                return b[2] - a[2];
            }
            return (b[1] - b[0]) - (a[1] - a[0]);
        });
        for (int i = 0; i < n; i++) {
            int[] stem = new int[3];
            stem[0] = sc.nextInt();
            stem[1] = sc.nextInt();
            stem[2] = sc.nextInt();
            queue.add(stem);
        }
        sc.close();
        long res = 0;
        ArrayList<int[]> arr = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] stem = queue.poll();
            boolean flag = true;
            for (int[] sss : arr) {
                if (!(sss[0] >= stem[1] || sss[1] <= stem[0])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                arr.add(stem);
                res += stem[2];
            }
        }
        System.out.println(res);
    }
}
