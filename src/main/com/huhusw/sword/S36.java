package com.huhusw.sword;

import com.huhusw.Node;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * 将二叉搜索树转化为有序的双向循环链表
 */
public class S36 {
    //上一个节点
    Node pre = null;
    //双向链表的头结点
    Node head = null;

    /**
     * 将二叉搜索树转化为有序的双向循环链表
     * 不允许创建中间节点，只允许修改指针指向
     * 二叉搜索树的中序遍历就是有序的，从中序遍历切入
     * 修改每个节点的左右指针，左指针指向pre，pre的有指针指向节点
     *
     * @param root 根结点
     * @return 循环链表的头结点
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        //中序遍历
        inorder(root);
        //pre为尾结点，跟头结点互相指向，构成循环链表
        head.left = pre;
        pre.right = head;
        //返回头结点
        return head;
    }

    /**
     * 二叉树的中序遍历
     * 左根右
     *
     * @param node
     */
    public void inorder(Node node) {
        //遇到空，返回
        if (node == null) {
            return;
        }
        //递归左节点
        inorder(node.left);
        //中序遍历位置
        //pre为空证明是第一个节点，初始化头结点和pre
        if (pre == null) {
            pre = node;
            head = node;
        } else {
            //修改指针，node为当前节点，需要指向上一个节点
            //上一个节点需要指向当前节点
            //更新上一个节点为当前节点
            node.left = pre;
            pre.right = node;
            pre = node;
        }
        //递归右节点
        inorder(node.right);
    }
}
