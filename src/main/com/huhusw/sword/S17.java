package com.huhusw.sword;

/**
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * 顺序打印
 */
public class S17 {
    /**
     * 顺序打印从1开始到n为最大的十进制的数
     *
     * @param n 位数
     * @return 一个从1开始的序列
     */
    public int[] printNumbers(int n) {
        //最大值
        int sum = 0;
        //计算最大值
        for (int i = 0; i < n; i++) {
            sum = sum * 10 + 9;
        }
        //返回结果
        int[] res = new int[sum];
        //构造返回结果
        for (int i = 1; i <= sum; i++) {
            res[i - 1] = i;
        }
        //返回
        return res;
    }
}
