package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/path-with-maximum-probability/
 * 求从起点到终点概率最大的一条路径，并返回概率值
 */

public class M1514 {
    /**
     * 求从start到end的路径，路径的权重为选择这条路的概率，求出概率最大的路径，并返回此概率
     *
     * @param n        节点数
     * @param edges    边关系
     * @param succProb 每条边对应的概率
     * @param start    起点
     * @param end      终点
     * @return 概率值
     */
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        //邻接表
        List<double[]>[] graph = new LinkedList[n];
        //初始化邻接表
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        //赋值邻接表
        for (int i = 0; i < succProb.length; i++) {
            int form = edges[i][0];
            int to = edges[i][1];
            double succ = succProb[i];
            //无向图就是双向图，先将序号转成double
            graph[form].add(new double[]{to, succ});
            graph[to].add(new double[]{form, succ});
        }
        //dijkstra算法
        return dijkstra(start, end, graph);
    }

    /**
     * 状态类，保存节点的编号和从起点到达此节点的概率值
     */
    class State {
        int id;
        double distFromStart;

        public State(int id, double distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    /**
     * dijkstra算法求最短路径
     *
     * @param start 起点
     * @param end   终点
     * @param graph 邻接表
     * @return 概率值
     */
    public double dijkstra(int start, int end, List<double[]>[] graph) {
        //记录从起点到当前节点的概率最大值
        double[] distTo = new double[graph.length];
        //初始化为不可能到达的最小值
        Arrays.fill(distTo, Double.MIN_VALUE);
        //初始化
        distTo[start] = 1;

        //优先队列，最大堆
        Queue<State> queue = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.distFromStart, a.distFromStart);
        });
        //初始化
        queue.offer(new State(start, 1));
        //遍历队列
        while (!queue.isEmpty()) {
            //队列头
            State state = queue.poll();
            //当前节点
            int curId = state.id;
            //从起点到当前节点的距离
            double curDis = state.distFromStart;
            // for(int i = 0; i < distTo.length; i++){
            //     System.out.print(distTo[i] + "  ");
            // }
            // System.out.println();
            //遍历到了终点
            if (curId == end) {
                return curDis;
            }
            //已经存在一个概率更大的路径
            if (curDis < distTo[curId]) {
                continue;
            }
            //遍历邻居
            for (double[] neigh : graph[curId]) {
                //下一个节点
                int nextId = (int) neigh[0];
                //此路径到下一个节点的概率
                double nextDis = distTo[curId] * neigh[1];
                //此概率大于备忘录中的值，更新，并加入队列
                if (nextDis > distTo[nextId]) {
                    distTo[nextId] = nextDis;
                    queue.offer(new State(nextId, nextDis));
                }
            }
        }
        //到这意味着存在无法到达的节点
        return 0.0;
    }
}
