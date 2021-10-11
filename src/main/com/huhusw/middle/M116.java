package com.huhusw.middle;

import com.huhusw.Node;

public class M116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        //递归处理两个节点
        connectTwoNode(root.left, root.right);
        return root;
    }

    private void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        //连接左右节点
        node1.next = node2;
        //继续遍历在同一个父节点下的两个节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);

        //处理不在同一个父节点下的两个节点
        connectTwoNode(node1.right, node2.left);
    }
}
