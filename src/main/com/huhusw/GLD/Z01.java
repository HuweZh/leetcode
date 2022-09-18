package com.huhusw.GLD;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            char[] chars = sc.nextLine().toCharArray();
            Deque<Character> stack = new LinkedList<>();
            int res = 0;
            for (int j = 0; j < chars.length; j++) {
                if (stack.isEmpty()) {
                    stack.push(chars[j]);
                } else if (stack.peek() == chars[j]) {
                    stack.pop();
                    res++;
                } else {
                    stack.push(chars[j]);
                }
            }
            if (res % 2 == 0) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
        sc.close();
    }
}
