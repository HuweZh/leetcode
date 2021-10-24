package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M655 {
    public List<List<String>> printTree(TreeNode root) {
        //获取树的高度
        int height = getHeight(root);
        //构造字符串数组，用以保存结果
        String[][] stem = new String[height][(1 << height) - 1];
        //为数组进行赋值
        // for(int i = 0; i < height; i++){
        //     for(int j = 0; j < (1<<height)-1; j++){
        //         stem[i][j] = "";
        //     }
        // }
        for (String[] strings : stem) {
            Arrays.fill(strings, "");
        }
        //根据树的结构填充结果数组
        fill(stem, root, 0, 0, (1 << height) - 1);
        //结果
        List<List<String>> res = new ArrayList<>();
        // for(int i = 0; i < height; i++){
        //     List<String>list = new ArrayList<>();
        //     for(int j = 0; j < (1<<height)-1; j++){
        //         list.add(stem[i][j]);
        //     }
        //     res.add(list);
        // }
        //填充结果
        for (String[] strings : stem) {
            res.add(Arrays.asList(strings));
        }
        //返回
        return res;
    }

    /**
     * 获取以root为根节点树的高度
     *
     * @param root 根节点
     * @return 树的高度
     */
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    /**
     * 根据树的结构填充字符串数组
     *
     * @param stem  被填充的字符串数组
     * @param node  当前节点
     * @param depth 当前节点的深度
     * @param l     当前节点对应数组的左边界
     * @param r     当前节点对应数组的右边界
     */
    public void fill(String[][] stem, TreeNode node, int depth, int l, int r) {
        //空节点，直接返回
        if (node == null) {
            return;
        }
        //往边界的中间插入字符串
        int mid = (l + r) / 2;
        stem[depth][mid] += node.val;
        //递归填充左右子树
        fill(stem, node.left, depth + 1, l, mid);
        fill(stem, node.right, depth + 1, mid + 1, r);
    }
}
