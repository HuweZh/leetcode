package com.huhusw.JWHR;

import java.util.*;

public class Z01 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串
     * @return bool布尔型
     */
    public boolean isValid(String str) {
        // write code here
        String[] strs = str.split("-");
        if (strs.length != 3) {
            return false;
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                if (!(strs[i].charAt(j) >= '0' && strs[i].charAt(j) <= '9')) {
                    return false;
                }
            }
        }
        return true;
    }
}
