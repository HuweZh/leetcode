package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/beautiful-arrangement/
 * 优美的排列
 * 一个数组的索引和元素值能满足任意一个整除，即为优美
 * 递归回溯，判断符合的队列
 */
public class M526 {
    int N;
    int res;
    ArrayList<Integer> stem;
    boolean[] visited;

    public int countArrangement(int n) {
        N = n;
        stem = new ArrayList<>();
        visited = new boolean[n];
        res = 0;
        dfs(0);
        return res;
    }

    //形参没用到，可以进行简化
    private void dfs(int index) {
        if (stem.size() == N) {
            res++;
            return;
        }
        //这里可以进行简化
        for (int i = 0; i < N; i++) {
            if (!visited[i] && ((i + 1) % (stem.size() + 1) == 0 || (stem.size() + 1) % (i + 1) == 0)) {
                visited[i] = true;
                stem.add(i + 1);
                dfs(i);
                stem.remove(stem.size() - 1);
                visited[i] = false;
            }
        }
    }
}
