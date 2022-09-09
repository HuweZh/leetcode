package com.huhusw.simple;

import com.huhusw.Node;

import java.util.*;

/**
 * https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/
 * 多叉树的最大深度
 * 层次遍历
 */
public class S559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.children != null && node.children.size() != 0) {
                    for (Node n : node.children) {
                        queue.offer(n);
                    }
                }
            }
            res++;
        }
        return res;
    }
}
