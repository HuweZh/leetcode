package com.huhusw.sword2offer;

import com.sun.jmx.snmp.EnumRowStatus;

import javax.print.attribute.EnumSyntax;
import java.util.*;

/**
 * https://leetcode.cn/problems/QA2IGt/
 * 先修课程
 * 给出一个合理的课程学习顺序
 */
public class S113 {
    public static void main(String[] args) {
        S113 s113 = new S113();
        s113.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
    }

    /**
     * 拓扑排序
     * 排在前面的一定是先修课程已经全部结束的，可以用入度为0来表示
     * 每次遍历过程中遍历到一个边，就将入度减1，直到为0代表先修课程学完
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //建图
        ArrayList<Integer>[] graph = build(prerequisites);
        //计算入度
        int[] inDegree = new int[prerequisites.length];
        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            inDegree[to]++;
        }
        //按照入度初始化队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            //初始化为不需要先修课程的课程
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        //BFS计算拓扑排序
        int[] res = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            //修习当前课程
            int index = queue.poll();
            res[count] = index;
            count++;
            //遍历当前课程的下一个课程
            for (int next : graph[index]) {
                //入度更新
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        //出现了环，有些课程没有学习
        if (count != numCourses) {
            return new int[]{};
        }
        return res;
    }

    private ArrayList<Integer>[] build(int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[prerequisites.length];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            graph[from].add(to);
        }
        return graph;
    }
}
