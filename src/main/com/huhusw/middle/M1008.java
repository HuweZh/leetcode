package com.huhusw.middle;

import com.huhusw.TreeNode;

/**
 * 根据前序遍历构造二叉搜索树，唯一性
 */
public class M1008 {
    /**
     * 构造二叉搜索树
     *
     * @param preorder 前序遍历数组
     * @return 树的根结点
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        //进行构建
        return buildTree(0, preorder.length - 1, preorder);
    }

    /**
     * 递归构造二叉搜索树
     *
     * @param start    当前区间的下界
     * @param end      当前区间的上界
     * @param preorder 前序遍历
     * @return 每一个节点
     */
    public TreeNode buildTree(int start, int end, int[] preorder) {
        //边界节点
        if (start > end) {
            return null;
        }
        //当前区间的第一个节点就是根节点
        TreeNode node = new TreeNode(preorder[start]);
        //从前序遍历中搜索分界点
        int index = start + 1;
        for (; index <= end; index++) {
            if (preorder[index] > preorder[start]) {
                break;
            }
        }
        //依次构造左右节点
        node.left = buildTree(start + 1, index - 1, preorder);
        node.right = buildTree(index, end, preorder);
        //返回当前节点
        return node;
    }
}
