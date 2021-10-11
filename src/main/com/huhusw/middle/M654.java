package com.huhusw.middle;

import com.huhusw.TreeNode;

public class M654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //1.找到当前数组中最大的元素
        //2.构造当前节点
        //3.递归构造当前节点的左右节点，根据最大元素的索引将数组分割
        return build(nums, 0, nums.length - 1);
    }



    /**
     * 构造最大二叉树
     *
     * @param nums 需要构造的数组
     * @param lo   数组的下界
     * @param hi   数组的上界
     * @return 构造的树
     */
    private TreeNode build(int[] nums, int lo, int hi) {
        //边界情况
        if (lo > hi) {
            return null;
        }
        //1.找到当前数组中最大的元素
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = lo; i < hi; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        //2.构造当前节点
        TreeNode root = new TreeNode(max);
        //3.递归构造当前节点的左右节点，根据最大元素的索引将数组分割
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);
        return root;
    }
}
