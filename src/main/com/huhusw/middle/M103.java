package com.huhusw.middle;

import java.util.*;

/**
 * @author huhusw
 * @Description
 * @create 2020-12-22 23:53
 */


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}

public class M103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        boolean flag = false;
        Deque<TreeNode> temp = new LinkedList<TreeNode>();
        temp.add(root);
        while (temp != null) {
            int size = temp.size();
            List<Integer> stem = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                //从左到右
                if (flag) {
                    TreeNode treeNode = temp.pollLast();
                    if(treeNode.left!=null){
                        stem.add(treeNode.left.val);

                    }
                }
                //从右到左
                else {
                    TreeNode treeNode = temp.pollFirst();
                }
            }
        }
        return null;
    }
}
