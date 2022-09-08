package com.huhusw.QN;

import java.util.*;

public class Z02 {
    public static void main(String[] args) {
        Z02 z02 = new Z02();
        System.out.println(z02.Decrypt(4296,1601,4757));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 解密
     *
     * @param encryptedNumber int整型 待解密数字
     * @param decryption      int整型 私钥参数D
     * @param number          int整型 私钥参数N
     * @return int整型
     */
    public int Decrypt(int encryptedNumber, int decryption, int number) {
        // write code here
        int res = 1;
        int num = encryptedNumber % number;
        for (int i = 0; i < decryption; i++) {
            res = ((res % number) * num) % number;
        }
        return res;
    }
}
