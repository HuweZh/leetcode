package com.huhusw.middle;

import com.huhusw.ListNode;
import com.huhusw.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M109 {
    /**
     * 根据升序单向链表构建一棵平衡二叉搜索树
     *
     * @param head 单向链表的头结点
     * @return 二叉树的头结点
     */
    //因为链表不能随机访问，所以先遍历一遍链表，将值存储于数组中，然后利用分治的思想构造二叉树
    public TreeNode sortedListToBST(ListNode head) {
        //保存链表中的值
        List<Integer> nums = new ArrayList<>();
        //遍历链表，保存值
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        //链表的长度
        int length = nums.size();
        //构建二叉树
        TreeNode root = buildTree(0, length - 1, nums);
        return root;
    }

    /**
     * 构建二叉树
     *
     * @param start 当前区间链表中的起始索引
     * @param end   当前区间链表中的末尾索引
     * @param nums  链表对应的数组
     * @return 返回构建的二叉树
     */
    public TreeNode buildTree(int start, int end, List<Integer> nums) {
        if (start > end) {
            return null;
        }
        //将当前区间的中点作为根结点，划分左右子树，可以保证左右子树的节点个数最多相差1，满足平衡条件
        int mid = (end + start) / 2;
        //当前区间的根结点
        TreeNode node = new TreeNode(nums.get(mid));
        //分别构造左右子树
        node.left = buildTree(start, mid - 1, nums);
        node.right = buildTree(mid + 1, end, nums);
        //返回值
        return node;
    }
}
