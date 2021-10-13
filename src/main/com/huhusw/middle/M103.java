package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.*;

/**
 * @author huhusw
 * @Description
 * @create 2020-12-22 23:53
 */


public class M103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //边界条件
        if (root == null) {
            return new ArrayList<>();
        }
        // 返回值
        List<List<Integer>> res = new ArrayList<>();
        //存储目前这一层的节点
        Deque<TreeNode> queue = new LinkedList<>();
        //加入目前的节点
        queue.add(root);
        //临时存储当前层的节点值
        Deque<Integer> r = new LinkedList<>();
        //记录当前层有多少个节点在队列中，初始值为1
        int count = 1;
        //确定层数的变化
        boolean isRight2Left = false;
        while (!queue.isEmpty()) {
            //当前层的所有节点都被弹出时
            if (count == 0) {
                //重新获取当前层的节点数量
                count = queue.size();
                //保存上一层的结果
                res.add(new ArrayList<>(r));
                r.clear();
                isRight2Left = !isRight2Left;
            }
            //弹出目前的节点，然后存储值和他的左右节点
            TreeNode stem = queue.poll();
            count--;
            //根据层数变化，确定添加顺序
            if (isRight2Left) {
                r.offerFirst(stem.val);
            } else {
                r.offerLast(stem.val);
            }

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
