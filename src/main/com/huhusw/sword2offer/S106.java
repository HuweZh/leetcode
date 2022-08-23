package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/vEAB3K/
 * 二分图
 * 给定一个图，是否能划分成二分图
 */
public class S106 {
    public static void main(String[] args) {
        S106 s106 = new S106();
        s106.isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}});
    }

    final int UNC = 0;
    final int RED = 1;
    final int GRE = 2;
    int[] color;
    boolean vaild;

    /**
     * 对顶点进行染色，相同颜色的为一组
     * dfs遍历一个顶点的全部邻居，并染色
     *
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        vaild = true;
        Arrays.fill(color, UNC);
        for (int i = 0; i < n && vaild; i++) {
            if (color[i] == UNC) {
                dfs(graph, RED, i);
            }
        }
        return vaild;
    }

    private void dfs(int[][] grid, int c, int index) {
        color[index] = c;
        int nextC = c == RED ? GRE : RED;
        for (int neighbor : grid[index]) {
            //这两个判断不能反，因为初始化的颜色都是unc
            //所以需要先判断unc，在判断其他
            if (color[neighbor] == UNC) {
                dfs(grid, nextC, neighbor);
                if (!vaild) {
                    return;
                }
            } else if (color[neighbor] != nextC) {
                vaild = false;
                return;
            }
        }
    }
}
