package com.huhusw;

public class KMP {
    public static void main(String[] args) {
        KMP kmp = new KMP("aaab");
        System.out.println(kmp.search("aaacaaab"));
        System.out.println(kmp.search("aaaaaaab"));
    }

    //dp数组
    public int[][] dp;
    //模板字符串
    public String pat;

    /**
     * 构造函数，将传入的字符串构造成状态dp
     *
     * @param pat
     */
    public KMP(String pat) {
        this.pat = pat;
        int n = pat.length();
        //定义dp数组，处理256个asc字符
        dp = new int[n][256];
        //初始值，遇见第一个字符才会进行状态的转移
        dp[0][pat.charAt(0)] = 1;
        //记录状态，记录模板字符串中是否有相同的部分
        //记录相同部分的最后一个字符对应的状态，初始值为0代表没有相同部分
        int x = 0;
        //遍历模板字符串
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                //复制上一层的状态
                dp[i][j] = dp[x][j];
            }
            //状态推进，只有遇见模板字符串中的字符才会进行状态推进
            dp[i][pat.charAt(i)] = i + 1;
            //更新x的状态，只有遇见相同的字符的情况下才会更新这个状态
            x = dp[x][pat.charAt(i)];
        }
    }

    /**
     * 在给定字符串中搜索模板字符的第一个索引
     *
     * @param txt 给定字符串
     * @return
     */
    public int search(String txt) {
        //字符串长度
        int n = txt.length();
        int m = pat.length();
        //初始状态为0
        int j = 0;
        for (int i = 0; i < n; i++) {
            //状态推进
            j = dp[j][txt.charAt(i)];
            //到达最终状态，返回结果
            if (j == m) {
                return i - m + 1;
            }
        }
        //没搜索到
        return -1;
    }

}
