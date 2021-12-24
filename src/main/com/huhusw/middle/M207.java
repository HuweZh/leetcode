package com.huhusw.middle;

import java.util.LinkedList;
import java.util.List;

/**
 * 课程表
 */
public class M207 {
    //是否访问过该节点
    boolean[] visited;
    //目前访问的路径中是否已经访问过此节点
    boolean[] onPath;
    //返回结果，默认为true
    boolean res = true;

    /**
     * 是否能修完整个课程
     *
     * @param numCourses    课程数量
     * @param prerequisites 记录了先修课程的情况
     * @return 是否能修完所有课程
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //初始化两个数组
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        //构建邻接表
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        //对所有的节点进行深度优先遍历
        for (int i = 0; i < numCourses; i++) {
            dfs(graph, i);
        }
        //返回结果
        return res;
    }

    /**
     * 构建邻接表，将先修课程转换为有向图，图中无环代表能修
     *
     * @param numCourses    节点的数量
     * @param prerequisites 先修课程的记录情况
     * @return 构建的邻接表
     */
    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        //邻接表
        List<Integer>[] graph = new LinkedList[numCourses];
        //初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        //取出所有的边关系存入邻接表
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        //返回
        return graph;
    }

    /**
     * 深度优先遍历
     *
     * @param graph 邻接表
     * @param s     当前节点
     */
    public void dfs(List<Integer>[] graph, int s) {
        //当前遍历的路径已经访问过该节点，证明有环，不能满足题意
        if (onPath[s]) {
            res = false;
        }
        //防止重复访问同一个节点
        if (visited[s]) {
            return;
        }
        /*前序遍历位置 */
        //更新状态
        visited[s] = true;
        onPath[s] = true;
        //根据邻接表访问下一个节点
        for (int t : graph[s]) {
            dfs(graph, t);
        }
        /*后序遍历位置 */
        //回溯
        onPath[s] = false;
    }
}
