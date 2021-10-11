package com.huhusw.middle;

import com.huhusw.TreeNode;

public class M114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        //先拉平节点的左右子树
        flatten(root.left);
        flatten(root.right);
        //后序遍历的位置
        // 拉平了左右子树后，按照题目的要求处理
        // 1.记录当前的左右子树
        TreeNode left = root.left;
        TreeNode right = root.right;
        //2.嫁接左子树为根节点的右子树，同时设置左子树为空
        root.left = null;
        root.right = left;
        //3.将原来的右子树接到现在右子树上
        TreeNode newRoot = root;
        while (newRoot.right != null) {
            newRoot = newRoot.right;
        }
        newRoot.right = right;
    }
}
