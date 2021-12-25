package com.huhusw.middle;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 课程表2，返回一个符合条件的课程顺序
 */
public class M210 {
    /*
    深度优先遍历 拓扑排序
    使用栈来记录拓扑排序，栈底元素的先修课程要求最高，栈顶最小
    从栈顶到栈底的排序就是符合题意的排序
     */

    //邻接表存储图
    List<Integer>[] graph;
    //将课程当做节点，判断节点是否访问过
    //节点有三种状态：0 未访问  1 正在访问，判断环的存在   2 已完成访问
    int[] visited;
    //是否存在环
    boolean isCycle = false;
    //拓扑排序
    //结果数组，使用数组模拟栈，n-1为栈底，0为栈顶
    int[] res;
    //数组的当前索引
    int curIndex;

    /**
     * 拓扑排序
     * 返回一个符合先修要求的课程顺序
     *
     * @param numCourses    课程数量
     * @param prerequisites 先修要求
     * @return 返回课程顺序的数组
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //初始化变量
        visited = new int[numCourses];
        res = new int[numCourses];
        curIndex = numCourses - 1;
        graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<Integer>();
        }
        //构建邻接表
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph[from].add(to);
        }
        //一次访问节点，且只访问一次
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                //进行深度优先遍历
                dfs(i);
            }
        }
        //存在环，就代表没有符合题意的修课顺序
        if (isCycle) {
            return new int[0];
        }
        //返回数组
        return res;
    }

    /**
     * 深度优先遍历
     *
     * @param index 当前课程编号
     */
    public void dfs(int index) {
        //修改当前课程状态为正在访问
        visited[index] = 1;
        //依次访问其邻居
        for (int neighbor : graph[index]) {
            //邻居未被访问，进行遍历
            if (visited[neighbor] == 0) {
                dfs(neighbor);
            }
            //邻居正在被访问，说明生成了环
            if (visited[neighbor] == 1) {
                isCycle = true;
            }
        }
        //压栈
        res[curIndex--] = index;
        //修改状态为已完成访问
        visited[index] = 2;
    }

    /*
       广度优先遍历，拓扑排序
       使用队列进行模拟，利用节点的入度来计算是否入队列
       入度为0的节点代表修课程的前置条件都已经满足
     */
    //邻接表
    List<Integer>[] graphBFS;
    //每个节点的入度
    int[] inDegree;
    //结果数组
    int[] resBFS;
    //结果数组的索引
    int curIndexBFS;

    /**
     * 广度优先遍历，找到符合题意的课程学习顺序
     *
     * @param numCourses    课程数量
     * @param prerequisites 先修课程要求
     * @return 符合题意的修课顺序
     */
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        //初始化
        inDegree = new int[numCourses];
        resBFS = new int[numCourses];
        curIndex = 0;
        //构建邻接表
        graphBFS = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graphBFS[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graphBFS[from].add(to);
            //记录入度
            inDegree[to]++;
        }
        //广度优先搜索
        bfs();
        //全部节点都已经遍历，返回
        if (curIndexBFS == numCourses) {
            return resBFS;
        }
        //否则不存在满足题意的顺序
        return new int[0];
    }

    /**
     * 深度优先搜索
     */
    public void bfs() {
        //队列中存储着入度为0的节点，这些节点是可以直接进行学习的
        Queue<Integer> queue = new LinkedList<>();
        //初始化队列
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        //进行学习
        while (!queue.isEmpty()) {
            int x = queue.poll();
            resBFS[curIndexBFS++] = x;
            for (int neighbor : graphBFS[x]) {
                //相应的邻居的入度都减1
                inDegree[neighbor]--;
                //并更新队列
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
    }
}
