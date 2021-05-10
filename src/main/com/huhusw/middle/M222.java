package com.huhusw.middle;

import com.huhusw.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class M222 {
    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        int count = 0;
        queue.add(root);
        while (queue.size() != 0) {
            if (queue.peek().left != null) {
                queue.add(queue.peek().left);
            }
            if (queue.peek().right != null) {
                queue.add((queue.peek().right));
            }
            queue.poll();
            count++;
        }
        return count;
    }

    //递归解法
    public int countNodesDigui(TreeNode root) {
        return 1 + countNodesDigui(root.left) + countNodesDigui(root.right);
    }
}
