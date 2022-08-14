package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/M99OJA/
 * 分割回文子字符串
 */
public class S086 {
    //字符串长度
    int n;
    //flag[i][j]表示s[i...j]是否是一个回文字符串
    boolean[][] flag;
    //中途的路径
    List<String> stem = new ArrayList<>();
    //结果
    List<List<String>> ans = new ArrayList<>();

    public String[][] partition(String s) {
        n = s.length();
        flag = new boolean[n][n];
        //初始为全部都是回文串，空串 i>j  单个字符 i=j 都是回文
        //动规计算是否为回文串时用得上空串的情况
        for (int i = 0; i < n; i++) {
            Arrays.fill(flag[i], true);
        }
        //动规计算是否能构成回文串
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                //计算是否为回文字符串
                flag[i][j] = flag[i + 1][j - 1] & (s.charAt(i) == s.charAt(j));
            }
        }
        backTrack(s, 0);
        String[][] res = new String[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = new String[ans.get(i).size()];
            for (int j = 0; j < ans.get(i).size(); j++) {
                res[i][j] = ans.get(i).get(j);
            }
        }
        return res;
    }

    /**
     * 递归回溯
     *
     * @param s
     * @param index
     */
    private void backTrack(String s, int index) {
        //跳出循环的条件
        if (index == n) {
            ans.add(new ArrayList<>(stem));
            return;
        }
        //同层多叉树选择
        for (int i = index; i < n; i++) {
            //是回文串
            if (flag[index][i]) {
                //做选择
                stem.add(s.substring(index, i + 1));
                //往下递归
                backTrack(s, i + 1);
                //撤销选择
                stem.remove(stem.size() - 1);
            }
        }
    }
}
