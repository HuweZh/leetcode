package com.huhusw.simple;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 * 反转字符串
 */
public class S344 {
    /**
     * 给一个字符数组
     * 再不使用额外空间的情况下，反转里面的字符
     * 双指针
     *
     * @param s
     */
    public void reverseString(char[] s) {
        //双指针
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            //更新位置
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }
    }
}
