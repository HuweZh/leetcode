package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 序列化一棵二叉搜索树，并且相应的反序列化出来
 * 对于一般的树要想反序列出来，需要序列化空节点才能确定唯一的树
 * 但是对于二叉搜索树来说，只需要前序、后序遍历即可，我们可以根据大小关系去确定左右子树
 */
public class M449 {
    /**
     * 序列化二叉搜索树，使用前序遍历
     *
     * @param root 根结点
     * @return 序列化的结果
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //保存序列化的结果
        StringBuilder sb = new StringBuilder();
        //前序遍历序列化二叉搜索树
        preOrder(root, sb);
        //返回结果
        return sb.toString();
    }

    /**
     * 前序遍历序列化二叉搜索树
     *
     * @param node 当前节点
     * @param sb   序列化的结果
     */
    public void preOrder(TreeNode node, StringBuilder sb) {
        //空节点不管
        if (node == null) return;
        //添加当前结点到结果中，并添加一个分隔符
        sb.append(node.val + " ");
        //依次访问左右子树
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    /**
     * 反序列化二叉搜索树
     *
     * @param data 需要反序列化的数据
     * @return 返回最终的根结点
     */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //空数据直接返回空
        if (data.length() == 0) return null;
        //保存树节点对应的值
        List<Integer> nums = new ArrayList<>();
        //根据分隔符进行分割，并保存
        for (String s : data.split(" ")) {
            nums.add(Integer.parseInt(s));
        }
        //反序列化
        return decode(0, nums.size() - 1, nums);
    }

    /**
     * 反序列化过程
     *
     * @param start 当前区间的起始索引
     * @param end   当前区间的末尾索引
     * @param nums  全部节点对应的值，前序遍历保存
     * @return
     */
    public TreeNode decode(int start, int end, List<Integer> nums) {
        //遇到空节点，直返返回
        if (start > end) return null;
        //当前区间的根结点，前序遍历的第一个节点为根结点
        TreeNode node = new TreeNode(nums.get(start));
        //根据二叉搜索树的性质，找到分界点，根据左右子树的大小
        int k = start + 1;
        while (k <= end && nums.get(k) < nums.get(start)) k++;
        //分别构造当前结点的左右子树
        node.left = decode(start + 1, k - 1, nums);
        node.right = decode(k, end, nums);
        //返回
        return node;
    }
}
