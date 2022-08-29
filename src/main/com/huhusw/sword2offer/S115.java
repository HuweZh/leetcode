package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/ur2n8P/
 * 重建序列
 * 拓扑排序
 * 对于子序列来说，元素之间是存在先后的因果顺序的，依据此建图
 * 使用拓扑排序将重建后的序列构建出来，再与目标进行对比
 */
public class S115 {
    public static void main(String[] args) {
        S115 s115 = new S115();
        s115.sequenceReconstruction(new int[]{4, 1, 5, 2, 6, 3}, new int[][]{{5, 2, 6, 3}, {4, 1, 5, 2}});
    }

    /**
     * 拓扑排序
     *
     * @param nums
     * @param sequences
     * @return
     */
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        //建图
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] sequence : sequences) {
            for (int j = 0; j < sequence.length; j++) {
                if (!graph.containsKey(sequence[j] - 1)) {
                    graph.put(sequence[j] - 1, new ArrayList<>());
                }
            }
        }
        //长度不同，可以直接返回，因为要找的是最短序列
        if (nums.length != graph.size()) {
            return false;
        }
        //入度，依据此进行广度优先
        int[] inDegree = new int[graph.size()];
        //建图 初始化入度
        for (int[] sequence : sequences) {
            for (int i = 0; i < sequence.length - 1; i++) {
                int from = sequence[i] - 1;
                int to = sequence[i + 1] - 1;
                List<Integer> integers = graph.get(from);
                integers.add(to);
                graph.put(from, integers);
                inDegree[to]++;
            }
        }
        //广度优先搜索，从入度为0的开始
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[inDegree.length];
        int count = 0;
        //如果queue中一次有两个以上的元素，说明拓扑排序此时的节点是不确定的
        // 也就是说拓扑出来的顺序不是唯一的，即不符合题意
        while (queue.size() == 1) {
            int stem = queue.poll();
            res[count] = stem + 1;
            count++;
            List<Integer> lists = graph.get(stem);
            for (int i = 0; i < lists.size(); i++) {
                inDegree[lists.get(i)]--;
                if (inDegree[lists.get(i)] == 0) {
                    queue.offer(lists.get(i));
                }
            }
        }
        //不符合题意，直接返回
        if (!queue.isEmpty()) {
            return false;
        }
        //判断是否与目标相等
        for (int i = 0; i < inDegree.length; i++) {
            if (res[i] != nums[i]) {
                return false;
            }
        }
        return true;
    }
}
