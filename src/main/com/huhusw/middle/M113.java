package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class M113 {
    public List<List<Integer>> res = new ArrayList<>();
    int target = 0;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return null;
        }
        target = targetSum;
        dfs(root, null, 0, new LinkedList<Integer>());
        return res;
    }

    public void dfs(TreeNode node, TreeNode parent, int sum, List<Integer> stem) {
        System.out.print("\t");
        if (node == null) {
            System.out.println(sum + " " + target);
            if (sum == target && parent != null && parent.left == null && parent.right == null) {

                res.add(new ArrayList<Integer>(stem));
            }
            return;
        }
        sum += node.val;
        stem.add(0, node.val);
        dfs(node.left, node, sum, stem);
        dfs(node.right, node, sum, stem);
        System.out.println(stem);
        stem.remove(0);
    }

}
