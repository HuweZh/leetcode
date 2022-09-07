package com.huhusw.simple;

import java.util.*;

/**
 * https://leetcode.cn/problems/rearrange-spaces-between-words/
 * 重排空格
 * 将所有的空格进行重新排列，单词空隙中的单词数量一样，且最多，多余的放末尾
 */
public class S1592 {
    public String reorderSpaces(String text) {
        String[] ss = text.split(" ");
        int spaceCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < ss.length; i++) {
            if (!"".equals(ss[i])) {
                queue.offer(ss[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (queue.size() == 1) {
            sb.append(queue.poll());
            while (spaceCount > 0) {
                spaceCount--;
                sb.append(" ");
            }
            return sb.toString();
        } else {
            int count = spaceCount / (queue.size() - 1);
            int last = spaceCount % (queue.size() - 1);
            while (!queue.isEmpty()) {
                sb.append(queue.poll());
                if (!queue.isEmpty()) {
                    for (int i = 0; i < count; i++) {
                        sb.append(" ");
                    }
                }
            }
            for (int i = 0; i < last; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
    }
}
