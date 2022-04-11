package com.huhusw.sword;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 替换空格
 */
public class S05 {
    /**
     * 空格字符替换成%20
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
