package com.huhusw.sword;

import com.huhusw.TreeNode;

import java.util.LinkedList;

/**
 * 二叉树的序列化和反序列化
 */
public class S37 {
    //定义空指针和分隔符
    private final String NULL = "#";
    private final String SEP = ",";

    /**
     * 序列化函数，输入树的根结点，输出序列化的字符串
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //保存字符串
        StringBuilder sb = new StringBuilder();
        //序列化二叉树
        serialize(root, sb);
        return sb.toString();
    }

    /**
     * 前序遍历序列化二叉树
     * @param root
     * @param sb
     */
    private void serialize(TreeNode root, StringBuilder sb) {
        //空节点，插入空指针，插入分隔符
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        //前序遍历位置
        //前序遍历插入根结点和分隔符
        sb.append(root.val).append(SEP);
        //递归左右子树
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    /**
     * 反序列化二叉树，输入字符串data，输出二叉树的根结点
     * @param data
     * @return
     */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //存储字符数组
        LinkedList<String> list = new LinkedList<>();
        for (String str : data.split(SEP)) {
            list.addLast(str);
        }
        //反序列化二叉树
        return deserialize(list);
    }

    /**
     * 前序遍历反序列化二叉树
     * @param list
     * @return
     */
    private TreeNode deserialize(LinkedList<String> list) {
        //list保存的是前序遍历的结果，从头开始拿元素
        String first = list.removeFirst();
        //空节点，返回空
        if (first.equals(NULL)) {
            return null;
        }
        //前序遍历位置
        //构建根结点
        TreeNode node = new TreeNode(Integer.parseInt(first));
        //递归构造左右节点
        node.left = deserialize(list);
        node.right = deserialize(list);
        //返回节点
        return node;
    }
}
