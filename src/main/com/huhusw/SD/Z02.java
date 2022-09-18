package com.huhusw.SD;

import java.util.*;

public class Z02 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param numA string字符串
     * @param numB string字符串
     * @return string字符串
     */
    public String sum(String numA, String numB) {
        // write code here
        StringBuilder sb = new StringBuilder();
        int a = numA.length() - 1;
        int b = numB.length() - 1;
        int carry = 0;
        while (a >= 0 && b >= 0) {
            int sum = numA.charAt(a) - '0' + numB.charAt(b) - '0' + carry;
            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);
            a--;
            b--;
        }

        while (b >= 0) {
            int sum = numB.charAt(b) - '0' + carry;
            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);
            b--;
        }

        while (a >= 0) {
            int sum = numA.charAt(a) - '0' + carry;
            carry = sum / 10;
            sum = sum % 10;
            sb.append(sum);
            a--;
        }
        if(carry !=0 ){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
