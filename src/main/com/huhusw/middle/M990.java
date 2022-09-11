package com.huhusw.middle;

import java.util.ArrayList;

/**
 * 可能的等式，在给定的关系中，判断是否全部的关系都能成立
 */
public class M990 {
    /**
     * 判断所给的等式关系是否能完全成立，26个英文字母，== != 两种关系
     *
     * @param equations 给定的等式关系
     * @return 是否可能所有关系都存在
     */
    public boolean equationsPossible(String[] equations) {
        //并查集类，节点为26个英文字母
        UF uf = new UF(26);
        //遍历所有的关系
        for (String s : equations) {
            //==的关系，放在同一棵树上
            if (s.charAt(1) == '=') {
                uf.union(s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }
        //遍历所有的关系
        for (String s : equations) {
            //!=关系如果在一棵树上就产生了矛盾
            if (s.charAt(1) == '!') {
                if (uf.connected(s.charAt(0) - 'a', s.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 并查集类，包括常用的API
     * 利用数组实现
     */
    class UF {
        //当前图中互不联通的树的个数
        private int n;
        //每棵树的节点数量，size[i]表示以第i个节点为根结点的树的节点个数，粗略表示树的复杂程度
        private int[] size;
        //每个节点的父节点，保证一定存在，初始化为自己，parent[i]表示第i个节点的父节点
        private int[] parent;

        /**
         * 构造函数
         *
         * @param n 节点个数
         */
        UF(int n) {
            //初始化变量
            this.n = n;
            size = new int[n];
            parent = new int[n];
            //初始化权重和父节点
            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        /**
         * 联合两个节点
         *
         * @param i 两个节点
         * @param j 两个节点
         */
        public void union(int i, int j) {
            //找到节点的根结点
            int rootI = find(i);
            int rootJ = find(j);
            //根结点相同，不需要合并，直接返回
            if (rootI == rootJ) {
                return;
            }
            //简单的树加到复杂的树上面
            //防止出现头重脚轻的情况，尽量的平衡树的高度
            if (size[rootI] > size[rootJ]) {
                parent[rootJ] = rootI;
                //更新节点数量
                size[rootI] += size[rootJ];
            } else {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            }
        }

        /**
         * 判断两个节点是否相连
         *
         * @param i 两个节点
         * @param j 两个节点
         * @return
         */
        public boolean connected(int i, int j) {
            //分别找到两个节点的父节点
            int rootI = find(i);
            int rootJ = find(j);
            //父节点相同，处于同一棵树
            if (rootI == rootJ) {
                return true;
            }
            return false;
        }

        /**
         * 根据节点找到其父节点
         * 因为所有节点的初始父节点都是自己，所以一定存在父节点
         *
         * @param i 节点
         * @return 父节点
         */
        public int find(int i) {
            //循环找父节点
            while (parent[i] != i) {
                //路径压缩，防止出现极端的链表情况，也可以保证树的高度在一个常数范围内，保证访问效率
                parent[i] = parent[parent[i]];
                //向下遍历
                i = parent[i];
            }
            return i;
        }
    }


    class UF2 {
        int[] parent;

        UF2() {
            parent = new int[26];
            for (int i = 0; i < 26; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
        }
    }

    public boolean equationsPossible2(String[] equations) {
        UF2 uf = new UF2();
        ArrayList<String> notEqual = new ArrayList<>();
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                notEqual.add(equation);
            } else {
                uf.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }
        for (String s : notEqual) {
            int x = uf.find(s.charAt(0) - 'a');
            int y = uf.find(s.charAt(3) - 'a');
            if (x == y) {
                return false;
            }
        }
        return true;
    }
}
