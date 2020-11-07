package com.huhusw;

import javax.swing.*;
import java.util.*;

/**
 * @Author huhusw
 * @Date 2020/11/5
 */
public class M127 {
    public static void main(String[] args) {

    }

    // 单词与编号的映射
    Map<String, Integer> wordId = new HashMap<>();
    // 图的边
    List<List<Integer>> edge = new ArrayList<>();
    // 单词与编号映射的数量
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        // 终点不在集合中
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord);
        int endId = wordId.get(endWord);
        dis[beginId] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(beginId);
        // 广度优先遍历
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == endId) {
                return dis[endId] / 2 + 1;
            }
            for (int it : edge.get(x)) {
                if (dis[it] == Integer.MAX_VALUE) {
                    dis[it] = dis[x] + 1;
                    queue.offer(it);
                }
            }
        }
        return 0;
    }

    private void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            // 构建虚拟结点
            char tem = array[i];
            array[i] = '*';
            String newWord = new String(array);
            // 添加虚拟结点
            addWord(newWord);
            int id2 = wordId.get(newWord);
            // 添加双向边
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);

            // 还原字符串
            array[i] = tem;
        }
    }

    // 添加词语与id的映射
    private void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            // 为新加的结点建立结点的联系
            edge.add(new ArrayList<Integer>());
        }
    }
}
