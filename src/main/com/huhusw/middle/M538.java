package com.huhusw.middle;

import com.huhusw.TreeNode;

public class M538 {
    /**
     * 更新节点的值等于原树中大于或等于 node.val 的值之和
     *
     * @param root 根节点
     * @return 更新后的树
     */
    public TreeNode convertBST(TreeNode root) {
        //中序遍历
        inOrder(root);
        return root;
    }

    //更新节点的值
    int sum = 0;

    /**
     * 中序遍历得到的是一个升序排列，这道题目要求更新的条件是将大于等于的值加起来
     * 所以可以将中序遍历倒过来，得到一个降序的排序
     * 每次都把这个节点的值加到sum变量上，然后再更新节点的值
     *
     * @param root 根节点
     */
    public void inOrder(TreeNode root) {
        //边界条件
        if (root == null) return;
        //倒中序遍历
        inOrder(root.right);
        //更新节点的值
        sum += root.val;
        root.val = sum;
        inOrder(root.left);
    }
}
