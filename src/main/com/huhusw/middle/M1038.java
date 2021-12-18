package com.huhusw.middle;

import com.huhusw.TreeNode;

/**
 * 将二叉搜索树转化为累加树
 * 即当前节点的值是所有大于此节点的值
 */
// 方法是根据二叉树的性质，反序中序遍历，即右根左，修改当前节点的值
public class M1038 {
    //累加变量
    int sum = 0;

    /**
     * 转换函数
     *
     * @param root 原根节点
     * @return 转换后的根节点
     */
    public TreeNode bstToGst(TreeNode root) {
        //反序中序遍历处理树
        inOrder(root);
        return root;
    }

    /**
     * 反序中序遍历，右根左
     *
     * @param node 当前节点
     */
    public void inOrder(TreeNode node) {
        //空节点直接返回
        if (node == null) {
            return;
        }
        //先右后左
        inOrder(node.right);
        node.val += sum;
        sum = node.val;
        inOrder(node.left);
    }
}
