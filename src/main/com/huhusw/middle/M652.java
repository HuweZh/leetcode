package com.huhusw.middle;

import com.huhusw.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class M652 {
    //结果数组
    List<TreeNode> res = new LinkedList<>();
    //记录之前节点的样子，键是树的样子，值是键存在的次数
    Map<String, Integer> cache = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        //1.根节点需要做什么？根节点需要知道自己的样子和别的根节点的样子，才能比较是否有重复
        //2.怎么知道自己的样子？可以使用序列化技术，将以自己为根节点的树转化为字符串，其他节点也经过相同的处理，就能比较了
        traverse(root);
        return res;
    }

    /**
     * 辅助函数，构造子树的表示，并更新中间变量和结果
     *
     * @param root 子树的根节点
     * @return 每颗子树的表示
     */
    private String traverse(TreeNode root) {
        //对于空节点使用一个特殊的符号来代替
        if (root == null) {
            return "#";
        }
        //依次得到左右子树的表示，即得到的树的样子为一个后序遍历
        String left = traverse(root.left);
        String right = traverse(root.right);

        //后续遍历，对应的是这棵树的样子
        String subTree = left + "," + right + "," + root.val;

        //查看这棵树是否被记录过，记录过且只记录一次的需要放到结果中
        int num = cache.getOrDefault(subTree, 0);
        if (num == 1) {
            res.add(root);
        }
        //将计数加1
        cache.put(subTree, num + 1);
        return subTree;
    }
}
