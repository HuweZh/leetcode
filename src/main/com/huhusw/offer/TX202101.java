package com.huhusw.offer;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/test/question/done?tid=56666764&qid=1795704
 * 朋友圈，一共100000个用户，每两个用户之间有连接形成圈子，输出所有圈子内的最大用户数
 * 看到题目就能想起并查集，但是并查集的实现有点生疏，还是得多做题
 * <p>
 * 使用并查集记录联通分量，并查集的parent数组存储每一个圈子的祖父节点
 * 并查集主要实现联通和查找两个API
 */
public class TX202101 {

    /**
     * 并查集实现
     */
    static class UF {
        //集合中全部的联通分量个数
        int count;
        //父节点指针，初始时全部都指向自己
        //也就是说，找到指向自己的节点就是祖先节点
        int[] parent;
        //size数组用来记录每一个联通分量的节点数量
        //在联通两个分量时，将小的挂在大的下面，防止树过高退化成链表
        int[] size;

        /**
         * 构造器
         * 初始时，有n个分量，每个人都指向自己，所有的联通分量节点数为1
         *
         * @param n
         */
        public UF(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        /**
         * 找到x对应的祖父节点
         * 一定能找到父节点，要么是自己，要么是分量中的公共父节点
         * 使用路径压缩，减少树的高度，越查越快
         *
         * @param x
         * @return
         */
        public int find(int x) {
            //根结点的特征是自己指向自己
            while (parent[x] != x) {
                //路径压缩
                parent[x] = parent[parent[x]];
                //继续向下寻找
                x = parent[x];
            }
            //返回查到的父节点
            return x;
        }

        /**
         * 联通两个节点
         *
         * @param x
         * @param y
         */
        public void union(int x, int y) {
            //分别找到两个分量的祖先节点
            int rootX = find(x);
            int rootY = find(y);
            //在一棵树上，已经联通
            if (rootX == rootY) {
                return;
            }
            //将小的树挂在大树下面，并更新树的节点个数
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            T--;
            int n = sc.nextInt();
            //定义并查集
            UF uf = new UF(100000);
            //输入数据，并实时联通
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                uf.union(x - 1, y - 1);
            }
            //记录圈子的节点数量
            int[] count = new int[100000];
            //结果
            int res = 0;
            for (int i = 0; i < 100000; i++) {
                //对于每一个节点，都找其父节点，统计父节点对应的次数，就是节点的数量，更新结果
                int root = uf.find(i);
                count[root]++;
                res = Math.max(res, count[root]);
            }
            System.out.println(res);
        }
    }
}
