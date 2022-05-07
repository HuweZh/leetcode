package com.huhusw.sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * 字符串的排列
 */
public class S38 {
    //保存字符串
    List<String> res;
    //回溯时防止重复访问
    boolean[] visited;

    /**
     * 找到字符串的所有排列
     * 回溯
     *
     * @param s 字符串大家都在发
     * @return 全排列
     */
    public String[] permutation(String s) {
        //转为字符数组，对字符数组进行全排列
        char[] chars = s.toCharArray();
        //初始化两个数据结构
        res = new ArrayList<>();
        visited = new boolean[chars.length];
        //排序字符数组，因为可能会出现重复的字符
        Arrays.sort(chars);
        //回溯
        dfs(chars, new StringBuilder(), 0);
        //构造结果
        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    /**
     * 回溯
     * @param chars 字符数组
     * @param sb 字符串
     * @param index 当前字符串的索引位置
     */
    public void dfs(char[] chars, StringBuilder sb, int index) {
        //遍历完成，添加结果
        if (index == chars.length) {
            res.add(sb.toString());
        }
        //对字符数组进行遍历
        for (int i = 0; i < chars.length; i++) {
            //访问过这个字符，或者多个字符相等，前一个不访问，后一个也不能访问
            if (visited[i] || (i > 0 && !visited[i - 1] && chars[i] == chars[i - 1])) {
                continue;
            }
            //设置状态
            sb.append(chars[i]);
            visited[i] = true;
            //递归
            dfs(chars, sb, index + 1);
            //取消状态，回溯
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
