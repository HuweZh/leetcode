package com.huhusw.BY;

import java.util.*;

public class Z04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[m];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }
        sc.close();
        Map<Integer, Integer> mapA = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mapA.isEmpty()) {
                for (int j = 1; j <= A[i]; j++) {
                    mapA.put(j, 1);
                }
            } else {
                Map<Integer, Integer> stem = new HashMap<>();
                for (Map.Entry<Integer, Integer> entry : mapA.entrySet()) {
                    if (entry.getValue() <= 0) {
                        continue;
                    }
                    for (int j = 1; j <= A[i]; j++) {
                        int key = j + entry.getKey();
                        int value = stem.getOrDefault(key, 0) + 1;
                        stem.put(key, value);
                    }
                    entry.setValue(entry.getValue() - 1);
                }
                for (Map.Entry<Integer, Integer> entry : stem.entrySet()) {
                    mapA.put(entry.getKey(), entry.getValue() + mapA.getOrDefault(entry.getKey(), 0));
                }
            }
        }
        Map<Integer, Integer> mapB = new HashMap<>();
        for (int i = 0; i < m; i++) {
            if (mapB.isEmpty()) {
                for (int j = 1; j <= B[i]; j++) {
                    mapB.put(j, 1);
                }
            } else {
                Map<Integer, Integer> stem = new HashMap<>();
                for (Map.Entry<Integer, Integer> entry : mapB.entrySet()) {
                    if (entry.getValue() <= 0) {
                        continue;
                    }
                    for (int j = 1; j <= B[i]; j++) {
                        int key = j + entry.getKey();
                        int value = stem.getOrDefault(key, 0) + 1;
                        stem.put(key, value);
                    }
                    entry.setValue(entry.getValue() - 1);
                }
                for (Map.Entry<Integer, Integer> entry : stem.entrySet()) {
                    mapB.put(entry.getKey(), entry.getValue() + mapB.getOrDefault(entry.getKey(), 0));
                }
            }
        }
        int[] a = new int[161];
        int[] b = new int[161];
        double sumA = 0;
        double sumB = 0;
        for (Map.Entry<Integer, Integer> entry : mapA.entrySet()) {
            a[entry.getKey()] = entry.getValue();
            sumA += entry.getValue();
        }
        for (Map.Entry<Integer, Integer> entry : mapB.entrySet()) {
            b[entry.getKey()] = entry.getValue();
            sumB += entry.getValue();
        }
        double res = 0.0D;
        for (int i = 0; i < 161; i++) {
            if (a[i] != 0) {
                int count = 0;
                for (int j = i - 1; j >= 0; j--) {
                    count += b[j];
                }
                System.out.println(((double) a[i] /  sumA));
                System.out.println(((double) count / sumB));
                res += ((double) a[i] /  sumA) * ((double) count / sumB);
            }
        }
        System.out.printf("%.3f\n",res);
    }
}
