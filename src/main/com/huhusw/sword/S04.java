package com.huhusw.sword;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 二维数组中的查找
 */
public class S04 {
    /**
     * 给定一个每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序的数组
     * 设计一个算法，快速查询给定值是否在数组中
     * 对于左下角的元素来说：按行来说最大，按列来说最小，这样来看就是一个已经排好序的序列
     * 根据target的取值，我们就可以在这个有序的序列中操作，每次淘汰一行或者一列
     *
     * @param matrix 数组
     * @param target 值
     * @return 是否在数组中
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //边界情况
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        //行数
        int n = matrix.length;
        //列数
        int m = matrix[0].length;
        //定位到左下角
        int col = 0;
        //遍历数组
        while (n > 0 && col < m) {
            //找到元素，返回true
            if (matrix[n - 1][col] == target) {
                return true;
            } else if (matrix[n - 1][col] < target) {
                //淘汰一列
                col++;
            } else {
                //淘汰一行
                n--;
            }
        }
        //最终返回false
        return false;
    }
}
