package com.huhusw.middle;

import java.util.*;

/**
 * 交换字符串中的元素，构成字典序最小的字符串
 */
public class M1202 {
    /**
     * 交换字符串中成对的字符任意次，组成字典序最小的字符串
     *
     * @param s     字符串
     * @param pairs 成对字符
     * @return 字典序最小的字符串
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        //边界情况
        if (s == null || s.length() == 0) {
            return null;
        }
        //新建并查集
        int n = s.length();
        UF uf = new UF(n);
        //存储联通分量，键为并查集中的祖先节点，值为各个联通字符构成的最小堆队列
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        //构建并查集
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        //遍历字符串构建联通分量
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            PriorityQueue<Character> queue = map.getOrDefault(root, new PriorityQueue<Character>());
            queue.offer(s.charAt(i));
            map.put(root, queue);
        }
        //构造字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(uf.find(i)).poll());
        }
        //返回
        return sb.toString();
    }

    /**
     * 并查集
     */
    class UF {
        private int[] parent;
        private int[] size;

        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) {
                return;
            }
            if (size[rootI] > size[rootJ]) {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
            } else {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            }
        }
    }
}
