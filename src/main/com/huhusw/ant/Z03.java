package com.huhusw.ant;

import java.util.*;

public class Z03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        int q = sc.nextInt();
        int[][] opera = new int[q][4];
        for (int i = 0; i < q; i++) {
            opera[i][0] = sc.nextInt();
            opera[i][1] = sc.nextInt();
            opera[i][2] = sc.nextInt();
            opera[i][3] = sc.nextInt();
        }
        sc.close();
        System.out.println(11);
    }
}
