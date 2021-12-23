package com.huhusw.middle;

import java.util.ArrayList;
import java.util.LinkedList;
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

    //返回结果
    List<List<Integer>> res2 = new ArrayList<>();

    /**
     * 从0到n-1节点中所有可能的路径
     *
     * @param graph 邻接表
     * @return 路径的集合
     */
    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        //存储路径
        LinkedList<Integer> path = new LinkedList<>();
        //遍历路径
        traverse(graph, 0, path);
        //返回结果
        return res2;
    }

    /**
     * 递归查找所有路径，因为没有环的要求，所以不需要visit数组
     *
     * @param graph 图
     * @param index 当前节点的序号
     * @param path  记录当前路径
     */
    public void traverse(int[][] graph, int index, LinkedList<Integer> path) {
        //添加当前节点到路径上
        path.addLast(index);

        int n = graph.length;
        if (index == n - 1) {
            //到达终点了，存储这条路径
            res2.add(new LinkedList<Integer>(path));
            //弹出最后的节点，找寻其他可能的路径
            path.removeLast();
            return;
        }
        //遍历所有的邻居结点
        for (int v : graph[index]) {
            traverse(graph, v, path);
        }
        //当前节点遍历完成，弹出
        path.removeLast();
    }
}
