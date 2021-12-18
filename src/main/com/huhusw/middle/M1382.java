package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一棵不平衡的二叉搜索树转化为平衡二叉搜索树
 * 贪心思想，保证构造时，左右子树的节点数相差为1
 */
public class M1382 {
    //存储树对应的节点值
    List<Integer> nodeVal = new ArrayList<>();

    /**
     * 转换函数
     *
     * @param root 原根节点
     * @return 新根节点
     */
    public TreeNode balanceBST(TreeNode root) {
        //中序遍历得到排序
        inOrder(root);
        //构建平衡二叉树
        return buildTree(0, nodeVal.size() - 1);
    }

    /**
     * 中序遍历
     *
     * @param node 当前节点
     */
    public void inOrder(TreeNode node) {
        //当前为空节点，直接返回
        if (node == null) {
            return;
        }
        //左根右遍历
        inOrder(node.left);
        nodeVal.add(node.val);
        inOrder(node.right);
    }

    /**
     * 构造平衡二叉搜索树
     *
     * @param start 当前节点区间的下界
     * @param end   当前节点区间的上界
     * @return 当前节点
     */
    public TreeNode buildTree(int start, int end) {
        //边界条件
        if (start > end) return null;
        //每次取中间的数，保证平衡
        int mid = (start + end) / 2;
        //构造节点，并构造其左右节点
        TreeNode node = new TreeNode(nodeVal.get(mid));
        node.left = buildTree(start, mid - 1);
        node.right = buildTree(mid + 1, end);
        //返回
        return node;
    }
}
