package com.huhusw.sword;

/**
 * https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 * 正则匹配
 */
public class S19 {
    /**
     * 字符串s和模式串p是否匹配
     * p中只有 . 和 * 是特殊字符， .匹配一个任意字符，*匹配任意多个前导字符
     * 主要是*号的处理
     * 动规dp[i][j]为s的前i个字符和p的前j个字符是否能成功匹配
     *
     * @param s 字符串
     * @param p 模式串
     * @return 是否匹配
     */
    public boolean isMatch(String s, String p) {
        //定义dp数组
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        //两个空串默认匹配
        dp[0][0] = true;
        //遍历两个字符串进行状态转移
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //找到*号
                if (p.charAt(j - 1) == '*') {
                    //直接将*和前导字符干掉，没有匹配上
                    dp[i][j] = dp[i][j - 2];
                    //再判断一次是否匹配上，匹配的上证明不能直接干掉
                    //需要将匹配的情况加上，两种情况有一种为真即可
                    if (match(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                    }
                } else {
                    //判断其他的情况是否匹配
                    if (match(s, p, i, j)) {
                        //状态转移
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        //返回
        return dp[m][n];
    }

    /**
     * 字符匹配函数
     *
     * @param s      字符串
     * @param p      模式串
     * @param sIndex s的索引
     * @param pIndex p的索引
     * @return 是否匹配
     */
    public boolean match(String s, String p, int sIndex, int pIndex) {
        //根据定义，索引为0代表空串
        if (sIndex == 0) {
            return false;
        }
        //可以匹配任意字符
        if (p.charAt(pIndex - 1) == '.') {
            return true;
        }
        //单个字符匹配
        if (s.charAt(sIndex - 1) == p.charAt(pIndex - 1)) {
            return true;
        }
        return false;
    }
}
