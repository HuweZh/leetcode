package com.huhusw.hard;

import com.huhusw.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 二叉树最大路径和
 */
public class H124 {
    //结果，预先定义一个较小值
    int res = 0x8f8f8f8f;

    /**
     * 最大路径和
     * 路径和的计算可以分为三个部分，左子节点的贡献值+右子节点的贡献值+当前节点的值
     * 但是路径只能在左右两个子节点中选择一个，不能两个都选
     * 所以在更新结果和更新路径的时候，有一定的差别
     *
     * @param root 二叉树根结点
     * @return 返回最大路径和
     */
    public int maxPathSum(TreeNode root) {
        //后序遍历计算最大路径和
        postOrder(root);
        return res;
    }

    /**
     * 后序遍历
     * 左右根
     *
     * @param root 根结点
     * @return 当前节点的贡献值
     */
    public int postOrder(TreeNode root) {
        //空节点，没有贡献值
        if (root == null) {
            return 0;
        }
        //左子节点的贡献值，在左子树和0之间做选择，取大值，也就是意味着左子树贡献值小于0时不走这棵子树
        int left = Math.max(0, postOrder(root.left));
        //右子节点的贡献值，在0和右子树中取大值
        int right = Math.max(0, postOrder(root.right));
        //更新结果，左右根都加一起
        res = Math.max(left + right + root.val, res);
        // System.out.println(left+","+right+","+res);
        //返回该节点的贡献值，这时候只能返回左右里大的值，因为路径不能两颗子树都选
        return Math.max(left, right) + root.val;
    }
}
