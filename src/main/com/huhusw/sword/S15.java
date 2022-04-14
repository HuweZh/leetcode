package com.huhusw.sword;

/**
 * @author huhusw
 * @Description
 * @create 2021-06-23 23:03
 */
public class S15 {
    // you need to treat n as an unsigned value
    public int hammingWeight2(int n) {
        int count = 0;
        int index = 0;
        while (index != 32) {
            count += n & 0x1;
            n = n >> 1;
            index++;
        }
        return count;
    }

    /**
     * 计算1的个数
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        //结果
        int count = 0;
        while (n != 0) {
            //每次与1
            count += n & 1;
            //逻辑右移
            n = n >>> 1;
        }
        //返回结果
        return count;
    }
}
