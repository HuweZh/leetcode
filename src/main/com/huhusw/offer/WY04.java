package com.huhusw.offer;

import java.util.*;

/**
 * https://www.nowcoder.com/test/question/done?tid=57507654&qid=1262841#summary
 * 仓库调度
 * 给定一个起始仓库，计算从起始仓库是否能遍历所有仓库，且计算其到达所有仓库的最短时间
 * <p>
 * 从一个节点到达所有节点，且求出最短时间
 * 最短路算法：dijkstra
 */
public class WY04 {
    //存储到达仓库和所需时间
    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    //仓库个数
    static int n;
    //其实仓库
    static int k;
    //邻接表
    static List<ArrayList<Node>> adj;
    //到达其他仓库的距离
    static int[] dist;
    //当前仓库是否被访问过
    static boolean[] used;

    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        //初始化
        adj = new ArrayList<>();
        int m = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Node>());
        }
        dist = new int[n + 1];
        used = new boolean[n + 1];
        //输入路径，记录于邻接表中
        for (int i = 0; i < m; i++) {
            adj.get(sc.nextInt()).add(new Node(sc.nextInt(), sc.nextInt()));
        }
        sc.close();
        //dijkstra
        dijkstra();

        //判断是否有不能到达的仓库
        int time = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                time = -1;
                break;
            } else {
                time = Math.max(time, dist[i]);
            }
        }
        System.out.println(time);
    }

    /**
     * dijkstra算法
     */
    public static void dijkstra() {
        //初始距离为无穷
        Arrays.fill(dist, Integer.MAX_VALUE);
        //起始仓库为0
        dist[k] = 0;
        //遍历所有的仓库
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        //开始遍历
        while (!queue.isEmpty()) {
            //当前的出发仓库编号
            int idx = queue.poll();
            used[idx] = true;
            //当前能达到的仓库
            ArrayList<Node> arr = adj.get(idx);
            for (Node o : arr) {
                //小于当前的距离，则更新距离
                if (dist[o.idx] > dist[idx] + o.cost) {
                    dist[o.idx] = dist[idx] + o.cost;
                    //再一次遍历更新的节点
                    queue.offer(o.idx);
                }
            }
        }
    }
}
