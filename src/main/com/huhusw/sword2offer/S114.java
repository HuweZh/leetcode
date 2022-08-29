package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/Jf1JuT/
 * 外星文字典
 */
public class S114 {
    public static void main(String[] args) {
        S114 s114 = new S114();
//        s114.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
        s114.alienOrder(new String[]{"abc", "ab"});
    }

    /**
     * 拓扑排序
     * 拓扑遍历的字符就是字典序
     * 在建图的过程中，只需要关心相邻的两个单词即可
     * 遇见两个单词第一个不同的字符，则一定有一个先后顺序
     *
     * @param words
     * @return
     */
    public String alienOrder(String[] words) {
        //建图
        Map<Character, List<Character>> memo = new HashMap<>();
        //单词到索引
        Map<Character, Integer> c2Index = new HashMap<>();
        int count = 0;
        //遍历一遍单词，将不同的字符记录
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                if (!memo.containsKey(s.charAt(i))) {
                    memo.put(s.charAt(i), new ArrayList<Character>());
                    c2Index.put(s.charAt(i), count);
                    count++;
                }
            }
        }
        //入度数组
        int[] inDegree = new int[count];
        for (int i = 0; i < words.length; i++) {
            //取相邻的两个单词
            if (i != words.length - 1) {
                int length = Math.min(words[i].length(), words[i + 1].length());
                for (int k = 0; k < length; k++) {
                    //遇见第一个不相同的字符，记录其入度和边
                    if (words[i].charAt(k) != words[i + 1].charAt(k)) {
                        List<Character> stem = memo.get(words[i].charAt(k));
                        stem.add(words[i + 1].charAt(k));
                        inDegree[c2Index.get(words[i + 1].charAt(k))]++;
                        memo.put(words[i].charAt(k), stem);
                        break;
                    }
                    //两个单词前面都一样，但是排序在前的单词更长，不符合题意，直接返回
                    if (k == length - 1 && words[i].length() > words[i + 1].length()) {
                        return "";
                    }
                }
            }
        }
        //广度优先遍历
        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, List<Character>> entry : memo.entrySet()) {
            //初始化将入度为0的加入队列
            if (inDegree[c2Index.get(entry.getKey())] == 0) {
                queue.add(entry.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        //开始遍历
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char cc : memo.get(c)) {
                inDegree[c2Index.get(cc)]--;
                if (inDegree[c2Index.get(cc)] == 0) {
                    queue.offer(cc);
                }
            }
        }
        return sb.length() == count ? sb.toString() : "";
    }
}
