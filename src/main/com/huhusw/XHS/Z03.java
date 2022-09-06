package com.huhusw.XHS;

import java.util.*;

/*
小明的旅途中需要经过一个国家。这个国家有n个城市，编号为1到n。
小明会从1号城市进入，目标是从n号城市出去（即要从1号城市到达n号城市）。
有m条双向道路连接这n个城市，每条道路的长度都是1，并且都有一个过路费（是[1,100000]之间的整数）。
当小明在一号城市时，他可以预先花费X的费用办一张特权卡，他可以获得所有过路费不超过X的道路的通行权（而其他道路无法通过）。
小明一天最多只能走k长度的路，他想知道如果他想在一天之内从1号城市走到n号城市，他最少需要花费多少来办特权卡，即求X的最小值？
 */
public class Z03 {
    static int res = Integer.MAX_VALUE;
    static ArrayList<int[]>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] edge = new int[m][2];
        for (int i = 0; i < m; i++) {
            edge[i][0] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            edge[i][1] = sc.nextInt();
        }
        int[] weight = new int[m];
        for (int i = 0; i < m; i++) {
            weight[i] = sc.nextInt();
        }
        sc.close();
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<int[]>();
        }
        for (int i = 0; i < m; i++) {
            int[] stem = new int[2];
            stem[0] = edge[i][0] - 1;
            stem[1] = weight[i];
            graph[edge[i][1] - 1].add(stem);
            int[] stem2 = new int[2];
            stem2[0] = edge[i][1] - 1;
            stem2[1] = weight[i];
            graph[edge[i][0] - 1].add(stem2);
        }
        edge = null;
        weight = null;
        visited = new boolean[n];
        ArrayList<Integer> arrayList = new ArrayList<>();
        visited[0] = true;
        dfs(0, 0, k, arrayList);
        System.out.println(res);
    }

    private static void dfs(int city, int times, int k, ArrayList<Integer> arrayList) {
        if (times > k) {
            return;
        }
        //符合题意，更新结果
        if (city == visited.length - 1) {
            res = Math.min(res, Collections.max(arrayList));
            return;
        }

        for (int i = 0; i < graph[city].size(); i++) {
            if (visited[graph[city].get(i)[0]]) {
                continue;
            }
            visited[graph[city].get(i)[0]] = true;
            arrayList.add(graph[city].get(i)[1]);
            dfs(graph[city].get(i)[0], times + 1, k, arrayList);
            arrayList.remove(arrayList.size() - 1);
            visited[graph[city].get(i)[0]] = false;
        }
    }
}
