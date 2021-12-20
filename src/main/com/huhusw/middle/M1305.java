package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并两颗二叉搜索树的节点值，升序排列
 */
public class M1305 {
    /**
     * 合并函数
     *
     * @param root1 第一棵树
     * @param root2 第二棵树
     * @return 合并的节点值对应的升序排列
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        //第一棵树的中序遍历
        List<Integer> tree1 = new ArrayList<>();
        inOrder(root1, tree1);
        //第二棵树的中序遍历
        List<Integer> tree2 = new ArrayList<>();
        inOrder(root2, tree2);
        //结果
        List<Integer> res = new ArrayList<>();
        //归并排序
        int i = 0;
        int j = 0;
        //合并两棵树的节点值
        while (true) {
            //第一棵树的节点全部搞定，循环搞定第二棵树
            if (i == tree1.size()) {
                for (; j < tree2.size(); j++) {
                    res.add(tree2.get(j));
                }
                break;
            }
            //第二棵树的节点全部搞定，循环搞定第一棵树
            if (j == tree2.size()) {
                for (; i < tree1.size(); i++) {
                    res.add(tree1.get(i));
                }
                break;
            }
            //挑选最小的加入结果数组
            if (tree1.get(i) < tree2.get(j)) {
                res.add(tree1.get(i));
                i++;
            } else {
                res.add(tree2.get(j));
                j++;
            }
        }
        //返回
        return res;
    }

    /**
     * 中序遍历一棵树
     *
     * @param root 树根结点
     * @param ans  存储节点值的数组
     */
    public void inOrder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }
}
