package com.huhusw.hard;

public class H37 {

    public void solveSudoku(char[][] board) {
        // 记录某行,某位数字已经被摆放
        boolean[][] row = new boolean[9][9];
        // 记录某列,某位数字已经被摆放
        boolean[][] col = new boolean[9][9];
        // 记录3*3块,某位数字已经被摆放
        boolean[][] block = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    // 第i行,num+1这个数字已经出现
                    row[i][num] = true;
                    // 第j列,num+1这个数字已经出现
                    col[j][num] = true;
                    // 第i/3*3+j/3块,num+1这个数字已经出现
                    block[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }
        dfs(board, row, col, block, 0, 0);
    }

    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j) {
        // 从ij位置搜寻空位置
        while (board[i][j] != '.') {
            // 第i行到头
            j++;
            if (j >= 9) {
                i++;
                j = 0;
            }
//            循环结束
            if (i >= 9) {
                return true;
            }
        }
        for (int num = 0; num < 9; num++) {
            // 相应的块索引
            int blockIndex = i / 3 * 3 + j / 3;
//            都没出现,开始递归
            if (!row[i][num] && !col[j][num] && !block[blockIndex][num]) {
//                尝试填数字
                board[i][j] = (char) (num + '1');
//                修改每行每列的状态
                row[i][num] = true;
                col[j][num] = true;
                block[blockIndex][num] = true;
//                完成了填数字的任务
                if (dfs(board, row, col, block, i, j)) {
                    return true;
                }
//                回溯,修改状态
                else {
                    //  尝试填数字
                    board[i][j] = '.';
//                  修改每行每列的状态
                    row[i][num] = false;
                    col[j][num] = false;
                    block[blockIndex][num] = false;
                }
            }
        }
        return false;
    }

    public void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        H37 h = new H37();
        h.solveSudoku(board);
        h.print(board);
    }
}
