package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/0on3uN/
 * 复原ip
 * 复原字符串对应的全部ip
 */
public class S087 {
    static final int IP_COUNT = 4;
    static final int IP_MAX = 255;
    List<String> res = new ArrayList<>();
    //存储这一段的全部ip
    String[] seg = new String[IP_COUNT];

    public List<String> restoreIpAddresses(String s) {
        //提前返回
        if (s.length() > 12 || s.length() < 3) {
            return res;
        }
        //递归回溯
        backTrack(s, 0, 0);
        return res;
    }

    private void backTrack(String s, int start, int count) {
        //找到了四段，可以提前返回
        if (count == IP_COUNT) {
            //到了尾部表示是一个完整的ip
            if (start == s.length()) {
                //构造结果
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < IP_COUNT; i++) {
                    sb.append(seg[i]);
                    if (i != IP_COUNT - 1) {
                        sb.append(".");
                    }
                }
                res.add(sb.toString());
            }
            return;
        }
        //提前返回
        if (start == s.length()) {
            return;
        }
        //前导0，这一段ip只能是0
        if (s.charAt(start) == '0') {
            seg[count] = "0";
            backTrack(s, start + 1, count + 1);
            return;
        }
        //一般的情况
        int addr = 0;
        for (int i = start; i < s.length(); i++) {
            //计算当前IP段
            addr = addr * 10 + s.charAt(i) - '0';
            if (addr <= IP_MAX) {
                //满足题意，继续向下递归
                seg[count] = s.substring(start, i + 1);
                backTrack(s, i + 1, count + 1);
            } else {
                break;
            }
        }
    }
}
