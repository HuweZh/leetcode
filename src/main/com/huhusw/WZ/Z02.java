package com.huhusw.WZ;

import java.util.*;

public class Z02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            if (!check(a, b)) {
                System.out.println(-1);
                continue;
            }
            HashSet<Long> set = new HashSet<>();
            set.add(a);
            set.add(b);
            Queue<Long> queue = new LinkedList<>();
            queue.add(a);
            int step = 0;
            while (!queue.isEmpty()) {
                boolean flag = false;
                int size = queue.size();
                step++;
                for (int j = 0; j < size; j++) {
                    long num = queue.poll();
                    if (b > a) {
                        if (num > b) {
                            continue;
                        }
                        if (set.contains(num * 2)) {
                            continue;
                        } else {
                            if (num * 2 == b) {
                                System.out.println(step);
                                flag = true;
                                break;
                            } else {
                                if (!set.contains(num * 2)) {
                                    set.add(num * 2);
                                    queue.add(num * 2);
                                }
                            }
                        }
                        if (num * 4 == b) {
                            System.out.println(step);
                            flag = true;
                            break;
                        } else {
                            if (!set.contains(num * 4))
                                set.add(num * 4);
                            queue.add(num * 4);
                        }
                        if (num * 8 == b) {
                            System.out.println(step);
                            flag = true;
                            break;
                        } else {
                            if (!set.contains(num * 8))
                                set.add(num * 8);
                            queue.add(num * 8);
                        }
                    } else {
                        if (num < b) {
                            continue;
                        }
                        if (num % 2 == 0 && num / 2 == b) {
                            System.out.println(step);
                            flag = true;
                            break;
                        } else if (num % 2 == 0 && !set.contains(num / 2)) {
                            set.add(num / 2);
                            queue.add(num / 2);
                        }
                        if (num % 4 == 0 && num / 4 == b) {
                            System.out.println(step);
                            flag = true;
                            break;
                        } else if (num % 4 == 0 && !set.contains(num / 4)) {
                            queue.add(num / 4);
                            set.add(num / 4);
                        }
                        if (num % 8 == 0 && num / 8 == b) {
                            System.out.println(step);
                            flag = true;
                            break;
                        } else if (num % 8 == 0 && !set.contains(num / 8)) {
                            queue.add(num / 8);
                            set.add(num / 8);
                        }
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
        scanner.close();
    }

    private static boolean check(long a, long b) {
        while (a % 2 == 0) {
            a /= 2;
        }
        while (b % 2 == 0) {
            b /= 2;
        }
        return a == b;
    }
}
