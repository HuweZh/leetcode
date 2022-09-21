package com.huhusw.hard;


import javafx.util.Pair;

import java.util.*;

/**
 * https://leetcode.cn/problems/k-similar-strings/
 * 相似度为k的字符串
 * 给两个字母异位词，求在最少交换两个字符的情况下变成另外一个词
 * 广度优先搜索
 * 在迭代过程中如果遇见计算过的词进行剪枝跳过
 */
public class H854 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    /**
     * s1和s2是两个异位词，在最小的交换次数下两个词之间相互转变
     *
     * @param s1
     * @param s2
     * @return
     */
    public int kSimilarity(String s1, String s2) {
        //广度优先搜索
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        //剪枝
        Set<String> visited = new HashSet<>();
        //初始化
        queue.offer(new Pair(s1, 0));
        visited.add(s1);
        //结果
        int step = 0;
        //开始遍历
        while (!queue.isEmpty()) {
            int sz = queue.size();
            //遍历当前层
            for (int i = 0; i < sz; i++) {
                Pair<String, Integer> pair = queue.poll();
                String cur = pair.getKey();
                int pos = pair.getValue();
                if (cur.equals(s2)) {
                    return step;
                }
                //找到第一个不满足题意的索引
                while (pos < s1.length() && cur.charAt(pos) == s2.charAt(pos)) {
                    pos++;
                }
                //后续查找所有的满足题意字母
                for (int j = pos + 1; j < s1.length(); j++) {
                    //位置相同的可以不用管
                    if (cur.charAt(j) == s2.charAt(j)) {
                        continue;
                    }
                    //找到可以交换的字符，并没有访问过，加入队列中
                    if (cur.charAt(j) == s2.charAt(pos)) {
                        String next = swap(cur, pos, j);
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.offer(new Pair(next, pos + 1));
                        }
                    }
                }
            }
            step++;
        }
        return step;
    }

    /**
     * 交换两个字符
     *
     * @param s
     * @param i1
     * @param i2
     * @return
     */
    private String swap(String s, int i1, int i2) {
        char[] chars = s.toCharArray();
        char stem = chars[i1];
        chars[i1] = chars[i2];
        chars[i2] = stem;
        return new String(chars);
    }
}
