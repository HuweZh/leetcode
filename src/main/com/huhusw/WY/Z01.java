package com.huhusw.WY;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        if (a % b == 0 || b % a == 0) {
            System.out.println(0);
            return;
        }
        List<Num> aList = new ArrayList<>();
        aList.add(new Num(a, 0));
        List<Num> bList = new ArrayList<>();
        bList.add(new Num(b, 0));
        Queue<Integer> aQueue = new LinkedList<>();
        Queue<Integer> bQueue = new LinkedList<>();
        aQueue.offer(a);
        bQueue.offer(b);
        int timesA = 1;
        int timesB = 1;
        while (!aQueue.isEmpty()) {
            int size = aQueue.size();
            for (int i = 0; i < size; i++) {
                int num = aQueue.poll();
                int[] stem = getDiv(num);
                Set<Integer> set = new HashSet<>();
                for (int s : stem) {
                    if (s == 0) {
                        continue;
                    }
                    set.add(s);
                }
                Iterator<Integer> iterator = set.iterator();
                while (iterator.hasNext()) {
                    int s = iterator.next();
                    aList.add(new Num(s, timesA));
                    aQueue.offer(s);
                }
            }
            timesA++;
        }
        while (!bQueue.isEmpty()) {
            int size = bQueue.size();
            for (int i = 0; i < size; i++) {
                int num = bQueue.poll();
                int[] stem = getDiv(num);
                Set<Integer> set = new HashSet<>();
                for (int s : stem) {
                    if (s == 0) {
                        continue;
                    }
                    set.add(s);
                }
                Iterator<Integer> iterator = set.iterator();
                while (iterator.hasNext()) {
                    int s = iterator.next();
                    bList.add(new Num(s, timesA));
                    bQueue.offer(s);
                }
            }
            timesB++;
        }
        int res = Integer.MAX_VALUE;
        for (Num numa : aList) {
            for (Num numb : bList) {
                if (numa.val % numb.val == 0 || numb.val % numa.val == 0) {
                    res = Math.min(res, numa.times + numb.times);
                }
            }
        }
        System.out.println(res);
    }

    private static int[] getDiv(int num) {
        int[] nums = new int[9];
        int index = 8;
        while (num != 0) {
            nums[index] = num % 10;
            num = num / 10;
            index--;
        }
        int[] res = new int[8 - index];
        for (int i = index + 1; i < 9; i++) {
            int stem = 0;
            for (int j = 0; j < 9; j++) {
                if (j == i) {
                    continue;
                }
                stem = stem * 10 + nums[j];
            }
            res[9 - i - 1] = stem;
        }
        return res;
    }

    static class Num {
        int val;
        int times;

        Num(int val, int times) {
            this.val = val;
            this.times = times;
        }
    }
}
