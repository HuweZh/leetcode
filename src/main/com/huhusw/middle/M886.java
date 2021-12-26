package com.huhusw.middle;

import java.util.LinkedList;
import java.util.List;

/**
 * 判断是否为二分图
 */
public class M886 {
    //结果
    boolean res = true;
    //邻接表
    List<Integer>[] graph;
    //访问数组
    boolean[] visited;
    //颜色数组
    boolean[] color;

    /**
     * 判断这个图是否是一个可能的二分图
     *
     * @param n        节点的个数，从1开始计
     * @param dislikes 不能被分到一队的记录
     * @return 是否为二分图
     */
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //初始化数组
        visited = new boolean[n + 1];
        color = new boolean[n + 1];
        //构建邻接表
        buildGraph(n, dislikes);
        //因为可能存在不连通的情况，要遍历所有节点一次
        for (int i = 1; i <= n; i++) {
            //当前节点未访问，深度优先遍历节点
            if (!visited[i]) {
                dfs(i);
            }
        }
        return res;
    }

    /**
     * 构建图
     *
     * @param n        节点数量
     * @param dislikes 不能被分到一组的记录
     */
    public void buildGraph(int n, int[][] dislikes) {
        //初始化
        graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        //根据记录构建图，构建的是无向图，即双向图
        for (int[] dis : dislikes) {
            graph[dis[0]].add(dis[1]);
            graph[dis[1]].add(dis[0]);
        }
    }

    /**
     * 深度优先搜索
     *
     * @param index 当前节点编号
     */
    public void dfs(int index) {
        //提前跳出循环
        if (!res) return;
        //标记为已经被访问
        visited[index] = true;
        //依次访问其邻居节点
        for (int v : graph[index]) {
            //没有被访问，修改颜色进行访问
            if (!visited[v]) {
                color[v] = !color[index];
                dfs(v);
            } else {
                //已经访问过且颜色相同，证明不是二分图
                if (color[v] == color[index]) {
                    res = false;
                }
            }
        }
    }
}
