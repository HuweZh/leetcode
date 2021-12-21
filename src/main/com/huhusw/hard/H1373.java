package com.huhusw.hard;

import com.huhusw.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求一棵树中的二叉搜索子树的节点值之和的最大值
 */
public class H1373 {
    //返回结果
    int max = 0;

    /**
     * 暴力解法，依次判断每个节点是否为二叉搜索树，分别计算节点值
     * 超时
     *
     * @param root 树的根节点
     * @return 二叉搜索子树的节点值之和
     */
    public int maxSumBST(TreeNode root) {
        //层次遍历当前树
        Queue<TreeNode> queue = new LinkedList<>();
        //初始化
        queue.offer(root);
        //遍历
        while (!queue.isEmpty()) {
            //弹出一个节点
            TreeNode node = queue.poll();
            //判断是否为二叉搜索树
            boolean flag = isBST(Integer.MIN_VALUE, Integer.MAX_VALUE, node);
            // System.out.println(node.val+ " " +flag);
            //计算当前节点的累加和
            int sum = -1;
            //是二叉搜索树，进行计算
            if (flag) {
                //其下所有的节点都符合二叉搜索树，所以不需要再进行判断子树，直接进行计算
                Queue<TreeNode> queue1 = new LinkedList<>();
                queue1.offer(node);
                //遍历当前树
                while (!queue1.isEmpty()) {
                    TreeNode temp = queue1.poll();
                    //计算节点累加值
                    sum = getSum(temp);
                    //更新最大值
                    if (sum > max) {
                        max = sum;
                    }
                    if (temp.left != null) {
                        queue1.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue1.offer(temp.right);
                    }
                }
            } else {
                //分别判断其左右子树是否为二叉搜索树
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

        }
        return max;
    }

    /**
     * 判断是否为二叉搜索树
     *
     * @param min  右子树的最小值
     * @param max  左子树的最大值
     * @param node 当前节点
     * @return 是否为二叉搜索树
     */
    public boolean isBST(int min, int max, TreeNode node) {
        //临界条件
        if (node == null) {
            return true;
        }
        //不符合二叉搜索的条件
        if (node.val <= min || node.val >= max) {
            return false;
        }
        //返回其左右子树的并集
        return isBST(node.val, max, node.right) && isBST(min, node.val, node.left);
    }

    /**
     * 计算当前节点对应树的节点值累加
     *
     * @param node 当前节点
     * @return 树节点的累加和
     */
    public int getSum(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode stem = queue.poll();
            res += stem.val;
            if (stem.left != null) {
                queue.offer(stem.left);
            }
            if (stem.right != null) {
                queue.offer(stem.right);
            }
        }
        return res;
    }

    /**
     * 优化思路，还是判断节点是否为二叉搜索树，在判断的过程中就将结果记录下来
     *
     * @param root 根结点
     * @return 二叉搜索子树的节点值累加和
     */
    public int maxSumBST1(TreeNode root) {
        traverse(root);
        return max;
    }

    /**
     * 后序遍历，判断是否为二叉搜索树，且遍历的同时将结果计算
     * 返回的数组中
     * 0：是否为二叉搜索树，1是，0否
     * 1：当前节点构成树中的最大值
     * 2：当前节点构成树中的最小值
     * 3：当前节点对应的节点累加和
     *
     * @param node 当前节点
     * @return 二叉搜索树构成四要素的数组
     */
    public int[] traverse(TreeNode node) {
        //边界条件
        if (node == null) {
            //空节点，一定是二叉搜索树，返回一个绝对值，但是累加和为0
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        //分别处理其左右子树
        int[] leftValue = traverse(node.left);
        int[] rightValue = traverse(node.right);

        //返回结果
        int[] res = new int[4];
        //是一个二叉搜索树的条件
        if (leftValue[0] == 1 && rightValue[0] == 1 && node.val > leftValue[2] && node.val < rightValue[1]) {
            //当前节点是二叉搜索树
            res[0] = 1;
            //更新当前节点的最大值
            res[1] = Math.min(node.val, leftValue[1]);
            //更新当前节点的最小值
            res[2] = Math.max(node.val, rightValue[2]);
            //更新对应的累加和
            res[3] = leftValue[3] + rightValue[3] + node.val;
            //更新全局变量
            max = Math.max(res[3], max);
        }
        //返回
        return res;
    }
}
