package com.huhusw.sword;

/**
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * 机器人的活动范围
 */
public class S13 {
    //结果
    int count = 0;
    //是否被访问过
    boolean[][] visited;

    /**
     * 计算机器人的活动范围
     * 机器人只能上下左右移动
     * 一定的位置的坐标位数之和不能大于k
     *
     * @param m 网格
     * @param n 网格
     * @param k 上限
     * @return 活动范围
     */
    public int movingCount(int m, int n, int k) {
        //初始化
        visited = new boolean[m][n];
        //深度优先从00开始搜索
        dfs(m, n, k, 0, 0);
        return count;
    }

    /**
     * 深度优先遍历
     *
     * @param m 网格
     * @param n 网格
     * @param k 要求
     * @param x 当前位置
     * @param y 当前位置
     */
    public void dfs(int m, int n, int k, int x, int y) {
        //越界检查
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return;
        }
        //访问过
        if (visited[x][y]) {
            return;
        }
        //设置为访问过
        visited[x][y] = true;
        //计算当前位置是否符合题意
        if (cal(x, y, k)) {
            //可活动范围+1
            count++;
            //向其他方向进行移动
            dfs(m, n, k, x + 1, y);
            dfs(m, n, k, x - 1, y);
            dfs(m, n, k, x, y + 1);
            dfs(m, n, k, x, y - 1);
        }
        return;
    }

    /**
     * 计算x和y的位数之后是否小于等于k
     *
     * @param x x
     * @param y y
     * @param k k
     * @return 是否小于等于k
     */
    public boolean cal(int x, int y, int k) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y != 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum <= k;
    }
}
