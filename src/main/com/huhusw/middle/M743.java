package com.huhusw.middle;

import java.util.*;

/**
 * 最短路径中的最长路径
 */
public class M743 {
    /**
     * 从节点k发射一个信号，所有节点都收到信号的最短时间，若有节点收不到信号，直接返回-1
     * times记录了节点之间的连接关系和收到信号的时间，即权重
     *
     * @param times 各个节点的连接情况
     * @param n     节点个数
     * @param k     起始节点
     * @return 所有节点接收到信号的最短时间
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        //邻接表，存储所有的节点连接和权重信息
        List<int[]>[] graph = new LinkedList[n + 1];
        //初始化邻接表
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        //构建邻接表，索引对应当前节点，元素为下一个节点和权重
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];
            graph[from].add(new int[]{to, weight});
        }
        //dijkstra算法求当前节点到所有节点的最短时间
        //distTo[i]为起始节点k到i节点的最短时间
        int[] distTo = dijkstra(k, graph);
        //结果
        int res = 0;
        //遍历数组
        for (int i = 1; i < distTo.length; i++) {
            //有节点不能到达，直接返回
            if (distTo[i] == Integer.MAX_VALUE) {
                return -1;
            }
            //获取最大值
            res = Math.max(res, distTo[i]);
        }
        //返回结果
        return res;
    }

    /**
     * dijkstra求最短路径
     *
     * @param start 起始节点
     * @param graph 邻接表
     * @return 起始节点到所有节点的最短路径
     */
    public int[] dijkstra(int start, List<int[]>[] graph) {
        //新建最小堆，存储当前遍历到的节点
        //贪心思想，每次都先访问当前集合中距离最短的路径
        Queue<State> queue = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });
        //起始状态
        queue.offer(new State(start, 0));
        //起始节点到其他节点的距离
        int[] distTo = new int[graph.length];
        //求的是距离最小值，初始化为最大值
        Arrays.fill(distTo, Integer.MAX_VALUE);
        //自己的距离为0
        distTo[start] = 0;
        //遍历所有节点
        while (!queue.isEmpty()) {
            //当前节点的信息
            State stem = queue.poll();
            //当前节点id
            int curId = stem.nodeId;
            //起始节点到当前节点的距离
            int curDistFromStart = stem.distFromStart;
            //备忘录中已经存储过其他路径到当前节点更短的距离，进入下一个节点的遍历
            if (curDistFromStart > distTo[curId]) {
                continue;
            }
            //遍历当前节点的所有邻居
            for (int[] neighbor : graph[curId]) {
                //邻居的id
                int nextId = neighbor[0];
                //从起始节点到邻居节点的距离
                int distToNext = distTo[curId] + neighbor[1];
                //这个距离小于备忘录中的距离，更新距离，并将此邻居加入到队列中
                if (distToNext < distTo[nextId]) {
                    distTo[nextId] = distToNext;
                    queue.offer(new State(nextId, distToNext));
                }
            }
        }
        //返回数组
        return distTo;
    }

    /**
     * 状态类，保存图中节点的状态
     */
    class State {
        //节点id
        private int nodeId;
        //起始节点到此节点的距离
        private int distFromStart;

        public State(int nodeId, int distFromStart) {
            this.nodeId = nodeId;
            this.distFromStart = distFromStart;
        }
    }
}
