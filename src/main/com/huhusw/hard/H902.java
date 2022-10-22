package com.huhusw.hard;

import java.util.*;
//超时
public class H902 {
    public static void main(String[] args) {
        H902 h902 = new H902();
        h902.atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 100);
    }

    int target;
    int sum = 0;
    HashSet<Integer> set = new HashSet<>();

    public int atMostNGivenDigitSet(String[] digits, int n) {
        target = n;
        dfs(digits);
        return set.size();
    }

    public void dfs(String[] digits) {
        if (sum != 0 && sum <= target) {
            set.add(sum);
        }
        if (sum > target) {
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            sum = sum * 10 + Integer.parseInt(digits[i]);
            dfs(digits);
            sum = (sum - Integer.parseInt(digits[i])) / 10;
        }

    }
}
