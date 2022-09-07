package com.huhusw.sword;

import com.huhusw.TreeNode;

import java.util.*;

/**
 * https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * 二叉树的最近公共祖先
 */
public class S68 {
    /**
     * 查找二叉树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q);
    }

    /**
     * 递归查询二叉树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        //找到叶结点
        if (root == null) {
            return null;
        }
        //找到其中一个节点，可以直接返回
        //这一步的目的是pq其中一个是最近祖先
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        //递归查询左右子树
        TreeNode leftChild = find(root.left, p, q);
        TreeNode rightChild = find(root.right, p, q);
        //左右子树中都已经找到，说明当前节点就是最近的祖先
        if (leftChild != null && rightChild != null) {
            return root;
        }
        //肯定能找到一个节点的祖先，返回出去
        return leftChild == null ? rightChild : leftChild;
    }
}
