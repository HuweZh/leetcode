package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.*;

public class M102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //边界条件
        if (root == null) {
            return new ArrayList<>();
        }
        // 返回值
        List<List<Integer>> res = new ArrayList<>();
        //存储目前这一层的节点
        Queue<TreeNode> curr = new LinkedList<>();
        //存储下一层的节点
        Queue<TreeNode> next = new LinkedList<>();
        //加入目前的节点
        curr.add(root);
        List<Integer> r = new ArrayList<>();
        while (!curr.isEmpty()) {
            //弹出目前的节点，然后存储值和他的左右节点
            TreeNode stem = curr.poll();
            // System.out.println(stem.val);
            r.add(stem.val);
            if (stem.left != null) {
                next.add(stem.left);
            }
            if (stem.right != null) {
                next.add(stem.right);
            }
            //判断当前节点是否遍历完，遍历完就开始遍历下一层的节点
            if (curr.isEmpty()) {
                while (!next.isEmpty()) {
                    curr.add(next.poll());
                }
                res.add(new ArrayList(r));
                r.clear();
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        //边界条件
        if (root == null) {
            return new ArrayList<>();
        }
        // 返回值
        List<List<Integer>> res = new ArrayList<>();
        //存储目前这一层的节点
        Queue<TreeNode> queue = new LinkedList<>();
        //加入目前的节点
        queue.add(root);
        //临时存储当前层的节点值
        List<Integer> r = new ArrayList<>();
        //记录当前层有多少个节点在队列中，初始值为1
        int count = 1;
        while (!queue.isEmpty()) {
            //当前层的所有节点都被弹出时
            if (count == 0) {
                //重新获取当前层的节点数量
                count = queue.size();
                //保存上一层的结果
                res.add(new ArrayList<>(r));
                r.clear();
            }
            //弹出目前的节点，然后存储值和他的左右节点
            TreeNode stem = queue.poll();
            count--;
            // System.out.println(stem.val);
            r.add(stem.val);
            if (stem.left != null) {
                queue.add(stem.left);
            }
            if (stem.right != null) {
                queue.add(stem.right);
            }
        }
        //最后一层不会执行到count的地方
        res.add(new ArrayList<>(r));
        return res;
    }
}
