package com.huhusw.WANMEI;

import java.util.*;

public class Z02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param cards int整型二维数组
     * @return int整型二维数组
     */
    public int[][] mergeCard(int[][] cards) {
        // write code here
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
//            if (a[0] != b[0]) {
//                return a[0] - b[0];
//            } else {
//                return b[1] - a[1];
//            }
        });
        for (int[] card : cards) {
            queue.add(card);
        }
        ArrayList<int[]> arr = new ArrayList<>();
        int[] stem = new int[2];
        stem[0] = Integer.MAX_VALUE;
        stem[1] = Integer.MIN_VALUE;
        boolean first = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (first) {
                stem[0] = poll[0];
                stem[1] = poll[1];
                first = false;
            } else if (poll[0] > stem[1]) {
                arr.add(new int[]{stem[0], stem[1]});
                stem[0] = poll[0];
                stem[1] = poll[1];
            } else {
                stem[0] = Math.min(stem[0], poll[0]);
                stem[1] = Math.max(stem[1], poll[1]);
            }
        }
        arr.add(new int[]{stem[0], stem[1]});
        int[][] res = new int[arr.size()][2];
        for (int i = 0; i < arr.size(); i++) {
            res[i][0] = arr.get(i)[0];
            res[i][1] = arr.get(i)[1];
        }
        return res;
    }
}
