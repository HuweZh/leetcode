package com.huhusw;

import java.util.ArrayList;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;
    public ArrayList<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}