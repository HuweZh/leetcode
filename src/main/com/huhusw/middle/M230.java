package com.huhusw.middle;

import com.huhusw.TreeNode;

public class M230 {
    public int res = 0;
    public int count = 0;

    /**
     * 找到二叉搜索树中第K大的元素
     *
     * @param root 根节点
     * @param k    第K大
     * @return 第K大的元素
     */
    public int kthSmallest(TreeNode root, int k) {
        //中序遍历找元素
        findK(root, k);
        return res;
    }

    /**
     * 中序遍历二叉树寻找第K大的元素
     *
     * @param root 根节点
     * @param k    顺序
     */
    public void findK(TreeNode root, int k) {
        //边界条件
        if (root == null) return;
        //中序遍历的过程
        findK(root.left, k);
        //寻找第K个元素
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        findK(root.right, k);
    }
}
