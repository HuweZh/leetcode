package com.huhusw.sword2offer;

import java.util.*;

/**
 * https://leetcode.cn/problems/om3reC/
 * 单词演变
 * 初始单词只能想着单词列表中演变，一次变一个字母，问几次能变化才能编程终止单词
 * 变不成输出0
 */
public class S108 {
    //单词对应的id
    Map<String, Integer> wordId = new HashMap<>();
    //每个单词的邻居
    List<List<Integer>> edge = new ArrayList<>();
    //图中单词的数量
    int nodeNum = 0;

    /**
     * 我们将单词列表变成一个图，每次变换一个单词，为了方便表示hot->*ot h*t ho* 这三种变化
     * 所以在构建图的时候，每一个单词都会连接到这种带有通配符的单词，这些单词并不存在使我们虚构的，目的是方便图的构建
     * 最后在图中搜索起始单词和终止单词即可，利用广度优先
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //将所有单词加入到边中
        for (String s : wordList) {
            addEdge(s);
        }
        //初始单词加入
        addEdge(beginWord);
        //单词列表没有终止单词直接返回
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        //记录变成当前单词所需步骤
        int[] dist = new int[nodeNum];
        //初始化
        Arrays.fill(dist, Integer.MAX_VALUE);
        //初始单词的步骤数为0
        dist[wordId.get(beginWord)] = 0;
        //广度优先遍历
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(wordId.get(beginWord));
        while (!queue.isEmpty()) {
            int it = queue.poll();
            //找到终止单词
            if (it == wordId.get(endWord)) {
                //去除虚拟节点，加上初始节点
                return dist[it] / 2 + 1;
            }
            //否则，继续遍历邻居
            for (int nei : edge.get(it)) {
                //只找未访问过的邻居
                if (dist[nei] == Integer.MAX_VALUE) {
                    dist[nei] = dist[it] + 1;
                    queue.offer(nei);
                }
            }
        }
        return 0;
    }

    /**
     * 加入边，s和s对应的虚拟节点都加入
     *
     * @param s
     */
    private void addEdge(String s) {
        //先将s加入到节点集
        addWord(s);
        int id1 = wordId.get(s);
        char[] chars = s.toCharArray();
        //遍历s，构造虚拟节点
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            chars[i] = '*';
            String dummyWord = new String(chars);
            //加入虚拟节点
            addWord(dummyWord);
            int id2 = wordId.get(dummyWord);
            //添加无向边
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            chars[i] = temp;
        }
    }

    /**
     * 保证节点的编号与边集合中的序号对应
     *
     * @param s
     */
    private void addWord(String s) {
        if (!wordId.containsKey(s)) {
            wordId.put(s, nodeNum);
            nodeNum++;
            edge.add(new ArrayList<>());
        }
    }
}
