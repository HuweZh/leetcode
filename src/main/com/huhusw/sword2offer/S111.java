package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/vlzXQL/
 * 计算除法，给定一些字符串以及字符串相除的值，计算query中的字符串相除的值
 * <p>
 * 建图，将字符串除法建图，字符串为节点，商为边的权重，于是query中寻找的是从起点到终点边权重的积
 */
public class S111 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //先给节点进行编号
        Map<String, Integer> memo = new HashMap<>();
        int count = 0;
        for (List<String> equation : equations) {
            if (!memo.containsKey(equation.get(0))) {
                memo.put(equation.get(0), count);
                count++;
            }
            if (!memo.containsKey(equation.get(1))) {
                memo.put(equation.get(1), count);
                count++;
            }
        }
        //建图
        List<Pair>[] edges = new List[count];
        for (int i = 0; i < count; i++) {
            edges[i] = new ArrayList<Pair>();
        }
        for (int i = 0; i < values.length; i++) {
            //这里建立双向图
            int start = memo.get(equations.get(i).get(0));
            int end = memo.get(equations.get(i).get(1));
            edges[start].add(new Pair(end, values[i]));
            //反过来除就是商变为倒数
            edges[end].add(new Pair(start, 1 / values[i]));
        }
        //结果
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            //节点不在图中，直接返回不能计算
            if (!memo.containsKey(queries.get(i).get(0)) || !memo.containsKey(queries.get(i).get(1))) {
                res[i] = -1.0;
                continue;
            }
            //此次查询的起点和终点
            int start = memo.get(queries.get(i).get(0));
            int end = memo.get(queries.get(i).get(1));
            //广度优先进行查询
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            double[] dist = new double[count];
            Arrays.fill(dist, -1.0);
            //初始化起点到起点的距离为1
            dist[start] = 1.0;
            while (!queue.isEmpty()) {
                int temp = queue.poll();
                //遍历邻居
                for (Pair p : edges[temp]) {
                    //邻居没有被访问过，计算到此邻居的值，并放入队列
                    if (dist[p.index] < 0) {
                        dist[p.index] = dist[temp] * p.val;
                        queue.offer(p.index);
                    }
                }
            }
            res[i] = dist[end];
        }
        //返回结果
        return res;
    }

    class Pair {
        int index;
        double val;

        Pair(int index, double val) {
            this.index = index;
            this.val = val;
        }
    }
}
