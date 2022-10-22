package com.huhusw.unity;

import com.huhusw.TreeNode;

import java.util.*;

public class Z03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @param k    int整型
     * @return TreeNode类
     */

    public TreeNode cyclicShiftTree(TreeNode root, int k) {
        // write code here
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0, root));
        int parentNum = 1;
        int nextNum = 0;
        ArrayList<Node> tempList = new ArrayList<>();
        while (queue.size() != 0) {
            Node node = queue.poll();
            tempList.add(node);
            parentNum--;
            if (node.cNode.left != null) {
                queue.offer(new Node(node.cIndex, nextNum++, 0, node.cNode.left));
            }
            if (node.cNode.right != null) {
                queue.offer(new Node(node.cIndex, nextNum++, 1, node.cNode.right));
            }
            if (parentNum == 0) {
                parentNum = nextNum;
                nextNum = 0;
                list.add(tempList);
                tempList = new ArrayList<>();
            }
        }
        int deep = list.size() - 1;
        for (int i = deep; i >= 1; i--) {
            ArrayList<Node> parList = list.get(i - 1);
            int parLevelSum = parList.size();
            for (Node node : parList) {
                node.cNode.left = null;
                node.cNode.right = null;
            }
            int move = k % (2 * parLevelSum);
            tempList = list.get(i);
            for (Node node : tempList) {
                int targetParent = node.flag == 0 ?
                        (node.pIndex + move / 2) % parLevelSum : (node.pIndex + (move+1) / 2) % parLevelSum;
                int targetChildFlag = node.flag == 0 ? move % 2 : (move + 1) % 2;
                Node pNode = parList.get(targetParent);
                if (targetChildFlag == 0) {
                    pNode.cNode.left = node.cNode;
                } else {
                    pNode.cNode.right = node.cNode;
                }
            }
        }
        return root;
    }

    class Node {
        int pIndex;
        int cIndex;
        int flag;//0为左孩子，1为右孩子
        TreeNode cNode;

        public Node(int pIndex, int cIndex, int flag, TreeNode node) {
            this.pIndex = pIndex;
            this.cIndex = cIndex;
            this.flag = flag;
            this.cNode = node;
        }
    }
}
