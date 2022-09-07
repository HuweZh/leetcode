package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.*;

/**
 * https://leetcode.cn/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
 * 从二叉树一个节点到另一个节点的路径
 * 记录每个节点的父节点，进行dfs遍历
 */
public class M2096 {
    //父节点
    HashMap<Integer, TreeNode> parent = new HashMap<>();
    //当前节点
    HashMap<Integer, TreeNode> curr = new HashMap<>();
    //路径记录
    StringBuilder sb = new StringBuilder();
    //防止回头路
    Set<TreeNode> set = new HashSet<>();
    String res = null;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        //记录节点的数据和节点的关系
        order(root);
        //dfs查找路径
        dfs(curr.get(startValue), destValue);
        return res;
    }

    /**
     * 分别记录路径
     *
     * @param node
     */
    private void order(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            parent.put(node.left.val, node);
        }
        if (node.right != null) {
            parent.put(node.right.val, node);
        }
        curr.put(node.val, node);
        order(node.left);
        order(node.right);
    }

    /**
     * dfs查找从起点到终点的路径
     *
     * @param node
     * @param end
     */
    private void dfs(TreeNode node, int end) {
        //找到结果
        if (node.val == end) {
            res = sb.toString();
            return;
        }
        //访问过的不在访问
        if (set.contains(node)) {
            return;
        }
        //添加当前节点为访问过
        set.add(node);
        //做选择和撤销选择
        if (node.left != null) {
            sb.append('L');
            dfs(node.left, end);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (node.right != null) {
            sb.append('R');
            dfs(node.right, end);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (parent.containsKey(node.val)) {
            sb.append('U');
            dfs(parent.get(node.val), end);
            sb.deleteCharAt(sb.length() - 1);
        }
        set.remove(node);
    }

    /**
     * 还有更简便的做法
     * 从顶点找到前往起点和终点的路
     * 两条路的公共前缀去掉
     * 再把去起点的路都变成U，拼接在一起完成需求
     */
    String left = null;
    String right = null;
    StringBuilder sb2 = new StringBuilder();

    public String getDirections2(TreeNode root, int startValue, int destValue) {
        //分别查找两条路
        dfs2(root, startValue);
        dfs2(root, destValue);
        //去除公共前缀
        int size = left.length() > right.length() ? right.length() : left.length();
        int index = 0;
        for (; index < size; index++) {
            if (left.charAt(index) != right.charAt(index)) {
                break;
            }
        }
        //拼接两条路径
        for (int i = left.length() - 1; i >= index; i--) {
            sb2.append('U');
        }
        for (int i = index; i < right.length(); i++) {
            sb2.append(right.charAt(i));
        }
        return sb2.toString();
    }

    private void dfs2(TreeNode node, int end) {
        if (node.val == end) {
            if (left == null) {
                left = sb2.toString();
            } else {
                right = sb2.toString();
            }
            return;
        }
        if (node.left != null) {
            sb2.append('L');
            dfs2(node.left, end);
            sb2.deleteCharAt(sb2.length() - 1);
        }
        if (node.right != null) {
            sb2.append('R');
            dfs2(node.right, end);
            sb2.deleteCharAt(sb2.length() - 1);
        }
    }
}
