package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/decode-ways/
 * 解码方案
 */
public class M91 {
    /**
     * 解码方案
     * A-Z与1-26一一对应，给一个全是数字的字符串，计算有多少种解码方案
     * 动规
     *
     * @param s 字符串
     * @return 解码方案数
     */
    public int numDecodings1(String s) {
        //边界条件
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        //定义dp数组，dp[i]表示s[0..i-1]的解码方案
        int[] dp = new int[n + 1];
        //初始值为1，解出来的为空字符串
        dp[0] = 1;
        //遍历字符串
        for (int i = 1; i <= n; i++) {
            //当前索引对应的元素不是0，可以作为字母添加到结果中
            //继承前一个的方案数
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            //当前元素的前一个元素不是0，且数字在26以内，满足题意，可以将其对应的方案数加到当前元素
            if (i > 1 && s.charAt(i - 2) != '0' && Integer.parseInt(s.substring(i - 2, i)) < 27) {
                dp[i] += dp[i - 2];
            }
        }
        //返回结果
        return dp[n];
    }

    /**
     * 解码方案
     * A-Z与1-26一一对应，给一个全是数字的字符串，计算有多少种解码方案
     * 动规
     * 状态压缩：当前元素的值只与前两个元素有关，不需要定义数组
     *
     * @param s 字符串
     * @return 解码方案数
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int pre = 0;
        int stem = 1;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = 0;
            if (s.charAt(i - 1) != '0') {
                res += stem;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && Integer.parseInt(s.substring(i - 2, i)) < 27) {
                res += pre;
            }
            pre = stem;
            stem = res;
        }
        return res;
    }

    //备忘录，memo[i]表示s[i-1,n]之间的解码方案数
    int[] memo;

    /**
     * 解码方案
     * A-Z与1-26一一对应，给一个全是数字的字符串，计算有多少种解码方案
     * 深度优先搜索
     *
     * @param s 字符串
     * @return 解码方案数
     */
    public int numDecodings2(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        //初始化备忘录
        memo = new int[s.length()];
        //深度优先搜索，从索引为0的位置开始
        return dfs(s, 0);
    }

    /**
     * 深度优先搜索
     *
     * @param s     字符串
     * @param index 此次搜索的起始索引
     * @return 从开始位置到最后的方案数
     */
    public int dfs(String s, int index) {
        //搜到了末尾，本次搜索返回1，代表有一种方案到达了尾部
        if (index >= s.length()) {
            return 1;
        }
        //当前元素是0，搜索到死胡同，返回0，搜索无结果
        if (s.charAt(index) == '0') {
            return 0;
        }
        //当前备忘录有值，直接返回，消除重复子问题
        if (memo[index] != 0) {
            return memo[index];
        }
        //计算方案数
        int res = 0;
        //往下一个位置搜索
        res += dfs(s, index + 1);
        //往满足题目要求的下一个位置搜索
        if (index + 2 <= s.length() && Integer.parseInt(s.substring(index, index + 2)) < 27) {
            res += dfs(s, index + 2);
        }
        //存入备忘录
        memo[index] = res;
        //返回结果
        return res;
    }
}
