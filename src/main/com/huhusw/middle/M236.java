package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.*;

public class M236 {
    int count = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //边界条件
        if (root == null) {
            return null;
        }
        //层序遍历队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //返回值
        TreeNode res = new TreeNode();
        //层序遍历整棵树
        while (!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            if (tree.left != null) {
                queue.add(tree.left);
            }
            if (tree.right != null) {
                queue.add(tree.right);
            }
            //判断是否符合最近公共祖先
            count = 0;
            if (getRoot(tree, p, q)) {
                res = tree;
            }
        }
        return res;
    }

    /**
     * 判断以node为根节点的树是否即含有p又含有q
     * 以node为根节点的树包含两个目标节点的话，node肯定是符合题意的祖先节点
     * 再根据层序遍历，往下继续搜索，指导搜索出最近公共祖先
     * 搜索的步骤会有重复和一些肯定不包含的情况
     *
     * @param node 根节点
     * @param p    目标节点
     * @param q    目标节点
     * @return 该树同时含有两个目标节点，返回true
     */
    public boolean getRoot(TreeNode node, TreeNode p, TreeNode q) {
        //到了根节点，进行返回
        if (node == null) {
            return count == 2;
        }
        //该节点如果等于目标节点
        if (node.val == p.val || node.val == q.val) {
            count++;
        }
        //递归判断左右子树，其中一棵子树符合条件即可，说明该根节点在一个更大的程度上是符合题意的，继续想下遍历即可
        return getRoot(node.left, p, q) || getRoot(node.right, p, q);
    }

    TreeNode ans = new TreeNode();
    //保存节点的父节点
    Map<Integer, TreeNode> cache = new HashMap<>();
    //保存访问过的节点
    Set<TreeNode> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //保存树的结构
        dfs(root);
        //从p遍历
        while (p != null) {
            visited.add(p);
            p = cache.getOrDefault(p.val, null);
        }
        //再从q遍历
        while (q != null) {
            if (visited.contains(q)) {
                return q;
            }
            q = cache.getOrDefault(q.val, null);
        }
        return null;
    }

    /**
     * 遍历树，记录每一个节点的父节点
     *
     * @param root 树的根节点
     */
    private void dfs(TreeNode root) {
        if (root.left != null) {
            cache.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            cache.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
