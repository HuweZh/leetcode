package com.huhusw.simple;

import com.huhusw.TreeNode;

import java.util.ArrayList;

/**
 * @author huhusw
 * @Description
 * @create 2021-05-10 13:39
 */
public class S872 {
    ArrayList<Integer> r1 = new ArrayList<>();
    ArrayList<Integer> r2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        dfs(root1, r1);
        dfs(root2, r2);
        r1.equals(r2);
        if (r1.size() != r2.size()) {
            return false;
        }
        for (int i = 0; i < r1.size(); i++) {
            if (r1.get(i) != r2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root, ArrayList<Integer> r) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            r.add(root.val);
        }
        dfs(root.left, r);
        dfs(root.right, r);
    }
}
