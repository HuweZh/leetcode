package com.huhusw.middle;

import java.util.ArrayList;
import java.util.List;

public class M797 {
    public static void main(String[] args) {
        M797 m797 = new M797();
        List<List<Integer>> lists = m797.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}});
        System.out.println(lists.size());
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> stem = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //节点数量
        int n = graph.length;
        //是否访问过
        int[] visited = new int[n];
        //递归，查找路径
        recursion(n, 0, visited, graph);

        return res;
    }

    private void recursion(int n, int indexOfNode, int[] visited, int[][] graph) {
        //节点访问过，直接返回
        if (visited[indexOfNode] == 1) {
            return;
        }
        //添加节点到访问集合，并且记录路径
        stem.add(indexOfNode);
        visited[indexOfNode] = 1;
        //是否抵达终点
        if (indexOfNode == n - 1) {
            res.add(new ArrayList<>(stem));
            return;
        }
        //遍历当前节点能到达的下一个节点集合
        for (int i = 0; i < graph[indexOfNode].length; i++) {
            recursion(n, graph[indexOfNode][i], visited, graph);
            stem.remove(stem.size() - 1);
            visited[graph[indexOfNode][i]] = 0;
        }
    }

    public List<List<Integer>> allPathsSourceTarget1(int[][] graph) {
        //节点数量
        int n = graph.length;

        //递归，查找路径
        recursion1(n, 0, graph);

        return res;
    }

    private void recursion1(int n, int indexOfNode, int[][] graph) {


        //添加节点到访问集合，并且记录路径
        stem.add(indexOfNode);

        //是否抵达终点
        if (indexOfNode == n - 1) {
            res.add(new ArrayList<>(stem));
            return;
        }
        //遍历当前节点能到达的下一个节点集合
        for (int i = 0; i < graph[indexOfNode].length; i++) {
            recursion1(n, graph[indexOfNode][i], graph);
            stem.remove(stem.size() - 1);
        }
    }
}
