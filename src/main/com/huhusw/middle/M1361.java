package com.huhusw.middle;

/**
 * 验证二叉树
 * 只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树
 */
public class M1361 {
    /**
     * 验证二叉树，所有的节点都在一棵完整的树中时才返回true
     *
     * @param n          节点数量，节点编号为0...n-1
     * @param leftChild  节点编号对应的左子树
     * @param rightChild 节点编号对应的右子树
     * @return 是否为一棵合法的二叉树
     */
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        //边界条件
        if (n == 1 || n == 0) {
            return true;
        }
        //构建并查集类
        UF uf = new UF(n);
        //遍历所有的节点
        for (int i = 0; i < n; i++) {
            //有左子树，将其与当前节点相连
            if (leftChild[i] != -1) {
                //如果已经相连，证明形成了冲突的边，直接返回
                if (uf.union(i, leftChild[i])) {
                    return false;
                }
            }
            //有右子树，将其与当前节点相连
            if (rightChild[i] != -1) {
                //如果已经相连，证明形成了冲突的边，直接返回
                if (uf.union(i, rightChild[i])) {
                    return false;
                }
            }
        }
        //最后判断是否只剩下一个树
        return uf.getCount() == 1;
    }

    /**
     * 并查集类
     * 为了防止出现不能构成树的情况，添加一个visited数组
     * 二叉树中，一个节点只能做一次子节点，多次做子节点证明形成的树是有问题的
     * 所以使用数组记录该节点是否已经是子节点
     */
    class UF {
        private int n;
        private int[] parent;
        private int[] size;
        //是否已经是子节点
        private boolean[] visited;

        public UF(int n) {
            this.n = n;
            parent = new int[n];
            size = new int[n];
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            //如果两个节点已经相连或者已经做过子节点了，可以直接返回
            if (rootI == rootJ || visited[j]) {
                return true;
            }
            visited[j] = true;
            if (size[rootI] > size[rootJ]) {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
            } else {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            }
            n--;
            return false;
        }

        private int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public int getCount() {
            return n;
        }
    }
}
