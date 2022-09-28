package com.huhusw.XHS;

import java.util.*;

public class Z07 {
    static ArrayList<int[]>[] graph;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        //端点，端点，长度
        int[][] tree = new int[n - 1][3];
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            tree[i][0] = x;
            tree[i][1] = i + 2;
        }
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            tree[i][2] = x;
        }
        int[] target = new int[3];
        for (int i = 0; i < 3; i++) {
            target[i] = sc.nextInt();
        }
        sc.close();
        //建树
        for (int[] stem : tree) {
            graph[stem[0]].add(new int[]{stem[1], stem[2]});
            graph[stem[1]].add(new int[]{stem[0], stem[2]});
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            queue.offer(new int[]{target[i], 0});
            int sum = 0;
            int count = 0;
            boolean[] visited = new boolean[n + 1];
            visited[target[i]] = true;
            while (!queue.isEmpty()) {
                int size = queue.size();
                Queue<int[]> stem = new LinkedList<>();
                for (int j = 0; j < size; j++) {
                    int[] poll = queue.poll();
                    if (poll[0] == target[0] || poll[0] == target[1] || poll[0] == target[2]) {
                        count++;
                        sum += poll[1];
                    }
                    if (count == 3) {
                        res = Math.min(res, sum);
                        break;
                    }
                    if (sum > res) {
                        break;
                    }
                    for (int[] s : graph[poll[0]]) {
                        if (visited[s[0]]) {
                            continue;
                        }
                        visited[s[0]] = true;
                        stem.offer(new int[]{s[0], s[1] + poll[1]});
                    }
                }
                while (!stem.isEmpty()) {
                    queue.offer(stem.poll());
                }
            }
        }
        System.out.println(res);
    }
}
