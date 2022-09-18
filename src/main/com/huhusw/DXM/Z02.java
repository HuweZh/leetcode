package com.huhusw.DXM;

import java.util.*;

public class Z02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int h = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();
        ArrayList<int[]> arr = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            arr.add(new int[]{left, right});
        }
        arr.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        for (int i = 0; i < h; i++) {
            ArrayList<int[]> stem = new ArrayList<>();
            for (int j = 0; j < arr.size(); j++) {
                for (int k = j + 1; k < arr.size(); k++) {
                    if (arr.get(k)[0] >= arr.get(j)[1]) {
                        break;
                    }
                    stem.add(new int[]{Math.max(arr.get(k)[0], arr.get(j)[0]), Math.min(arr.get(k)[1], arr.get(j)[1])});
                }
            }
            stem.sort((a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });
            arr = stem;
        }
        for (int i = 0; i < arr.size(); ) {
            while (i + 1 < arr.size() && arr.get(i + 1)[0] == arr.get(i)[0] && arr.get(i + 1)[1] == arr.get(i)[1]) {
                i++;
            }
            for (int j = arr.get(i)[0]; j < arr.get(i)[1]; j++) {
                if (!set.contains(j)) {
                    res++;
                    set.add(j);
                }
            }
            i++;
        }
        System.out.println(res);
    }
}
/*

Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int h = scanner.nextInt();
        arr = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            arr.add(new int[]{left, right});
        }
        arr.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int stemH = h;
        while (stemH > 0) {
            stemH--;
            ArrayList<int[]> stem = new ArrayList<>();
            for (int i = 0; i < arr.size();) {
                for (int j = i + 1; j < arr.size(); j++) {
                    if (arr.get(j)[0] >= arr.get(i)[1]) {
                        break;
                    }
                    stem.add(new int[]{Math.max(arr.get(i)[0], arr.get(j)[0]), Math.min(arr.get(i)[1], arr.get(j)[1])});
                }
                i++;
            }
            stem.sort((a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });
            arr = stem;
        }
        for (int i = 0; i < arr.size(); ) {
            while (i + 1 < arr.size() && arr.get(i + 1)[0] == arr.get(i)[0] && arr.get(i + 1)[1] == arr.get(i)[1]) {
                i++;
            }
            for (int j = arr.get(i)[0]; j < arr.get(i)[1]; j++) {
                if (!set.contains(j)) {
                    res++;
                    set.add(j);
                }
            }
            i++;
        }
        System.out.println(res);
    }
 */