package com.huhusw.offer;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.nowcoder.com/test/question/done?tid=57540420&qid=1262835#summary
 * 解码的方案数
 * 01字符串映射成字母，有8种情况，分别对应了3位的01字符
 * 求一个01串的所有可能的解码方案数
 * <p>
 * 使用递归，将所有的情况全部递归出来
 * 方案超时
 * 使用动规，设dp[i]为前i个字符的解码方案数
 */
public class WY03 {
    static Set<String> set;

    /**
     * 递归超时
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        set = new HashSet<>();
        set.add("1");
        set.add("0");
        set.add("10");
        set.add("11");
        set.add("100");
        set.add("101");
        set.add("110");
        set.add("111");
        System.out.println(dfs(str, 0, 1));
        System.out.println(dfs(str, 0, 2));
        System.out.println(dfs(str, 0, 3));
        System.out.println(dfs(str, 0, 1) + dfs(str, 0, 2) + dfs(str, 0, 3));
    }

    public static int dfs(String str, int index, int length) {
        if (index + length > str.length()) {
            return 0;
        }
        if (!set.contains(str.substring(index, index + length))) {
            return 0;
        }
        if (index + length == str.length()) {
            return 1;
        }
        return dfs(str, index + length, 1) + dfs(str, index + length, 2) + dfs(str, index + length, 3);
    }

    /**
     * 动规，设dp[i]为前i个字符的解码方案数
     * 只有一个字符时只有一种方案数
     * 当碰到1时，需要考虑跟1的组合
     *
     * @param args
     */
    public static void main2(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        sc.close();
        int n = chars.length;
        //定义dp数组，dp[i]表示前i个字符的方案数，这里要多两个是因为1可能在最后，为了方便计算
        long[] dp = new long[n + 2];
        //只有一个字符的情况
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            //第一个字符就是1时的处理
            if (i == 0) {
                if (chars[i] == '1') {
                    //这里计算的是将当前后后面1个或2个字符连接在一起的方案数
                    dp[i + 1] = 1;
                    dp[i + 2] = 1;
                }
            } else {
                //这里加上上一个情况，也就是当前字符自己为一种情况
                //即单个字符的情况
                dp[i] += dp[i - 1];
                //下面是碰到1的情况
                if (chars[i] == '1') {
                    //假设当前字符的方案数为y，即dp[i]=y
                    //上一个字符的方案数为x，即dp[i-1]=x
                    //对于当前字符为1时，需要往后考虑2个字符，把当前字符和后面的字符连在一起作为整体是一种情况
                    //于是，这里计算的是上一个字符加上当前两个或三个字符的情况
                    //多个字符的情况
                    dp[i + 1] += dp[i - 1];
                    dp[i + 2] += dp[i - 1];
                }
            }
        }
        System.out.println(dp[n - 1]);
    }
}
