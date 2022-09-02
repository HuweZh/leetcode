package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/minimum-length-of-string-after-deleting-similar-ends/
 * 删除字符串两端相同字符后的最短长度
 * 使用双指针，分别指示前后两个位置，每次移除相同的元素
 */
public class M1750 {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            //判断是否能开始本次循环
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            //本次循环开启
            while (left + 1 < right && s.charAt(left + 1) == s.charAt(left)) {
                left++;
            }
            while (right - 1 > left && s.charAt(right - 1) == s.charAt(right)) {
                right--;
            }
            //下一轮循环的起点
            right--;
            left++;
        }
        return Math.max(right - left + 1, 0);
    }
}
