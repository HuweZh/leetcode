package com.huhusw.sword;

import com.huhusw.TreeNode;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * 前序遍历和中序遍历构建树
 */
public class S07 {
    /**
     * 知道前序遍历和中序遍历构造树
     *
     * @param preorder 前序遍历
     * @param inorder  中序遍历
     * @return 树的根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //递归构造树
        TreeNode head = dfs(preorder, 0, preorder.length, inorder, 0, inorder.length);
        return head;
    }

    /**
     * 递归构造树
     *
     * @param preorder 前序遍历
     * @param pStart   前序遍历的起始索引
     * @param pEnd     前序遍历的结束索引
     * @param inorder  中序遍历
     * @param iStart   中序遍历的起始索引
     * @param iEnd     中序遍历的结束索引
     * @return 当前构造的节点
     */
    public TreeNode dfs(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        //退出循环的条件
        if (pStart == pEnd || iStart == iEnd) {
            return null;
        }
        //前序遍历的第一个值是当前部分的根结点
        TreeNode node = new TreeNode(preorder[pStart]);
        //通过中序遍历划分左右子树
        int leftCount = 0;
        for (int i = iStart; i < iEnd; i++) {
            if (inorder[i] == preorder[pStart]) {
                break;
            }
            leftCount++;
        }
        //递归构造节点的左右子树
        node.left = dfs(preorder, pStart + 1, pStart + leftCount + 1, inorder, iStart, iStart + leftCount);
        node.right = dfs(preorder, pStart + leftCount + 1, pEnd, inorder, iStart + leftCount + 1, iEnd);
        //返回节点
        return node;
    }
}
