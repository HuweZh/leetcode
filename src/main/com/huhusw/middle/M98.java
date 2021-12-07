package com.huhusw.middle;

import com.huhusw.TreeNode;

public class M98 {
    /**
     * 判断以root为根结点的树是二叉搜索树
     * 递归方法
     *
     * @param root 根结点
     * @return 是否为二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        //判断是否二叉搜索树
        return judge(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    /**
     * 判断node结点是否符合二叉搜索的节点性质
     *
     * @param node 树中的某一个节点
     * @param max  左子树的最大值
     * @param min  右子树的最小值
     * @return 该节点是否符合定义
     */
    public boolean judge(TreeNode node, long max, long min) {
        //叶结点
        if (node == null) {
            return true;
        }
        //不符合二叉搜索树的定义
        if (node.val >= max || node.val <= min) {
            return false;
        }
        //结点的左子树，修改最大值
        boolean left = judge(node.left, node.val, min);
        //结点的右子树，修改最小值
        boolean right = judge(node.right, max, node.val);
        //返回两个子树的并集
        return left && right;
    }

    /**
     * 判断以root为根结点的树是二叉搜索树
     * 中序遍历
     *
     * @param root 根结点
     * @return 是否为二叉搜索树
     */

    //前一个结点的值
    long pre = Long.MIN_VALUE;

    public boolean isValidBST2(TreeNode root) {
        //边界情况，叶节点
        if(root == null){
            return true;
        }
        //左节点，左子树应该是一棵二叉搜索树
        if(!isValidBST2(root.left)){
            return false;
        }
        //判断中序遍历是否符合升序
        if(root.val <= pre){
            return false;
        }
        //更新前一个值
        pre = root.val;
        //向右子树遍历
        return isValidBST2(root.right);
    }
}
