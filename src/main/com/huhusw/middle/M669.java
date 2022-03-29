package com.huhusw.middle;

import com.huhusw.TreeNode;

/**
 * 剪枝二叉搜索树，在[low,high]区间外的节点被剪枝，但是不能影响其他节点的相对顺序
 */
public class M669 {
    /**
     * 剪枝函数
     *
     * @param root 根结点
     * @param low  区间下界
     * @param high 区间上界
     * @return 剪枝后的二叉搜索树
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        //空节点，直接返回
        if (root == null) {
            return null;
        }
        //小于下界
        if (root.val < low) {
            //当前结点的左子树全部剪枝，将右子树接到当前节点的位置
            root = root.right;
            //继续从当前节点进行剪枝
            root = trimBST(root, low, high);
        } else if (root.val > high) {
            //大于上界
            //当前节点的右子树全部剪枝，将左子树接到当前位置
            root = root.left;
            //继续从当前结点进行剪枝
            root = trimBST(root, low, high);
        } else {
            //当前节点符合区间内，更新其左右子树
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        //返回剪枝后的树
        return root;
    }


    /**
     * 第二次尝试二叉树剪枝
     *
     * @param root 根结点
     * @param low  下界
     * @param high 上界
     * @return 剪枝后的二叉搜索树
     */
    public TreeNode trimBST2(TreeNode root, int low, int high) {
        //当前节点为空，直接返回空
        if (root == null) {
            return null;
        }
        //当前节点大于上界，说明当前节点的右子树全部剪掉
        if (root.val > high) {
            //切换当前节点为左子树
            root = root.left;
            //继续遍历左子树
            root = trimBST(root, low, high);
        } else if (root.val < low) {
            //当前节点小于下界，左子树全部剪掉
            //切换到右子树
            root = root.right;
            //继续遍历右子树
            root = trimBST(root, low, high);
        } else {
            //否则正常遍历左右子树
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        //返回剪枝后的树
        return root;
    }
}
