package com.huhusw.middle;

import com.huhusw.TreeNode;

public class M814 {
    public TreeNode pruneTree(TreeNode root) {
        //构造虚拟头节点，这样除了根节点，就能处理整棵树，最后返回虚拟头节点的左节点即可
        TreeNode newRoot = new TreeNode(10,root,null);
        dfs(newRoot);
        return newRoot.left;
    }

    /**
     * 深度优先搜索符合题意的节点，并赋值为null
     *
     * @param node 当前节点
     * @return 是否不含1的子树
     */
    public boolean dfs(TreeNode node) {
        // System.out.print("\t");
        //遍历到空节点，不做处理
        if (node == null) {
            return true;
        }
        //依次计算当前节点的左右子树是不是不含1的子树
        boolean left = dfs(node.left);
        boolean right = dfs(node.right);
        // System.out.println(node.val + " " + left + " " + right);
        //左子树中不含1，处理左子树
        if (!left) node.left = null;
        //右子树不含1，处理右子树
        if (!right) node.right = null;
        //到了根节点，且不是1，处理掉
        if (node.val == 0 && node.left == null && node.right == null) {
            return false;
        } else {
            return true;
        }
    }
}
