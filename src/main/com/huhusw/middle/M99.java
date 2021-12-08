package com.huhusw.middle;

import com.huhusw.TreeNode;

public class M99 {
    //大值节点，被交换到中序遍历序列前面
    TreeNode firstMax = null;
    // 小值节点，被交换到中序遍历后面
    TreeNode lastMin = null;
    //记录中序遍历的当前结点的前驱节点，对比值发现中序遍历序列的被交换的节点
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    /**
     * 恢复一棵交换了两个节点的二叉搜索树
     *
     * @param root 根结点
     */
    //中序遍历找到被交换的两个节点，然后交换他们的值
    public void recoverTree(TreeNode root) {
        //中序遍历找到被交换的节点
        inorder(root);
        if (firstMax != null && lastMin != null) {
            int temp = firstMax.val;
            firstMax.val = lastMin.val;
            lastMin.val = temp;
        }
    }

    /**
     * 中序遍历，找到原序列中被交换的两个节点
     *
     * @param node 当前结点
     */
    public void inorder(TreeNode node) {
        //边界情况
        if (node == null) {
            return;
        }
        //左子树
        inorder(node.left);
        //不符合二叉搜索树序列的节点
        if (node.val < prev.val) {
            //记录当前结点
            lastMin = node;
            //记录第一次出现的错误节点
            if (firstMax == null) {
                firstMax = prev;
            }
        }
        //更新前驱节点
        prev = node;
        //右子树
        inorder(node.right);
    }

}
