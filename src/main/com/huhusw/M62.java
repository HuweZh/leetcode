package com.huhusw;

public class M62 {
    public static void main(String[] args) {
        M62 m62 = new M62();
        int i = m62.uniquePaths(51, 9);
        System.out.println(i);
    }

    int result = 0;

    public int uniquePaths(int m, int n) {
        return dp(m,n);
//        return dfs(0, 0, m-1, n-1);
    }

    //动态规划
    //每一个格子的状态由上面和左面格子所决定
    // 转移方程dp[i][j]=dp[i-1][j]+dp[i][j-1]
    public int dp(int m, int n){
        int[][] dp = new int[m][n];
        //初始状态，首行首列的值都为1
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    //递归，超时
    public int dfs(int x0, int y0, int x1, int y1) {
        if(x0 == x1 && y0 == y1){
            return 1;
        }
        else if(x0 == x1){
            return result+dfs(x0,y0+1,x1,y1);
        }
        else if(y0 == y1){
            return result+dfs(x0+1,y0,x1,y1);
        }
        else{
            return result+dfs(x0+1,y0,x1,y1)+dfs(x0,y0+1,x1,y1);
        }
    }

}
