package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.Arrays;

public class M105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 根据前序遍历和中序遍历确定一颗二叉树
     *
     * @param preorder 前序遍历数组
     * @param preStart 前序遍历数组的下界
     * @param preEnd   前序遍历数组的上界
     * @param inorder  中序遍历数组
     * @param inStart  中序遍历数组的下界
     * @param inEnd    中序遍历数组的上界
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


    /**
     * 需要注意的是，在数组切片过程中，左右子树的节点个数
     * 切片的运行时间大于不切片2倍多
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;
                break;
            }
        }
        root.left = buildTree2(Arrays.copyOfRange(preorder, 1, 1 + index), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree2(Arrays.copyOfRange(preorder, 1 + index, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return root;
    }
}
