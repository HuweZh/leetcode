package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/path-with-minimum-effort/
 * 二维网格中的最短路径
 */
public class M1631 {
    /**
     * 找到从起点到终点花费体力最小的路径，并返回体力的最小值
     *
     * @param heights 二维网格，对应的是高度，高度差代表体力消耗
     * @return 最小的体力消耗
     */
    public int minimumEffortPath(int[][] heights) {
        //网格信息
        int m = heights.length;
        int n = heights[0].length;
        //新建备忘录数组
        int[][] heightMap = new int[m][n];
        //初始化数组为最大值
        for (int i = 0; i < m; i++) {
            Arrays.fill(heightMap[i], Integer.MAX_VALUE);
        }
        //起点
        heightMap[0][0] = 0;
        //优先队列，最小堆
        Queue<State> queue = new PriorityQueue<>((a, b) -> {
            return a.height - b.height;
        });
        //初始化
        queue.offer(new State(0, 0, 0));

        //遍历所有的网格点
        while (!queue.isEmpty()) {
            //弹出当前最小的体力的路径
            State stem = queue.poll();
            //记录当前网格的信息
            int curX = stem.x;
            int curY = stem.y;
            int curHeight = stem.height;
            //到达终点
            if (curX == m - 1 && curY == n - 1) {
                return curHeight;
            }
            //如果备忘录中记录的最小体力消耗比当前节点记录的小，直接返回
            //说明海油其他路径能以更小的代价到达这个节点
            if (curHeight > heightMap[curX][curY]) {
                continue;
            }
            //遍历其邻居
            for (int[] neighbor : getNeighbors(heights, curX, curY)) {
                //邻居的坐标
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                //将此邻居与之前路径的体力最大值进行对比，保存较大值
                //本体中需要保存的是整个路径上的最大体力消耗
                int nextHeight = Math.max(heightMap[curX][curY], Math.abs(heights[curX][curY] - heights[nextX][nextY]));
                //更新备忘录，并添加队列
                if (nextHeight < heightMap[nextX][nextY]) {
                    heightMap[nextX][nextY] = nextHeight;
                    queue.offer(new State(nextX, nextY, nextHeight));
                }
            }
        }
        //正常情况下，不会执行到这
        return -1;
    }

    /**
     * 网格节点的状态信息
     */
    class State {
        //对应坐标
        int x;
        int y;
        //从起点到当前节点的最大体力消耗
        int height;

        public State(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    /**
     * 获取邻居节点坐标
     *
     * @param matrix 网格
     * @param x      当前节点
     * @param y      当前节点
     * @return 邻居集合
     */
    public List<int[]> getNeighbors(int[][] matrix, int x, int y) {
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<int[]> res = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                res.add(new int[]{nx, ny});
            }
        }
        return res;
    }
}
