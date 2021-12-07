package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M95 {
    /**
     * 给定一个数n，生成[1,n]所组成的全部二叉搜索树
     *
     * @param n 给定的数
     * @return 全部的二叉搜索树
     */
    public List<TreeNode> generateTrees(int n) {
        //边界情况
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        //构造树
        return buildTree(1, n);

    }

    /**
     * 构造[start,end]之间的所有二叉搜索树
     *
     * @param start 起始位置
     * @param end   终点位置
     * @return 所有二叉搜索树
     */
    public List<TreeNode> buildTree(int start, int end) {
        //当前区间内所有树的结构
        List<TreeNode> allTree = new ArrayList<>();
        //边界情况
        if (start > end) {
            allTree.add(null);
            return allTree;
        }
        //循环构建树
        for (int i = start; i <= end; i++) {
            //分别构建左右子树
            List<TreeNode> leftTree = buildTree(start, i - 1);
            List<TreeNode> rightTree = buildTree(i + 1, end);
            //从左右子树集合中抽取子树构建整棵树
            for(TreeNode left:leftTree){
                for (TreeNode right:rightTree){
                    //以当前结点i构建树
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTree.add(root);
                }
            }
        }
        return allTree;

    }
}
