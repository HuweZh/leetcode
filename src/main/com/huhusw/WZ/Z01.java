package com.huhusw.WZ;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<String> queue = new PriorityQueue<String>((s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s2.length() - s1.length();
            }
            return s2.compareTo(s1);
        });
        PriorityQueue<String> queue1 = new PriorityQueue<String>((s1, s2) -> {
            return s2.compareTo(s1);
        });
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            queue.add("" + num);
        }

        while (queue1.size() != 3) {
            queue1.add(queue.poll());
        }
        StringBuilder sb = new StringBuilder();
        while(!queue1.isEmpty()){
            sb.append(queue1.poll());
        }
        System.out.println(sb.toString());
    }
}
