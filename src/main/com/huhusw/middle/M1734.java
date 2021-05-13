package com.huhusw.middle;

/**
 * @author huhusw
 * @Description
 * @create 2021-05-11 23:22
 */
public class M1734 {

    //是一道数学题，异或运算
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] prime = new int[n];
        //total是原数组每个元素亦或后的值
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total ^= i;
        }
        //odd是编码后，索引为奇数的元素，亦或得到的值
        //odd是除了原数组中第1个元素外所有元素的亦或值
        int odd = 0;
        for (int i = 1; i < encoded.length; i += 2) {
            odd ^= encoded[i];
        }
        //于是原数组第一个元素为
        prime[0] = total ^ odd;
        for (int i = 0; i < encoded.length; i++) {
            prime[i + 1] = prime[i] ^ encoded[i];
        }
        return prime;
    }
}
