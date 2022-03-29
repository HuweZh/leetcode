package com.huhusw.simple;

import com.huhusw.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 二叉树的最大深度
 */
public class M104 {
    //结果
    int res = 0;
    //记录当前分支的最大深度
    int depth = 0;

    /**
     * @param root 根结点
     * @return 最大深度
     */
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    /**
     * 递归计算最大深度
     *
     * @param node 节点
     */
    public void traverse(TreeNode node) {
        //找到叶子结点，更新结果
        if (node == null) {
            res = Math.max(res, depth);
            return;
        }
        //同属于一层的左右节点，只加一次
        depth++;
        traverse(node.left);
        traverse(node.right);
        //撤销本次的深度增加
        depth--;
    }
}
