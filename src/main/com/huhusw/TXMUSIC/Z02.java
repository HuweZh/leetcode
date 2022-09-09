package com.huhusw.TXMUSIC;

import com.huhusw.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;
/*
已知一个二叉树的先序遍历序列和中序遍历序列，但其中一些节点的值可能相同。请你返回所有满足条件的二叉树。二叉树在数组中的顺序是任意的。
 */
public class Z02 {
    public static void main(String[] args) {
        Z02 z02 = new Z02();
        ArrayList<Integer> preOrder = new ArrayList<>();
        preOrder.add(1);
        preOrder.add(1);
        preOrder.add(2);
        ArrayList<Integer> inOrder = new ArrayList<>();
        inOrder.add(1);
        inOrder.add(2);
        inOrder.add(1);
        z02.getBinaryTrees(preOrder, inOrder);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param preOrder int整型ArrayList
     * @param inOrder  int整型ArrayList
     * @return TreeNode类ArrayList
     */
    ArrayList<TreeNode> res = new ArrayList<>();

    public ArrayList<TreeNode> getBinaryTrees(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        // write code here

        TreeNode node = new TreeNode(-1);

        node.left = buildTree(preOrder, 0, preOrder.size() - 1, inOrder, 0, inOrder.size() - 1);
        return res;
    }

    private TreeNode buildTree(ArrayList<Integer> preOrder, int preLeft, int preRight, ArrayList<Integer> inOrder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight ) {
            return null;
        }
        ArrayList<Integer> leftCount = new ArrayList<>();
        for (int i = inLeft; i <= inRight; i++) {
            if (inOrder.get(i) == preOrder.get(preLeft)) {
                leftCount.add(i-inLeft);
            }
        }
        TreeNode node = new TreeNode(preOrder.get(preLeft));
        for (int i = 0; i < leftCount.size(); i++) {
            node.left = buildTree(preOrder, preLeft + 1, preLeft + leftCount.get(i), inOrder, inLeft, leftCount.get(i) - 1);
            node.right = buildTree(preOrder, preLeft + leftCount.get(i) + 1, preRight, inOrder, leftCount.get(i) + 1, inRight);
            if (preLeft == 0 && preRight == preOrder.size() - 1) {
                res.add(copy(node));
            }
        }
        return node;
    }

    private TreeNode copy(TreeNode node) {
        TreeNode root = new TreeNode(node.val);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> copy = new LinkedList<>();
        queue.offer(node);
        copy.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = copy.poll();
            if (t1.left != null) {
                t2.left = new TreeNode(t1.left.val);
                queue.offer(t1.left);
                copy.offer(t2.left);
            }
            if (t1.right != null) {
                t2.right = new TreeNode(t1.right.val);
                queue.offer(t1.right);
                copy.offer(t2.right);
            }
        }
        return root;
    }
//    private TreeNode buildTree(ArrayList<Integer> preOrder, int preLeft, int preRight, ArrayList<Integer> inOrder, int inLeft, int inRight) {
//        if (preLeft > preRight || inLeft > inRight) {
//            return null;
//        }
//        TreeNode node = new TreeNode(preOrder.get(preLeft));
//        int leftCount = 0;
//        for (int i = inLeft; i <= inRight; i++) {
//            if (inOrder.get(i) == preOrder.get(preLeft)) {
//                leftCount = i;
//                break;
//            }
//        }
//        node.left = buildTree(preOrder, preLeft + 1, preLeft + leftCount, inOrder, inLeft, leftCount - 1);
//        node.right = buildTree(preOrder, preLeft + leftCount + 1, preRight, inOrder, leftCount + 1, inRight);
//        return node;
//    }
}
