package com.huhusw.sword;

/**
 * @author huhusw
 * @Description
 * @create 2021-06-23 23:03
 */
public class S15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int index = 0;
        while (index != 32) {
            count += n & 0x1;
            n = n >> 1;
            index++;
        }
        return count;
    }
}
