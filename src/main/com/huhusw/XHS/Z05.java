package com.huhusw.XHS;

import java.util.*;

public class Z05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        sc.close();
        int res = 0;
        int index = 1;
        while (set.contains(index)) {
            index++;
            res++;
        }
        System.out.println(res);
    }
}
