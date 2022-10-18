package com.huhusw.TX;

import java.util.*;

public class Z03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.addLast(sc.nextInt());
        }
        sc.close();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (queue.peekFirst() > queue.peekLast()) {
                    res[i] = queue.pollFirst();
                } else {
                    res[i] = queue.pollLast();
                }
            } else {
                if (queue.peekFirst() < queue.peekLast()) {
                    res[i] = queue.pollFirst();
                } else {
                    res[i] = queue.pollLast();
                }
            }
        }
        for(int i = 0; i < n; i++){
            System.out.print(res[i]);
            if(i != n-1){
                System.out.print(" ");
            }
        }
    }
}
