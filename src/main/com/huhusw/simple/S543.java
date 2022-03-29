package com.huhusw.simple;

import com.huhusw.TreeNode;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 二叉树的直径
 */
public class S543 {

    //结果
    int res = 0;

    /**
     * 计算二叉树的直径
     *
     * @param root 根结点
     * @return 二叉树的直径
     */
    public int diameterOfBinaryTree(TreeNode root) {
        //递归计算二叉树的直径
        traverse(root);
        return res;
    }

    /**
     * 后序遍历计算二叉树的直径
     *
     * @param node 节点
     * @return 当前节点对应的直径贡献
     */
    public int traverse(TreeNode node) {
        //贡献值为0
        if (node == null) {
            return 0;
        }
        //分别计算左右子树的贡献值
        int leftCount = traverse(node.left);
        int rightCount = traverse(node.right);
        // System.out.println(leftCount+","+rightCount);
        //更新结果，当前的一个小团体为左右子树+根结点，因为从零开始计数，所以这里不加1
        res = Math.max(res, leftCount + rightCount);
        //返回的结果是左右子树中较大的值，再加上根结点一个，作为对直径的贡献值
        return Math.max(leftCount, rightCount) + 1;
    }
}
