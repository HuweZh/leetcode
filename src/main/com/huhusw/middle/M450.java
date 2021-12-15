package com.huhusw.middle;

import com.huhusw.TreeNode;

/**
 * 根据二叉搜索树的性质，我们可以获取到当前节点的后驱节点和前驱节点
 */
public class M450 {
    /**
     * 二叉搜索树当前结点的后驱节点
     *
     * @param node 当前结点
     * @return 后驱节点的值
     */
    public int successor(TreeNode node) {
        //一步右步步左
        node = node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    /**
     * 二叉搜索树当前节点的前驱节点
     *
     * @param node 当前节点
     * @return 前驱节点的值
     */
    public int predecessor(TreeNode node) {
        //一步左步步右
        node = node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node.val;
    }

    /**
     * 删除等于key的节点
     *
     * @param root 根结点
     * @param key  待删除的值
     * @return 删除节点后的树
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        //没找到等于key的节点
        if (root == null) return null;
        //二叉树的性质，向左子树前进，递归删除左子树
        if (root.val > key) root.left = deleteNode(root.left, key);
            //向右子树前进，递归删除右子树
        else if (root.val < key) root.right = deleteNode(root.right, key);
        else {
            //现在是找到了值相等的节点
            //此节点是叶结点，直接删除
            if (root.left == null && root.right == null) root = null;
                //此节点不是叶结点且有后驱节点
            else if (root.right != null) {
                //将后驱节点的值替换当前节点
                root.val = successor(root);
                //递归删除这个后驱节点
                root.right = deleteNode(root.right, root.val);
            } else {
                //此节点不是叶节点，没有后驱节点，有前驱节点
                //替换前驱节点的值
                root.val = predecessor(root);
                //递归删除这个前驱节点
                root.left = deleteNode(root.left, root.val);
            }
        }
        //返回根结点
        return root;
    }
}
