package com.huhusw.middle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/open-the-lock/
 * 转动转盘的次数
 */
public class M752 {
    /**
     * 将一个初始的密码锁0000转到target需要的最小步骤
     * 每次只能转动一个盘，且不能转到deadends数组中
     *
     * @param deadends 限制密码
     * @param target   目标密码
     * @return 最小的次数
     */
    public int openLock(String[] deadends, String target) {
        //记录访问过的密码组合
        Set<String> used = new HashSet<>();
        //限制密码被当做已经访问过的
        for (String s : deadends) {
            used.add(s);
        }
        //初始是就访问过初始密码，不符合题意，直接返回
        if (used.contains("0000")) {
            return -1;
        }
        //添加初始值
        used.add("0000");
        //广度优先遍历队列
        Queue<String> queue = new LinkedList<>();
        //初始化队列
        queue.offer("0000");
        //结果
        int res = 0;
        while (!queue.isEmpty()) {
            //遍历当前队列中的全部密码组合
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //当前密码组合
                String str = queue.poll();
                //若target为0000，才能走到这个分支
                if (str.equals(target)) {
                    return res;
                }
                for (int j = 0; j < 4; j++) {
                    //向上拨动第j个密码盘
                    String up = up(str, j);
                    //找到目标
                    if (up.equals(target)) {
                        return ++res;
                    }
                    //当前密码组合未被访问过
                    if (!used.contains(up)) {
                        queue.offer(up);
                        used.add(up);
                    }
                    //向下拨动第j个密码盘
                    String down = down(str, j);
                    //找到目标
                    if (down.equals(target)) {
                        return ++res;
                    }
                    //当前密码组合未被访问过
                    if (!used.contains(down)) {
                        queue.offer(down);
                        used.add(down);
                    }
                }
            }
            //更新步数
            res++;
        }
        return -1;
    }

    /**
     * 向下拨动第j个密码盘
     *
     * @param str 当前密码组合
     * @param j   第j个密码盘
     * @return 拨动后的密码组合
     */
    private String down(String str, int j) {
        char[] chars = str.toCharArray();
        //加
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j] -= 1;
        }
        return new String(chars);
    }

    /**
     * 向上拨动第j个密码盘
     *
     * @param str 当前密码组合
     * @param j   第j个密码盘
     * @return 拨动后的密码组合
     */
    private String up(String str, int j) {
        char[] chars = str.toCharArray();
        //加
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j] += 1;
        }
        return new String(chars);
    }
}
