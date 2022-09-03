package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/convert-to-base-2/
 * 负二进制转换
 * 将一个数转成-2进制的字符串
 * 取除以后的余数，再反转即可
 */
public class M1017 {
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        //结果
        StringBuilder sb = new StringBuilder();
        //循环相除
        while (n != 0) {
            //偶数可以直接除以-2，结果上添加负号即可
            if (n % 2 == 0) {
                //偶数除以-2
                sb.append(0);
                //结果添加-号
                n = -(n >> 1);
            } else {
                //奇数除以-2
                sb.append(1);
                //-5/-2 = ?
                if (n < 0) {
                    //-5/-2 = 3
                    //这里先取反，加一，再除以2
                    n = (-n + 1) >> 1;
                } else {
                    //5/2=2
                    //直接减一，填上负号
                    n = -(n - 1) >> 1;
                }
            }
        }
        //结果反转
        return sb.reverse().toString();
    }
}
