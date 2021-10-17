package com.huhusw.middle;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class M767 {
    public String reorganizeString(String s) {
        //直接返回
        if (s.length() < 2 || s == null) {
            return s;
        }
        //记录每个字符出现的次数
        int[] words = new int[26];
        //最大堆，字符出现次数最多的放在前面
        Queue<Character> maxHeap = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                return words[c2 - 'a'] - words[c1 - 'a'];
            }
        });
        //记录字符的出现次数
        for (int i = 0; i < s.length(); i++) {
            words[s.charAt(i) - 'a']++;
        }
        int maxCount = 0;
        //放入最大堆
        for (int i = 0; i < 26; i++) {
            if (words[i] != 0) {
                maxHeap.add((char) ('a' + i));
            }
            maxCount = Math.max(maxCount, words[i]);
        }
        //当出现次数最多的字符大于一半时，不会有符合题意的字符串存在
        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }
        // String res = "";
        //结果字符串
        StringBuilder res = new StringBuilder();
        //开始进行构造，一次取出最大堆中的两个字符，
        while (maxHeap.size() > 1) {
            //System.out.println(maxHeap.poll());
            //这两个字符肯定不相同
            char c1 = maxHeap.poll();
            char c2 = maxHeap.poll();
            //使用了字符以后，频次减一
            words[c1 - 'a']--;
            words[c2 - 'a']--;
            //构造
            res.append(c1);
            res.append(c2);
            // res += c1;
            // res += c2;
            //频次不为零，重新入最大堆
            if (words[c1 - 'a'] != 0) {
                maxHeap.add(c1);
            }
            if (words[c2 - 'a'] != 0) {
                maxHeap.add(c2);
            }
        }
        //当字符的个数为奇数时，还要判断一下是否有剩余字符
        if (!maxHeap.isEmpty()) {
            char c1 = maxHeap.poll();
            res.append(c1);
            // res += c1;
        }
        return res.toString();
    }
}
