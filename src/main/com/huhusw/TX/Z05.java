package com.huhusw.TX;

import java.util.*;

public class Z05 {

    static StringBuilder sb = new StringBuilder();
    static int resX = 0;
    static int resY = Integer.MAX_VALUE;
    static String res = null;

    static int x = 0;
    static int y = 0;
    static int n;
    static int[] nums;

    static boolean flag = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        sc.close();
        for (int i = sum / 2; i > 0 && flag; i--) {
            x = i;
            y = i - sum;
            dfs(0, 0);
        }
        if (!flag) {
            System.out.println(resX + " " + resY);
            System.out.println(res);

        } else {
            System.out.println(-1);
        }

    }

    private static void dfs(int index, int sumB) {
        if (index == n && sumB == 0) {
            flag = false;
            res = sb.toString();
            resX = x;
            resY = y;
            return;
        }
        if (index == n) {
            return;
        }
        //选x
        sumB += nums[index] * x;
        sb.append('X');
        dfs(index + 1, sumB);
        sb.deleteCharAt(sb.length() - 1);
        sumB -= nums[index] * x;

        //选y
        sumB += nums[index] * y;
        sb.append('Y');
        dfs(index + 1, sumB);
        sb.deleteCharAt(sb.length() - 1);
        sumB -= nums[index] * y;
    }
}
