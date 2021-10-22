package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.*;

public class M508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        //边界条件
        if (root == null) {
            return null;
        }
        //保存路径和已经路径的个数
        Map<Integer, Integer> map = new HashMap<>();
        //广度优先遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //计算路径和，并放入map
            int sum = dfs(node);
            int count = map.getOrDefault(sum, 0);
            map.put(sum, count + 1);
            //广度优先遍历
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        //排序输出
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        //按照出现的次数降序排列
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e2.getValue() - e1.getValue();
            }
        });
        int max = -1;
        //排序输出
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : list) {
            if (max > e.getValue()) {
                break;
            }
            max = e.getValue();
            res.add(e.getKey());
        }
        //构造结果
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    /**
     * 深度优先遍历路径，计算路径和
     *
     * @param node 根节点
     * @return 当前根节点的路径和
     */
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + dfs(node.left) + dfs(node.right);
    }


    //保存路径和已经路径的个数
    Map<Integer, Integer> cache = new HashMap<>();
    //记录频次最大的数
    int max = -1;

    public int[] findFrequentTreeSum2(TreeNode root) {
        //边界条件
        if (root == null) {
            return null;
        }
        //得到所有的路径，并保存到map
        dfs2(root);
        //排序构造结果
        List<Integer> resList = new ArrayList<>();
        for (Integer key : cache.keySet()) {
            if (cache.get(key) == max) {
                resList.add(key);
            }
        }
        //构造结果
        int[] ans = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            ans[i] = resList.get(i);
        }
        return ans;
    }

    /**
     * 深度优先遍历路径，计算路径以及路径和
     * 在遍历的过程中就能遍历到所有的路径，于是可以直接填充map
     * 并同时更新最高频次，省去了很多重复的遍历
     *
     * @param node 根节点
     * @return 当前节点的路径和
     */
    public int dfs2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //当前节点的路径和
        int left = dfs2(node.left);
        int right = dfs2(node.right);
        int sum = node.val + left + right;
        //更新变量
        cache.put(sum, cache.getOrDefault(sum, 0) + 1);
        max = Math.max(max, cache.get(sum));
        //返回当前节点的路径和，供当前节点的父节点使用
        return sum;
    }
}
