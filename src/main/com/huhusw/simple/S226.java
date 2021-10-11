package com.huhusw.simple;

import com.huhusw.TreeNode;

public class S226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //交换左右子树
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        //继续反转子树的左右子树
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
