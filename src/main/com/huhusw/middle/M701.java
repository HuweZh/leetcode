package com.huhusw.middle;

import com.huhusw.TreeNode;

/**
 * 二叉搜索树插入新节点
 */
public class M701 {
    /**
     * 插入节点函数
     *
     * @param root 树的根节点
     * @param val  新节点值
     * @return 更新后的树
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //临界情况
        if (root == null) {
            return new TreeNode(val);
        }
        //变量指向树的根结点
        TreeNode node = root;
        //遍历整棵树
        while (node != null) {
            //放在左子树
            if (node.val > val) {
                //左子树不为空，继续向下遍历
                if (node.left != null) {
                    node = node.left;
                } else {
                    //构建左子树
                    node.left = new TreeNode(val);
                    break;
                }
            }
            //右子树
            else {
                //右子树不为空，继续向下遍历
                if (node.right != null) {
                    node = node.right;
                } else {
                    //构建右子树
                    node.right = new TreeNode(val);
                    break;
                }
            }
        }
        //返回节点
        return root;
    }
}
