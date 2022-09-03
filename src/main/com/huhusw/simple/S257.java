package com.huhusw.simple;

import com.huhusw.TreeNode;

import java.util.*;

/**
 * https://leetcode.cn/problems/binary-tree-paths/
 * 二叉树的所有路径
 * dfs深度优先，碰到叶子结点结束，并回溯
 */
public class S257 {
    //结果
    List<String> res = new ArrayList<>();
    //路径
    List<Integer> stem = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return res;
    }

    /**
     * 深度优先遍历整棵树
     *
     * @param node
     */
    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        //叶子结点
        if (node.left == null && node.right == null) {
            //构造结果
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < stem.size(); i++) {
                sb.append(stem.get(i));
                sb.append("->");
            }
            sb.append(node.val);
            res.add(sb.toString());
            return;
        }
        //添加当前的元素
        stem.add(node.val);
        dfs(node.left);
        dfs(node.right);
        //回溯，撤回当前元素
        stem.remove(stem.size() - 1);
    }
}
