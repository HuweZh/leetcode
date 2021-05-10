package com.huhusw;

import com.huhusw.simple.S897;

/**
 * @author huhusw
 * @Description
 * @create 2021-05-10 13:40
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
