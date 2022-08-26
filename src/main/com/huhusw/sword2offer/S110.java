package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/bP4bmD/
 * 所有路径
 * 在一个有向无环图图中输出所有的路径
 * 因为是有向无环图，所以可以省略访问过的数组
 */
public class S110 {
    //临时存储路径
    List<Integer> stem = new ArrayList<>();
    //结果
    List<List<Integer>> res = new ArrayList<>();

    /**
     * 所有可能的路径
     *
     * @param graph
     * @return
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //加入起点
        stem.add(0);
        //dfs+回溯
        backTrack(graph, 0);
        return res;
    }

    /**
     * 深度优先加回溯
     *
     * @param graph
     * @param index
     */
    private void backTrack(int[][] graph, int index) {
        //找到了终点
        if (index == graph.length - 1) {
            res.add(new ArrayList<>(stem));
            return;
        }
        //对邻居进行遍历
        for (int i = 0; i < graph[index].length; i++) {
            stem.add(graph[index][i]);
            backTrack(graph, graph[index][i]);
            stem.remove(stem.size() - 1);
        }
    }
}
