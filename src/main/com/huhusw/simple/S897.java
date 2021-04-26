package com.huhusw.simple;

import java.util.ArrayList;

/**
 * @author huhusw
 * @Description
 * @create 2021-04-25 14:57
 */
public class S897 {


    //保存中序遍历的结果，然后根据此结果进行新二叉树的生成
    ArrayList<Integer> res = new ArrayList<>();

    public static void main(String[] args) {

    }

    public TreeNode increasingBST(TreeNode root) {
        //中序遍历
        inorder(root);

        //根据中序遍历结果生成新的二叉树
        TreeNode first = new TreeNode(res.get(0));
        TreeNode temp = first;
        for (int i = 1; i < res.size(); i++) {
            TreeNode node = new TreeNode(res.get(i));
            temp.right = node;
            temp = node;
        }
        return first;
    }

    //中序遍历
    public void inorder(TreeNode root) {
        //左节点
        if (root.left != null) {
            inorder(root.left);
        }
        res.add(root.val);
        //右节点
        if (root.right != null) {
            inorder(root.right);
        }
    }

    //      Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
