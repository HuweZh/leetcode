package com.huhusw.TXMUSIC;

import com.huhusw.TreeNode;

import java.util.*;

/*
给定一棵二叉树，二叉树的每个结点只有0或2个孩子。
你需要对每个结点赋值一个正整数，使得每个结点的左右子树权值和相等。
 */
public class Z03 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param tree TreeNode类
     * @return int整型
     */
    int res = 0;

    public int getTreeSum(TreeNode tree) {
        // write code here
        dfs(tree);
        return (res + 1) % 1000000007;
    }

    int[] mmmax = new int[2];

    private int dfs(TreeNode node) {
        if (node.left == null) {
            return node.val;

        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int max = Math.max(left, right) + 1;
        res += ((max - left) % 1000000007 + (max - right) % 1000000007);
        res %= 1000000007;
        return (node.val % 1000000007 + max % 1000000007 + max % 1000000007 + (left - node.val)% 1000000007 + (right - node.val)% 1000000007) % 1000000007;
    }

//    private int dfs(TreeNode node) {
//        if (node.left == null) {
//            return node.val;
//        }
//        int left = dfs(node.left);
//        int right = dfs(node.right);
//        int max = Math.max(left, right) + 1;
//        res += ((max - left) % 1000000007 + (max - right) % 1000000007);
//        res %= 1000000007;
//        return (node.val % 1000000007 + max % 1000000007 + max % 1000000007) % 1000000007;
//    }
}
/*
55
    int res = 0;

        public int getTreeSum(TreeNode tree) {
        // write code here
        dfs(tree);
        return (res+1)% 1000000007;
    }

    private int dfs(TreeNode node) {
        if (node.left == null) {
            return node.val;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int max = Math.max(left, right) + 1;
        res += ((max - left)% 1000000007 + (max- right)% 1000000007);
        res %= 1000000007;
        return (node.val% 1000000007  + max% 1000000007  + max% 1000000007) % 1000000007;
    }
 */