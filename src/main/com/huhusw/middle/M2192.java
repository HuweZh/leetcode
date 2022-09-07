package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/
 * 有向无环图的所有公共祖先
 * 拓扑排序，找出所有的祖先
 */
public class M2192 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        //邻接表
        List<List<Integer>> graph = new ArrayList<>();
        //辅助存储
        List<TreeSet<Integer>> res = new ArrayList<>();
        //结果
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            res.add(new TreeSet<>());
            ans.add(new ArrayList<>());
        }
        //入度表
        int[] inDegree = new int[n];
        //构造邻接表和入度表
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        //广度优先遍历
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int index = queue.poll();
            //直接后代
            for (int child : graph.get(index)) {
                res.get(child).add(index);
                //隔代后代
                for (int parent : res.get(index)) {
                    res.get(child).add(parent);
                }
                //广度遍历
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    queue.offer(child);
                }
            }
        }
        //构造结果
        for (int i = 0; i < n; i++) {
            while (!res.get(i).isEmpty()) {
                ans.get(i).add(res.get(i).pollFirst());
            }
        }
        return ans;
    }
}
