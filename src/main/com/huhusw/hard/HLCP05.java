package com.huhusw.hard;

import java.util.*;
import java.util.jar.JarEntry;

public class HLCP05 {
    public static void main(String[] args) {
        HLCP05 hlcp05 = new HLCP05();
        hlcp05.bonus(6, new int[][]{{1, 2}, {1, 6}, {2, 3}, {2, 5}, {1, 4}}, new int[][]{{1, 1, 500}, {2, 2, 50}, {3, 1}, {2, 6, 15}, {3, 1}});
    }

    public static final int MOD = 1000000007;

    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer>[] arr = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        int[] size = new int[n + 1];
        for (int[] ship : leadership) {
            arr[ship[0]].add(ship[1]);
        }
        for (int[] operation : operations) {
            if (operation[0] == 1) {
                size[operation[1]] = (size[operation[1]] + operation[2]) % MOD;
            } else if (operation[0] == 2) {
                size[operation[1]] = (size[operation[1]] + operation[2]) % MOD;
                cal(arr, size, operation[1], operation[2]);
//                for (int index : arr[operation[1]]) {
//                    size[index] = (size[index] + operation[2]) % MOD;
//                }
            } else {
                int res = 0;
                res += size[operation[1]];
                res += calSum(arr, size, operation[1]);
                ans.add(res);
            }
        }
        int[] res = new int[ans.size()];
        int count = 0;
        for (int num : ans) {
            res[count++] = num;
        }
        return res;
    }

    private int calSum(ArrayList<Integer>[] arr, int[] size, int index) {
        int res = 0;
        if (arr[index].size() == 0) {
            return 0;
        }
        for (int i : arr[index]) {
            res = (res + size[i]) % MOD;
            res += calSum(arr, size, i);
        }
        return res;
    }

    private void cal(ArrayList<Integer>[] arr, int[] size, int index, int money) {
        if (arr[index].size() == 0) {
            return;
        }
        for (int i : arr[index]) {
            size[i] = (size[i] + money) % MOD;
            cal(arr, size, i, money);
        }
    }
}
