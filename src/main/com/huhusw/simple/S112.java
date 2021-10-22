package com.huhusw.simple;

import com.huhusw.TreeNode;

public class S112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //边界条件
        if (root == null) {
            return false;
        }
        return dfs(root, null, targetSum, 0);
    }

    /**
     * 深度优先搜索，判断以node为根节点的树是否有到叶节点的和等于targetSum
     *
     * @param node      根节点
     * @param parent    根节点的父节点
     * @param targetSum 目标值
     * @param sum       当前的路径和
     * @return 返回是否存在这样的路径
     */
    public boolean dfs(TreeNode node, TreeNode parent, int targetSum, int sum) {
        //到了叶节点
        if (node == null) {
            if (sum == targetSum && parent != null && parent.left == null && parent.right == null) {
                return true;
            }
            return false;
        }
        sum += node.val;
        return dfs(node.left, node, targetSum, sum) || dfs(node.right, node, targetSum, sum);
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        //边界条件
        if (root == null) {
            return false;
        }
        //叶节点判断是否得到了目标值
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        //递归左右子树，其中一棵树完成要求即可
        return hasPathSum2(root.left, targetSum - root.val) || hasPathSum2(root.right, targetSum - root.val);
    }
}
