package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class M662 {
    public int widthOfBinaryTree(TreeNode root) {
        //广度优先遍历队列
        Queue<NewNode> queue = new LinkedList<>();
        //初始化队列，根节点的深度为0，编号为0
        queue.add(new NewNode(root, 0, 0));
        //当前遍历的节点深度
        int currDep = 0;
        //当前层节点最左边节点的位置
        int left = 0;
        //结果
        int res = 0;
        //广度优先遍历
        while (!queue.isEmpty()) {
            NewNode newNode = queue.poll();
            //过滤掉空值节点
            if (newNode.node != null) {
                //根据满二叉树的性质，在进行编号的时候子节点是父节点的两倍和两倍加1
                //之后只要确定左右端点节点的编号，通过编号值直接相减就可以得到中间的节点个数
                queue.add(new NewNode(newNode.node.left, newNode.depth + 1, 2 * newNode.pos));
                queue.add(new NewNode(newNode.node.right, newNode.depth + 1, 2 * newNode.pos + 1));
                //判断当前节点是否是当前层的第一个节点，也就是左端的节点
                if (currDep != newNode.depth) {
                    //修改当前层，保证只有一个左端点
                    currDep = newNode.depth;
                    //记录左端点的位置
                    left = newNode.pos;
                }
                //当前层的节点每次都更新结果，保证不会错过右节点
                res = Math.max(res, newNode.pos - left + 1);
            }

        }
        return res;
    }

    /**
     * 构造新节点，保存节点和当前节点的深度以及编号位置
     */
    class NewNode {
        int depth;
        int pos;
        TreeNode node;

        public NewNode(TreeNode node, int depth, int pos) {
            this.node = node;
            this.depth = depth;
            this.pos = pos;
        }
    }
}
