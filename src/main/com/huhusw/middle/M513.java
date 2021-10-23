package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class M513 {
    public int findBottomLeftValue(TreeNode root) {
        //广度优先遍历队列
        Queue<TreeNode> queue = new LinkedList<>();
        //初始化队列
        queue.add(root);
        //初始化返回值
        int res = 0;
        //广度优先搜索
        while (!queue.isEmpty()) {
            //每一层的第一个元素就是这一层的最左边的节点
            // 所以遍历到最下面一层的第一个元素就是所求的结果
            res = queue.peek().val;
            //这一层节点的个数
            int size = queue.size();
            //遍历这一层
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                //先加入左节点
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
        }
        return res;
    }
}
