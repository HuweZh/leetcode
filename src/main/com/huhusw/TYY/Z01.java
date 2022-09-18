package com.huhusw.TYY;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] stem = sc.nextLine().split(",");
            arr[i][0] = Integer.parseInt(stem[0]);
            arr[i][1] = Integer.parseInt(stem[1]);
        }
        sc.close();

        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int l = arr[i][0];
            int r = arr[i][1];
            for (int j = l; j < r; j++) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                res++;
            }
        }
        System.out.println(res);
    }
}
/*
50

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });
        for (int i = 0; i < n; i++) {
            String[] stem = sc.nextLine().split(",");
            queue.add(new int[]{Integer.parseInt(stem[0]), Integer.parseInt(stem[1])});
        }
        sc.close();

        int res = 0;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] > max) {
                max = poll[1];
                res += poll[1] - poll[0];
            }
        }
        System.out.println(res);
    }
}

 */
