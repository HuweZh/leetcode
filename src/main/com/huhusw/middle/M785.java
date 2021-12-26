package com.huhusw.middle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分图的判定
 */
public class M785 {
    //最终结果
    boolean res = true;
    //当前节点是否被访问过
    boolean[] visited;
    //相邻节点给不同颜色，颜色相同证明不是二分图
    boolean[] color;

    /**
     * 二分图判定函数
     *
     * @param graph 邻接表
     * @return 是否为二分图
     */
    public boolean isBipartite(int[][] graph) {
        //初始化数组
        visited = new boolean[graph.length];
        color = new boolean[graph.length];
        //因为可能存在不连通的节点，所以要遍历一次节点
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i])
                //深度优先或者广度优先都能完成功能
                bfs(i, graph);
        }
        return res;
    }

    /**
     * 深度优先搜索
     *
     * @param index 当前节点编号
     * @param graph 邻接表
     */
    public void dfs(int index, int[][] graph) {
        //判断是否提前终止遍历
        if (!res) return;
        //标记当前节点已经访问过
        visited[index] = true;
        //遍历相邻节点
        for (int w : graph[index]) {
            //节点未访问，修改其颜色并访问
            if (!visited[w]) {
                color[w] = !color[index];
                dfs(w, graph);
            } else {
                //判断颜色是否与之前的颜色相同
                if (color[w] == color[index]) {
                    res = false;
                }
            }
        }
    }

    /**
     * 广度优先搜索
     * @param index 当前节点
     * @param graph 邻接表
     */
    public void bfs(int index, int[][] graph) {
        //提前退出循环
        if (!res) return;
        //队列实现广度优先
        Queue<Integer> queue = new LinkedList<>();
        //初始化队列
        queue.offer(index);
        //遍历
        while (!queue.isEmpty()) {
            if (!res) return;
            int v = queue.poll();
            //修改当前节点为已访问
            visited[v] = true;
            //遍历相邻节点
            for (int w : graph[v]) {
                //未访问过的节点，修改颜色并加入队列
                if (!visited[w]) {
                    color[w] = !color[v];
                    queue.offer(w);
                } else {
                    //访问过且颜色相同，证明不是二分图
                    if (color[v] == color[w]) {
                        res = false;
                    }
                }
            }
        }
    }
}
