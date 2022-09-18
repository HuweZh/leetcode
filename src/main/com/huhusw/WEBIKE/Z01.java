package com.huhusw.WEBIKE;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10000001];
        int count = 0;
        while (sc.hasNext()) {
            String[] strings = sc.nextLine().split(",");
            if (strings[0].equals("a")) {
                break;
            }
            for (String s : strings) {
                nums[count] = Integer.parseInt(s.trim());
                count++;
            }
        }
        sc.close();
        int[] dp = new int[count];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int pre = 0;
        for (int i = 0; i < count; i++) {
            int index = i + nums[i];
            int base = dp[i];
            for (int j = pre + 1; i + j < count && j <= index; j++) {
                dp[i + j] = Math.min(dp[i + j], base + 1);
            }
            pre = i + nums[i];
        }
        System.out.println(dp[count - 1]);
    }
}
