package com.huhusw;

/**
 * @Author huhusw
 * @Date 2020/10/29
 */
public class M129 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int res) {
        if (root == null) {
            return 0;
        }
        res = res * 10 + root.val;
        // 叶节点
        if (root.left == null && root.right == null) {
            return res;
        }
        // 非叶节点
        return sumNumbers(root.left, res) + sumNumbers(root.right, res);
    }
}
