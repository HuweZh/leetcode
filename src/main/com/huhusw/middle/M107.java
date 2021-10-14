package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.*;

public class M107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //边界情况
        if (root == null) {
            return res;
        }
        //先将结果保存在双向队列中，最后从队列中输出
        Deque<List<Integer>> stemRes = new LinkedList<>();
        //层次遍历使用的队列，用以存储节点
        Queue<TreeNode> queue = new LinkedList<>();
        //初始情况
        queue.add(root);


        while (!queue.isEmpty()) {
            //存储该层节点值
            List<Integer> stem = new ArrayList<>();
            //该层节点的数量
            int count = queue.size();
            //将这一层节点全部弹出
            for (int i = 0; i < count; i++) {
                TreeNode treeNode = queue.poll();
                stem.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            stemRes.add(stem);
        }
        //将队列中存储的值弹出到结果队列
        while (!stemRes.isEmpty()) {
            res.add(stemRes.poll());
        }
        return res;
    }

    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        /*
        LinkedList是一个双向链表，add函数可以指定元素添加的位置，每次往头部添加每层的节点值即可
         */
        List<List<Integer>> res = new LinkedList<>();

        //边界情况
        if (root == null) {
            return res;
        }

        //层次遍历使用的队列，用以存储节点
        Queue<TreeNode> queue = new LinkedList<>();
        //初始情况
        queue.add(root);

        while (!queue.isEmpty()) {
            //存储该层节点值
            List<Integer> stem = new ArrayList<>();
            //该层节点的数量
            int count = queue.size();
            //将这一层节点全部弹出
            for (int i = 0; i < count; i++) {
                TreeNode treeNode = queue.poll();
                stem.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            //往头部插入这一层的节点值
            res.add(0, stem);
        }
        return res;
    }
}
