package com.huhusw.simple;

import com.huhusw.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 二叉树的最小深度
 */
public class S111 {
    /**
     * @param root 树的根结点
     * @return 最小深度
     */
    public int minDepth(TreeNode root) {
        //边界情况
        if (root == null) {
            return 0;
        }
        //广度优先搜索队列
        Queue<TreeNode> queue = new LinkedList<>();
        //初始化
        queue.offer(root);
        //结果
        int res = 0;
        //广度优先搜索
        while (!queue.isEmpty()) {
            //遍历当前层的情况
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //对于空节点，继续循环
                if (node == null) {
                    continue;
                }
                //找到了叶结点，直接返回
                if (node.left == null && node.right == null) {
                    return ++res;
                }
                //添加左右节点进入队列
                queue.offer(node.left);
                queue.offer(node.right);
            }
            //更新结果
            res++;
        }
        return res;
    }
}
