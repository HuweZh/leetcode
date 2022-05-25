package com.huhusw.offer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * https://www.nowcoder.com/questionTerminal/0d939e874a004f449a370aca1346dd5c
 * 最优二叉树，每个节点有一个权重，每条边的权重为两点权重之积
 * 小团记录了一个二叉树的中序遍历，但是忘了顺序
 * 要求边的权重之和最小的情况对应的权重
 * <p>
 * 这个题目的难点在于：要考虑每两个节点之间的情况，还要顾及树的情况，甚至是父节点的情况
 * 可以使用树形dp，但是我没有看懂dp的转移函数
 * 这里使用的是备忘录+分治，记忆化搜索，设n个节点的编号为1-n，memo为备忘录
 * memo[i][j][k]是以k为根结点，i~j为子树节点的最小花费
 */
public class MT202104 {
    //中序排序
    static int[] nums;
    //备忘录
    static int[][][] memo;

    public static void main(String[] args) throws Exception {
        //输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        nums = new int[n];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }
        //初始化备忘录为-1
        memo = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        System.out.println(render(0, n - 1, -1));
    }

    /**
     * 重构二叉树，构造出所有情况，找出权重最小的情况
     *
     * @param left  下界
     * @param right 上界
     * @param root  根结点，为-1代表没有确定根结点
     * @return
     */
    static int render(int left, int right, int root) {
        //超出范围
        if (left > right) {
            return 0;
        }
        //已经查过了，直接返回
        if (root >= 0 && memo[left][right][root] != -1) {
            return memo[left][right][root];
        }
        //本次循环的花费
        int cost = Integer.MAX_VALUE;
        //循环上下界中所有的节点，轮流当根结点
        for (int i = left; i <= right; i++) {
            //i为根结点，分别计算左右子树的权重花费
            int leftCost = render(left, i - 1, i);
            int rightCost = render(i + 1, right, i);
            //更新以i为根结点对应的树的权重之和，当根结点为-1时，代表没有确定根结点，没有结点权重
            cost = Math.min(cost, leftCost + rightCost + nums[i] * (root == -1 ? 0 : nums[root]));
        }
        //更新备忘录
        if (root >= 0) {
            memo[left][right][root] = cost;
        }
        //返回花费
        return cost;
    }
}
