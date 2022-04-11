package com.huhusw.sword;

/**
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * 矩阵中的路径
 */
public class S12 {
    /**
     * 查看矩阵中是否存在word路径
     *
     * @param board 矩阵
     * @param word  单词
     * @return 是否存在
     */
    public boolean exist(char[][] board, String word) {
        //行和列
        int m = board.length;
        int n = board[0].length;
        //遍历矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //从第一个字母开始进行递归
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 深度优先搜索
     *
     * @param board 矩阵
     * @param word  单词
     * @param x     当前的坐标
     * @param y     当前的坐标
     * @param index 当前状态单词的索引
     * @return 是否存在以(x, y)为起点的word序列
     */
    public boolean dfs(char[][] board, String word, int x, int y, int index) {
        //遍历到单词末尾
        if (index == word.length()) {
            return true;
        }
        //边界情况检查
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        //被访问过
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        //修改矩阵，表示被访问过
        board[x][y] = '#';
        //四种情况有一个为true即可
        //分开判断的话会超时
        //放在一起有一个为true，后面的可以不用进行遍历
        boolean res = dfs(board, word, x + 1, y, index + 1) || dfs(board, word, x - 1, y, index + 1) || dfs(board, word, x, y + 1, index + 1) || dfs(board, word, x, y - 1, index + 1);
        //还原矩阵
        board[x][y] = word.charAt(index);
        return res;
    }
}
