package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class M437 {
    //目标值
    int target = 0;
    //返回值
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        //边界条件
        if (root == null) {
            return res;
        }
        target = targetSum;
        //广度优先遍历所有的节点，并以节点作为根节点遍历路径
        Queue<TreeNode> queue = new LinkedList<>();
        //初始化队列
        queue.add(root);
        //广度优先遍历节点
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //深度优先遍历所有路径
            dfs(node, 0);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return res;
    }

    /**
     * 深度优先遍历以node为根节点的所有路径
     *
     * @param node 根节点
     * @param sum  当前的元素和
     */
    public void dfs(TreeNode node, int sum) {
        //到了叶节点的下面
        if (node == null) {
            return;
        }
        //记录当前元素和
        sum += node.val;
        //符合条件
        if (sum == target) {
            res++;
        }
        //递归遍历剩下的子树
        dfs(node.left, sum);
        dfs(node.right, sum);
    }
}
