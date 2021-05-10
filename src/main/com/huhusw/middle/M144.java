package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class M144 {

    // 二叉树前序遍历
    public static void main(String[] args) {

    }
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return result;
        }
        result.add(root.val);
        if(root.left != null) {
            preorderTraversal(root.left);
        }
        if(root.right != null){
            preorderTraversal(root.right);
        }
        return result;
    }
}
