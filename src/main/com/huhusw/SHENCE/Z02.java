package com.huhusw.SHENCE;

import java.util.*;

public class Z02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> city2id = new HashMap<>();
        Map<Integer, Integer> id2city = new HashMap<>();
        int count = 0;
        int[][] edge = new int[n][2];
        for (int i = 0; i < n; i++) {
            edge[i][0] = sc.nextInt() - 1;
            edge[i][1] = sc.nextInt() - 1;
            if (!city2id.containsKey(edge[i][0])) {
                city2id.put(edge[i][0], count);
                id2city.put(count, edge[i][0]);
                count++;
            }
            if (!city2id.containsKey(edge[i][1])) {
                city2id.put(edge[i][1], count);
                id2city.put(count, edge[i][1]);
                count++;
            }
        }
        //图里存的都是城市的编号
        ArrayList<Integer>[] graph = new ArrayList[count];
        for (int i = 0; i < count; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int from = edge[i][0];
            int to = edge[i][1];
            graph[city2id.get(from)].add(city2id.get(to));
        }
        //开始也是从编号开始
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        if (!city2id.containsKey(a) || !city2id.containsKey(b)) {
            System.out.println(1);
            return;
        }
        int startA = city2id.get(a);
        int startB = city2id.get(b);
        sc.close();

        //队列和集合都是存储的编号
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startA);
        Set<Integer> set = new HashSet<>();
        set.add(startA);
        set.add(startB);
        boolean isEnd = false;
        int res = 0;
        while (!queue.isEmpty()) {
            //广度遍历
            int index = queue.poll();
            //当前的路径选择
            for (int j = 0; j < graph[index].size(); j++) {
                //将编号记录
                set.add(graph[index].get(j));
                queue.offer(graph[index].get(j));
            }
        }
        queue.offer(startB);
        while (!isEnd && !queue.isEmpty()) {
            int index = queue.poll();
            //当前的路径选择
            for (int j = 0; j < graph[index].size(); j++) {
                //编号相遇
                //找到了走过的路，代表可以相遇
                if (set.contains(graph[index].get(j))) {
                    isEnd = true;
                    res = id2city.get(graph[index].get(j));
                    break;
                }
                //将编号记录
                set.add(graph[index].get(j));
                queue.offer(graph[index].get(j));
            }
        }
        System.out.println(res + 1);
    }
}
/*
50
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> city2id = new HashMap<>();
        Map<Integer, Integer> id2city = new HashMap<>();
        int count = 0;
        int[][] edge = new int[n][2];
        for (int i = 0; i < n; i++) {
            edge[i][0] = sc.nextInt() - 1;
            edge[i][1] = sc.nextInt() - 1;
            if (!city2id.containsKey(edge[i][0])) {
                city2id.put(edge[i][0], count);
                id2city.put(count, edge[i][0]);
                count++;
            }
            if (!city2id.containsKey(edge[i][1])) {
                city2id.put(edge[i][1], count);
                id2city.put(count, edge[i][1]);
                count++;
            }
        }
        //图里存的都是城市的编号
        ArrayList<Integer>[] graph = new ArrayList[count];
        for (int i = 0; i < count; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int from = edge[i][0];
            int to = edge[i][1];
            graph[city2id.get(from)].add(city2id.get(to));
        }
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        if (!city2id.containsKey(a) || !city2id.containsKey(b)) {
            System.out.println(1);
            return;
        }
        int startA = city2id.get(a);
        int startB = city2id.get(b);
        sc.close();

        //队列和集合都是存储的编号
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startA);
        queue.offer(startB);
        Set<Integer> set = new HashSet<>();
        set.add(startA);
        set.add(startB);
        boolean isEnd = false;
        int res = 0;
        while (!isEnd && !queue.isEmpty()) {
            int size = queue.size();
            //广度遍历
            for (int i = 0; i < size && !isEnd; i++) {
                int index = queue.poll();
                //当前的路径选择
                for (int j = 0; j < graph[index].size(); j++) {
                    //编号相遇
                    //找到了走过的路，代表可以相遇
                    if (set.contains(graph[index].get(j))) {
                        isEnd = true;
                        res = id2city.get(graph[index].get(j));
                        break;
                    }
                    //到罗马了，在这等
                    if (graph[index].get(j) == city2id.get(0)) {
                        isEnd = true;
                        res = 0;
                        break;
                    }
                    //将编号记录
                    set.add(graph[index].get(j));
                    queue.offer(graph[index].get(j));
                }
            }
        }
        System.out.println(res + 1);
    }
 */