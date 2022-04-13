package com.huhusw.sword;

import com.huhusw.TreeNode;

/**
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * 对称的二叉树
 */
public class S28 {
    /**
     * 判断一棵树是否镜像对称
     * 镜像对称是指树与镜像树完全一样
     *
     * @param root 树
     * @return 是否镜像对称
     */
    public boolean isSymmetric(TreeNode root) {
        //边界情况
        if (root == null) {
            return true;
        }
        //根结点的左右子树
        return check(root.left, root.right);
    }

    /**
     * 检查是否相等对称
     *
     * @param t1 节点
     * @param t2 节点
     * @return
     */
    public boolean check(TreeNode t1, TreeNode t2) {
        //有一个节点为空的情况
        if (t1 == null || t2 == null) {
            return t1 == t2;
        }
        //节点值不相等，不可能为对称
        if (t1.val != t2.val) {
            return false;
        }
        //除开根结点，其他节点都需要判断两次
        return check(t1.left, t2.right) && check(t1.right, t2.left);
    }
}
