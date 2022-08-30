package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/H6lPxb/
 * 相似的字符串
 * 判断一个字符串数组中有多少个相似字符串组，任意交换两个字符等于另一个字符串代表相似
 * 并查集，所有的字符串看成一个节点，相似的就连一个边，最终查看联通分量
 */
public class S117 {
    class UF {
        int[] parent;
        int count;

        UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) {
                return;
            }
            parent[rootI] = rootJ;
            count--;
        }

        public int get() {
            return count;
        }
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UF uf = new UF(n);
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (check(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }
        return uf.get();
    }

    /**
     * 检查是否相似
     * 两个字符串中两个字符不相同即为相似
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean check(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count == 2;
    }
}
