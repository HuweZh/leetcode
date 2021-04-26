package com.huhusw.middle;

import java.util.*;

/**
 * @Author huhusw
 * @Date 2020/11/1
 */
public class M139 {

    public static void main(String[] args) {

    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        // 初始化第一个空串为合法字符串
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                // 状态转移公式，更新dp[i]
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }
}
