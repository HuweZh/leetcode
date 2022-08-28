package com.huhusw.YUAN;

import java.util.*;

public class Z02 {
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        while (M > 0) {
            M--;
            int K = sc.nextInt();
            int N = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }
            Map<Integer, Integer> memo = cal(K);
            int left = 0;
            int right = 0;
            int res = Integer.MAX_VALUE;
            while (right != N) {
                if (memo.containsKey(nums[right])) {
                    int c = memo.get(nums[right]);
                    if (c > 0) {
                        count--;
                    }
                    c--;
                    memo.put(nums[right], c);
                }
                while (count == 0) {
                    if (memo.containsKey(nums[left])) {
                        int c = memo.get(nums[left]);
                        if (c == 0) {
                            count++;
                        }
                        c++;
                        memo.put(nums[left], c);
                    }
                    res = Math.min(res, right - left + 1);
                    left++;
                }
                right++;
            }
            System.out.println(res);
        }
        sc.close();
    }

    private static Map<Integer, Integer> cal(int k) {
        Map<Integer, Integer> map = new HashMap<>();
        count = 0;
        while (k != 1) {
            for (int i = 2; i <= k; i++) {
                if (k % i == 0) {
                    k /= i;
                    map.put(i, map.getOrDefault(i, 0) + 1);
                    count++;
                    break;
                }
            }
        }
        return map;
    }
}
