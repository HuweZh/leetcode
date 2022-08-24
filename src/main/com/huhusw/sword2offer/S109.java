package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/zlDJc7/
 * 开锁密码
 */
public class S109 {
    /**
     * 广度优先搜索，搜索过的密码不在尝试，直到找到目标
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        //直接返回
        if (target.equals("0000")) {
            return 0;
        }
        //记录死亡的组合
        Set<String> dead = new HashSet<>();
        for (String s : deadends) {
            dead.add(s);
        }
        //不可能找到
        if (dead.contains("0000") || dead.contains(target)) {
            return -1;
        }
        dead.add("0000");
        //广度优先搜索
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //当前层
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                //当前密码所有可能的组合
                for (String str : get(s)) {
                    //只找未访问过的
                    if (!dead.contains(str)) {
                        if (str.equals(target)) {
                            return depth + 1;
                        }
                        dead.add(str);
                        queue.offer(str);
                    }
                }
            }
            depth++;
        }
        return -1;
    }

    /**
     * 获取字符串s的所有可能的下一个密码
     *
     * @param s
     * @return
     */
    private ArrayList<String> get(String s) {
        ArrayList<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            char c = chars[i];
            //替换当前字符
            chars[i] = nextChar(c);
            res.add(new String(chars));
            chars[i] = prevChar(c);
            res.add(new String(chars));
            chars[i] = c;
        }
        return res;
    }

    /**
     * 下一个字符
     *
     * @param c
     * @return
     */
    private char nextChar(char c) {
        return c == '9' ? '0' : (char) (c + 1);
    }

    /**
     * 上一个字符
     *
     * @param c
     * @return
     */
    private char prevChar(char c) {
        return c == '0' ? '9' : (char) (c - 1);
    }
}
