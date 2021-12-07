package com.huhusw.middle;

public class M96 {
    /**
     * 给定数字n，返回能够见[1,n]之间的所有不重复二叉树的数量
     * @param n 给定数字
     * @return 二叉树的数量
     */
    //数学方法
    public int numTrees(int n) {
        //一共20个数
        int[] G = new int[21];
        //初始值
        G[0] = 1;
        G[1] = 1;
        //构造剩下的数
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                G[i] = G[i] + G[j-1]*G[i-j];
            }
        }
        //直接返回
        return G[n];
    }

    //构造方法，利用递归和记录构造全部的二叉树
    //记录是否计算过[start,end]区间，防止重复计算
    int[][] cache;
    public int numTrees2(int n) {
        //if(n == 0) return
        //初始化
        cache = new int[n+1][n+1];
        //计算数量
        return count(1,n);
    }

    private int count(int start, int end) {
        //边界情况，对应的是叶结点为空，所以返回1
        if(start > end){
            return 1;
        }
        //查找记录，进行返回
        if(cache[start][end] != 0)return cache[start][end];
        //构造树，并记录在案
        int res = 0;
        for(int i = start;i <= end; i++) {
            int left = count(start, i - 1);
            int right = count(i + 1, end);
            res += left * right;
        }
        cache[start][end] = res;
        return res;
    }
}
