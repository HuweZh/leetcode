package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class M113 {
    //结果
    public List<List<Integer>> res = new ArrayList<>();
    //目标值
    int target = 0;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //边界条件
        if (root == null) {
            return null;
        }
        //记录目标值
        target = targetSum;
        //dfs寻找路径
        dfs(root, null, 0, new Stack<Integer>());
        return res;
    }

    /**
     * 以node为根节点的树中，有哪些路径的元素和等于目标值
     *
     * @param node   根节点
     * @param parent 根节点的父节点
     * @param sum    当前路径和
     * @param stem   记录当前的路径
     */
    public void dfs(TreeNode node, TreeNode parent, int sum, Stack<Integer> stem) {
        //到了叶节点的左右节点
        if (node == null) {
            return;
        }
        //记录路径和元素
        sum += node.val;
        stem.push(node.val);
        //叶节点
        if (node.left == null && node.right == null) {
            //此路径符合条件，将路径加入到结果中
            if (sum == target) {
                res.add(new ArrayList<Integer>(stem));
            }
        }
        //递归遍历左右节点
        dfs(node.left, node, sum, stem);
        dfs(node.right, node, sum, stem);
        //弹出当前节点
        stem.pop();
    }
}

