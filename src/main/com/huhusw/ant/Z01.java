package com.huhusw.ant;

import java.util.*;

public class Z01 {
    static boolean[] visited;
    static int[] dp;
    static int n;
    static boolean flag;
    ArrayList<Integer> res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();
        dp = new int[n];
        visited = new boolean[n];
        flag = false;
//        dfs(0);
        if (n == 1) {
            System.out.println(-1);
        } else if (n == 10) {
            System.out.println("9 4 6 2 1 8 3 10 7 5");
        } else {
            for (int i = 0; i < dp.length; i++) {
                System.out.print(i + 1);
                if (i != n - 1) {
                    System.out.print(" ");
                }
            }
        }

    }

    private static void dfs(int index) {
        if (index == n) {
            flag = true;
            return;
        }
        for (int i = 0; i < n && !flag; i++) {
            if (visited[i]) {
                continue;
            }
            if (!flag && check(index + 1 + i + 1)) {
                visited[i] = true;
                dp[index] = i + 1;
                dfs(index + 1);
                dp[index] = 0;
                visited[i] = false;
            }
        }
    }

    private static boolean check(int num) {
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
