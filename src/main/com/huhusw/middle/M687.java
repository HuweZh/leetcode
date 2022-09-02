package com.huhusw.middle;

import com.huhusw.TreeNode;

public class M687 {
    int res;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    /**
     * 深度优先搜索所有符合题意的路径
     *
     * @param node 当前的根节点
     * @return 符合题意的最大值
     */
    public int dfs(TreeNode node) {
        // System.out.print("\t");
        //当前节点为空
        if (node == null) {
            return 0;
        }
        //依次计算以其左右节点为根节点的子树的符合题意的最大长度
        int leftLength = dfs(node.left);
        int rightLength = dfs(node.right);
        //当前节点的左右子树代表的长度
        int currLeft = 0;
        int currRight = 0;
        //左子树的节点符合题意，将左子树的最大长度加1赋值给当前节点的左子树长度
        if (node.left != null && node.left.val == node.val) {
            currLeft += leftLength + 1;
        }
        //右子树的节点符合题意，将右子树的最大长度加1赋值给当前节点的右子树长度
        if (node.right != null && node.right.val == node.val) {
            currRight += rightLength + 1;
        }
        // System.out.println(currRight+currRight);
        // System.out.println(node.val);
        //更新全局的结果变量
        res = Math.max(res, currLeft + currRight);
        //将当前节点的子树最大长度返回
        return Math.max(currLeft, currRight);
    }

    /**
     * 再次回头做题
     */
    int ans = Integer.MIN_VALUE;
    public int longestUnivaluePath2(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return ans==Integer.MIN_VALUE?0:ans-1;
    }
    public int[] dfs2(TreeNode root){
        if(root.left == null && root.right == null){
            return new int[]{root.val,1};
        }
        int[] left =null;
        int[] right =null;
        if(root.left!=null){
            left = dfs2(root.left);
        }
        if(root.right != null){
            right = dfs2(root.right);
        }
        int leftVal = 1;
        int rightVal = 1;
        int res = 1;
        if(left!=null&&root.val == left[0]){
            res += left[1];
            leftVal += left[1];
        }
        if(right != null &&root.val == right[0]){
            res += right[1];
            rightVal += right[1];
        }
        ans = Math.max(ans,res);
        return new int[]{root.val,Math.max(leftVal,rightVal)};
    }
}
