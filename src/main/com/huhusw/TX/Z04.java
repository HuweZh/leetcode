package com.huhusw.TX;

import java.util.*;

public class Z04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long L = sc.nextLong();
        long R = sc.nextLong();
        sc.close();

        ArrayList<Long> arr = new ArrayList<>();
        long diff = R - L + 1;
        long base = 2;
        while (base < diff) {
            base *= 2;
        }
        while (base < R) {
            arr.add(base * 2);
            base *= 2;
        }
        arr.add(base * 2);
        long stemL = L;
        int count = 0;
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < arr.size(); i++) {
                if ((arr.get(i) >= stemL) || (i == arr.size() - 1)) {
                    flag = false;
                    break;
                }
                if (arr.get(i) <= stemL && arr.get(i + 1) >= stemL) {
                    stemL = arr.get(i + 1) - stemL + 1;
                    count++;
                }
            }
        }

        if (count % 2 == 0) {
            L = stemL;
            R = stemL + diff;
        } else {
            L = stemL - R;
            R = stemL;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(0);
        while (sb.length() <= R) {
            int size = sb.length();
            for (int i = 0; i < size; i++) {
                if (sb.charAt(i) == '1') {
                    sb.append(0);
                } else {
                    sb.append(1);
                }
            }
        }
        int res = 0;
        if (count % 2 == 0) {
            for (int i = (int) L - 1; i < R; i++) {
                res += sb.charAt(i) - '0';
            }
        } else {
            for (int i = (int) L - 1; i < R; i++) {
                res += '1' - sb.charAt(i);
            }
        }
        System.out.println(res);
    }
}
/*
40
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int R = sc.nextInt();
        sc.close();
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(0);
        while (sb.length() <= R) {
            int size = sb.length();
            for (int i = 0; i < size; i++) {
                if (sb.charAt(i) == '1') {
                    sb.append(0);
                } else {
                    sb.append(1);
                }
            }
        }
        int res = 0;
        for (int i = L-1; i < R; i++) {
            res += sb.charAt(i) - '0';
        }
        System.out.println(res);
    }
}

 */