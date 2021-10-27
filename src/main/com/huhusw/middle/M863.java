package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.*;

public class M863 {
    //记录树中节点的父节点
    Map<TreeNode, TreeNode> parent;

    /**
     * 找出以root为根节点的树中距离target为k的节点值集合
     *
     * @param root   根节点
     * @param target 目标节点
     * @param k      树中距离目标节点为k
     * @return 符合题意的值集合
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //结果
        List<Integer> res = new ArrayList<>();
        //初始化父节点集合
        parent = new HashMap<>();
        //dfs寻找每一个节点的父节点，存储于parent
        dfs(root);
        //bfs遍历树，以target为头节点的深度为k的节点就是符合题意的节点
        Queue<TreeNode> queue = new LinkedList<>();
        //初始化队列
        queue.add(target);
        //因为遍历过程中会产生相同边的不同叫法，会产生重复遍历的问题，这个数组记录是否访问过节点
        Set<TreeNode> visited = new HashSet<>();
        //BFS
        while (!queue.isEmpty()) {
            //当前层的节点数量
            int n = queue.size();
            //到了符合题意的一层，构造结果
            if (k == 0) {
                for (int i = 0; i < n; i++) {
                    res.add(queue.poll().val);
                }
                break;
            }
            //BFS
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                visited.add(node);
                //未访问过的节点才加入队列
                if (node.left != null && !visited.contains(node.left)) {
                    queue.add(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    queue.add(node.right);
                    visited.add(node.right);
                }
                if (parent.getOrDefault(node, null) != null && !visited.contains(parent.get(node))) {
                    queue.add(parent.get(node));
                    visited.add(parent.get(node));
                }
            }
            //更新层数
            k--;
        }
        return res;
    }

    /**
     * 构造每一个节点的父节点
     *
     * @param node 当前节点
     */

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            parent.put(node.left, node);
        }
        if (node.right != null) {
            parent.put(node.right, node);
        }
        dfs(node.left);
        dfs(node.right);
    }
}
