package com.huhusw.simple;

/**
 * https://leetcode-cn.com/problems/reverse-bits/
 * 颠倒二进制串
 */
public class S190 {
    // you need treat n as an unsigned value

    /**
     * 输入一个32位整型，输出其颠倒二进制后的整型
     * @param n 输入
     * @return 颠倒二进制
     */
    public int reverseBits(int n) {
        //结果
        int res = 0;
        //控制次数
        int index = 0;
        //移动32次
        while(index<32){
            index++;
            // System.out.println(n+" "+res+" "+(n&1));
            //取出一位 拼接到结果上
            res = (res<<1)|(n&1);
            n>>>=1;
            // res<<=1;
        }
        //返回结果
        return res;
    }
}
