package com.huhusw.bohai;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        TreeSet<Integer> set = new TreeSet<>();
        String res = "";
        while (index < n) {
            set.clear();
            set.add(index);
            queue.offer(index);
            while (!queue.isEmpty()) {
                int stem = queue.poll();
                for (int i = 0; i < n; i++) {
                    if (i == stem) {
                        continue;
                    }
                    if (graph[stem][i] == 1 && !set.contains(i)) {
                        queue.offer(i);
                        set.add(i);
                    }
                }
            }
            index++;
            if (set.size() > res.length()) {
                StringBuilder sb = new StringBuilder();
                for (int num : set) {
                    sb.append(num + 1);
                    sb.append(" ");
                }
                res = sb.toString().substring(0, sb.length() - 1);
            }
        }
        System.out.println(res);
    }
}
