package com.huhusw.middle;

import com.huhusw.TreeNode;

public class M106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    /**
     * 根据中序遍历和后序遍历确定一颗二叉树
     *
     * @param inorder   中序遍历数组
     * @param inStart   中序遍历数组的下界
     * @param inEnd     中序遍历数组的上界
     * @param postorder 后序遍历数组
     * @param postStart 后续遍历数组的下界
     * @param postEnd   后续遍历数组的上界
     * @return 构造的树
     */
    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        //边界条件
        if (postStart > postEnd) {
            return null;
        }
        //1.确定根节点为后序遍历的最后一个元素
        TreeNode root = new TreeNode(postorder[postEnd]);
        //2.确定根节点在中序遍历的索引
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                index = i;
                break;
            }
        }
        //3.确定左子树的个数
        int leftSize = index - inStart;
        //4.递归左右子树
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
}
