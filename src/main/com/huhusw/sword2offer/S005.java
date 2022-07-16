package com.huhusw.sword2offer;

/**
 * https://leetcode.cn/problems/aseY1I/
 * 计算数组中不含有相同字符的字符串长度的最大乘积
 * 使用位运算来表示字符串
 */
public class S005 {
    public int maxProduct(String[] words) {
        //每个字符串的长度
        int[] length = new int[words.length];
        //每个字符串的hash表示
        int[] hash = new int[words.length];
        //结果
        int max = 0;
        //遍历所有的字符串
        for (int i = 0; i < words.length; i++) {
            length[i] = words[i].length();
            //计算hash，一共26个字母，使用int足够
            for (int j = 0; j < words[i].length(); j++) {
                hash[i] = hash[i] | (1 << (words[i].charAt(j) - 'a'));
            }
            //计算乘积
            for (int j = 0; j < i; j++) {
                //只有hash中不含有相同字母时，为0
                if ((hash[i] & hash[j]) == 0)
                    max = Math.max(max, length[i] * length[j]);
            }
        }
        return max;
    }
}
