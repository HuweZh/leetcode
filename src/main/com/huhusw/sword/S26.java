package com.huhusw.sword;

import com.huhusw.TreeNode;

/**
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * 树的子结构
 */
public class S26 {

    /**
     * 判断b是否为a的子结构
     * 规定空节点不是子结构
     * 子结构代表着结构和节点值都相等
     *
     * @param A 树
     * @param B 树
     * @return 是否为子结构
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //遍历两棵树
        return dfs(A, B);
    }

    /**
     * dfs遍历树，同时判断是否为子结构
     *
     * @param node1 树
     * @param node2 树
     * @return node2是否为node1的子结构
     */
    public boolean dfs(TreeNode node1, TreeNode node2) {
        //遇到了空节点，空节点不是子结构，返回
        if (node1 == null || node2 == null) {
            return false;
        }
        //到达当前节点会有三个分支
        //当前节点与node2比较
        //当前节点的左右子树中存在node2的子结构
        //三种情况有一个实现即可
        return judge(node1, node2) || dfs(node1.left, node2) || dfs(node1.right, node2);
    }

    /**
     * t2和t1之间是否结构相同，值相同
     * 即判断是否有相同的结构
     *
     * @param t1 大树
     * @param t2 小树
     * @return 是否有相同的结构
     */
    public boolean judge(TreeNode t1, TreeNode t2) {
        // 第二棵树遇见了空节点，说明t2当前的分支已经遍历到叶结点，其他节点都符合
        if (t2 == null) {
            return true;
        }
        //t1为空，说明t2还有节点，但是t1已经消耗完了，返回false
        if (t1 == null) {
            return false;
        }
        //值不相同，返回false，这里判断值
        if (t1.val != t2.val) {
            return false;
        }
        //判断左右分支是否都成立，这里判断结构
        return judge(t1.left, t2.left) && judge(t1.right, t2.right);
    }
}
