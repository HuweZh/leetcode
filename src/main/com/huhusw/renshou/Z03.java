package com.huhusw.renshou;

import javax.swing.*;
import java.util.*;

public class Z03 {
    static int[] gold;
    static int n;
    static int m;
    static int[] card;
    static int res = Integer.MIN_VALUE;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        gold = new int[n];
        for (int i = 0; i < n; i++) {
            gold[i] = sc.nextInt();
        }
        card = new int[4];
        for (int i = 0; i < 4; i++) {
            card[i] = sc.nextInt();
        }
        sc.close();
        dfs(0, 0, gold[0]);
        System.out.println(res);
    }

    private static void dfs(int step, int index, int sum) {
        if (step == m) {
            res = Math.max(res, sum);
            return;
        }
        char[] chars = new char[m];
        Arrays.fill(chars, '@');
        for (int i = 0; i < 4; i++) {
            chars[step] = (char) (i + 'a');
            if (set.contains(String.valueOf(chars))) {
                continue;
            }
            set.add(String.valueOf(chars));
            if (card[i] != 0) {
                index += i + 1;
                sum += gold[index];
                card[i]--;
                dfs(step + 1, index, sum);
                card[i]++;
                sum -= gold[index];
                index -= (i + 1);
            }
        }
    }
}

/*
30

import java.util.*;

public class Main{
    static int[] gold;
    static int n;
    static int m;
    static int[] card;
    static int res = Integer.MIN_VALUE;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        gold = new int[n];
        for (int i = 0; i < n; i++) {
            gold[i] = sc.nextInt();
        }
        card = new int[4];
        for (int i = 0; i < 4; i++) {
            card[i] = sc.nextInt();
        }
        sc.close();
        dp = new int[n];
        dfs(0, 0, gold[0]);
        System.out.println(res);
    }

    private static void dfs(int step, int index, int sum) {
        if (step == m) {
            res = Math.max(res, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (card[i] != 0) {
                index += i + 1;
                sum += gold[index];
                card[i]--;
                dfs(step + 1, index, sum);
                card[i]++;
                sum -= gold[index];
                index -= (i + 1);
            }
        }
    }
}

 */