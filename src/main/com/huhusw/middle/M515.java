package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M515 {
    public List<Integer> largestValues(TreeNode root) {
        //结果数组
        List<Integer> res = new ArrayList<>();
        //边界条件
        if (root == null) {
            return res;
        }
        //层序遍历队列
        Queue<TreeNode> queue = new LinkedList<>();
        //初始化队列
        queue.add(root);
        //遍历流程
        while (!queue.isEmpty()) {
            //记录每一层的最大值
            int max = Integer.MIN_VALUE;
            //遍历当前层
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode t = queue.poll();
                max = Math.max(max, t.val);
                //加入下一层的节点
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            //保存当前层的最大值
            res.add(max);
        }
        return res;
    }
}
