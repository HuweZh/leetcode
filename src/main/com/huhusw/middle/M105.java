package com.huhusw.middle;

import com.huhusw.TreeNode;

public class M105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 根据前序遍历和中序遍历确定一颗二叉树
     *
     * @param preorder 前序遍历数组
     * @param preStart    前序遍历数组的下界
     * @param preEnd    前序遍历数组的上界
     * @param inorder  中序遍历数组
     * @param inStart     中序遍历数组的下界
     * @param inEnd     中序遍历数组的上界
     * @return 构造的树
     */
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        //边界情况
        if (preStart > preEnd) {
            return null;
        }
        //1.确定根节点，前序遍历的第一个节点
        TreeNode root = new TreeNode(preorder[preStart]);
        // 2.确定根节点在中序遍历数组中的位置
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                index = i;
                break;
            }
        }
        //中序遍历数组中根节点左边的是左子树，右边是右子树
        //根据左子树和右子树的个数确定前序遍历中子树的前序顺序
        int leftSize = index - inStart;
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }
}
