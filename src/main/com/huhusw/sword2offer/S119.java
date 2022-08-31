package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/WhsWhI/
 * 最长连续序列
 * 找到数组汇总最长的连续序列，不要求相邻，只要求数字连续
 */
public class S119 {
    /**
     * 并查集
     * 相邻的两数之间建边，并记录当前联通分量的大小
     */
    class UF {
        int[] parent;
        int n;
        int[] size;

        public UF(int n) {
            this.n = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            //更新联通分量的大小，并更新结果
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
                res = Math.max(res, size[rootY]);
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                res = Math.max(res, size[rootX]);
            }
            n--;
        }
    }

    int res = 1;

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        UF uf = new UF(n);
        //map存储数组元素和对应的索引，还有去重的功效
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        //遍历所有的元素
        for (int i = 0; i < n; i++) {
            //分别判断是否有相邻的元素在数组中
            if (map.containsKey(nums[i] - 1)) {
                uf.union(map.get(nums[i]), map.get(nums[i] - 1));
            }
            if (map.containsKey(nums[i] + 1)) {
                uf.union(map.get(nums[i]), map.get(nums[i] + 1));
            }
        }
        return res;
    }

    /**
     * 使用hash表查找最长序列
     *
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        //hash表存储元素
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int res = 0;
        //遍历数组
        for (int num : nums) {
            //有比当前还小的元素，就遍历下一个，因为从num - 1遍历，序列更长
            if (map.containsKey(num - 1)) {
                continue;
            }
            //现在是最小的时候，开始增长
            int curNum = num;
            int curLen = 0;
            while (map.containsKey(curNum)) {
                curNum++;
                curLen++;
            }
            //更新结果
            res = Math.max(res, curLen);
        }
        return res;
    }
}
