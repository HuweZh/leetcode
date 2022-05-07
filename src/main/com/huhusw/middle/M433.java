package com.huhusw.middle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 * 最小基因变化
 */
public class M433 {
    /**
     * 找到最小次数的基因变化，每次改变一个基因为一次变化
     * 每次变化只有出现在基因库中才算是有效的基因变化
     * 广度优先遍历，将当前基因的所有可能广度遍历一遍，23种变化，都走一遍找到正确结果
     *
     * @param start 起始基因
     * @param end   终止基因
     * @param bank  基因库
     * @return 最小次数
     */
    public int minMutation(String start, String end, String[] bank) {
        //保存基因库
        Set<String> memo = new HashSet<>();
        //在广度遍历时确保不会重复遍历
        Set<String> visited = new HashSet<>();
        for (String b : bank) {
            memo.add(b);
        }
        //两个边界情况
        if (start.equals(end)) {
            return 0;
        }
        if (!memo.contains(end)) {
            return -1;
        }
        //四种基因
        char[] keys = new char[]{'A', 'C', 'T', 'G'};
        //广度优先遍历
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        //结果
        int res = 1;
        //开始遍历
        while (!queue.isEmpty()) {
            //广度遍历
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String tmp = queue.poll();
                //对当前基因进行变异
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (tmp.charAt(i) != keys[j]) {
                            //每次变异一个基因
                            StringBuilder sb = new StringBuilder(tmp);
                            sb.setCharAt(i, keys[j]);
                            String s = sb.toString();
                            //没被访问过且在基因库中
                            if (!visited.contains(s) && memo.contains(s)) {
                                //到了终止变异
                                if (s.equals(end)) {
                                    return res;
                                }
                                //更新状态
                                visited.add(s);
                                queue.offer(s);
                            }
                        }
                    }
                }
            }
            //更新结果
            res++;
        }
        //默认返回
        return -1;
    }
}
