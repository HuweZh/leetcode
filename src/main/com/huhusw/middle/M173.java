package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.ArrayList;

public class M173 {
}

/**
 * 设计二叉搜索树的迭代器
 */
class BSTIterator {
    //记录当前的遍历索引
    private int index = 0;
    //树中的元素个数
    private int length = 0;
    //存储树中的元素
    private ArrayList<Integer> tree = new ArrayList<>();

    /**
     * 构造函数
     * @param root 树的根结点
     */
    public BSTIterator(TreeNode root) {
        //中序遍历保存树
        inOrder(root);
        //初始化索引和长度
        index = 0;
        length = tree.size();
    }

    /**
     * 获取下一个元素，是按照中序遍历的顺序获取
     * @return 返回下一个元素的值
     */
    public int next() {
        //直接读取数组
        return tree.get(index++);
    }

    /**
     * 判断是否还有下一个元素
     * @return
     */
    public boolean hasNext() {
        //直接返回
        return index < length;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        tree.add(node.val);
        inOrder(node.right);
    }
}
