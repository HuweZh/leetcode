package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class M623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //边界条件
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        //广度优先搜索队列
        Queue<TreeNode> queue = new LinkedList<>();
        //初始化队列
        queue.add(root);
        //当前层节点的深度
        int currDepth = 1;
        //广度优先搜索
        while (!queue.isEmpty()) {
            //当前层节点的个数
            int n = queue.size();
            //遍历所有节点
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                //满足深度的条件，说明这一层需要加上val的子节点
                if (currDepth == depth - 1) {
                    node.left = new TreeNode(val, node.left, null);
                    node.right = new TreeNode(val, null, node.right);
                } else {
                    //当前层不满足题意，往下遍历
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
            }
            //当前层深度
            currDepth += 1;
        }
        return root;
    }
}
