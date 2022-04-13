package com.huhusw.sword;

import com.huhusw.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * 二叉树的镜像
 */
public class S27 {
    //中间变量
    TreeNode temp = null;

    /**
     * 输入一棵二叉树，输出其镜像二叉树
     *
     * @param root 二叉树
     * @return 二叉树的镜像
     */
    public TreeNode mirrorTree(TreeNode root) {
        //遍历，并设置镜像
        dfs(root);
        return root;
    }

    /**
     * 遍历树的同时设置镜像
     * 左子树和右子树调换位置，符合前序遍历的条件
     * 在前序遍历的位置调换左右子树
     *
     * @param node
     */
    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        //前序位置，调换左右子树
        temp = node.left;
        node.left = node.right;
        node.right = temp;
        //遍历左右子树
        dfs(node.left);
        dfs(node.right);
    }
}
