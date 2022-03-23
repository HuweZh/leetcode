package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/
 * 打家劫舍3
 */
public class M337 {
    //设 l r 为左右子树
    //f(o)表示选中o节点，也就是意味着o的左右节点不能选择
    //f(o)=g(l)+g(r)+val
    Map<TreeNode, Integer> f = new HashMap<>();
    //g(o)表示不选中o节点，也就是意味着左右子树都可以选择，可以在左右子树中选择大值
    //g(o)=max(g(l),f(l))+max(g(r),f(r))
    Map<TreeNode, Integer> g = new HashMap<>();

    /**
     * 打家劫舍3
     *
     * @param root 根结点
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //深度优先遍历，后序遍历
        dfs(root);
        //返回结果
        return f.get(root) > g.get(root) ? f.get(root) : g.get(root);
    }

    /**
     * dfs后序遍历二叉树
     *
     * @param root
     */
    public void dfs(TreeNode root) {
        //直接返回
        if (root == null) {
            return;
        }
        //左右根的顺序访问节点
        dfs(root.left);
        dfs(root.right);
        //计算f和g
        g.put(root, Math.max(g.getOrDefault(root.left, 0), f.getOrDefault(root.left, 0)) + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0)));
        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
    }
}
