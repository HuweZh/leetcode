package com.huhusw.middle;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class M5 {
    /**
     * 最长回文子串
     * 解法是从中间向两边进行拓展，遇到回文就加上
     * 中间有奇数和偶数的情况之分，所以进行情况讨论的时候多一种
     *
     * @param s 字符串
     * @return 输出字符串的最长回文子串
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        //结果字符串
        String res = "";
        //遍历整个字符串s
        for (int i = 0; i < n; i++) {
            //从当前字符判断回文子串
            String s1 = getSubStr(s, i, i);
            //从当前字符和下一个字符判断回文子串
            String s2 = getSubStr(s, i, i + 1);
            //比较长度，并更新结果
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    /**
     * 获取当前的回文子串
     *
     * @param s     字符串
     * @param left  左边界
     * @param right 右边界
     * @return 返回回文子串
     */
    public String getSubStr(String s, int left, int right) {
        //记录原始位置
        int oldLeft = left;
        // 越界情况判断，并判断是否符合回文的要求
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //不符合回文要求，说明当前位置不能构成回文串
        if (left == oldLeft) {
            return "";
        }
        // 返回符合题意的子串
        return s.substring(left + 1, right);
    }
}
