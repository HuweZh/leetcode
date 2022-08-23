package com.huhusw.acmer;

import java.util.*;

/**
 * https://examacmcoder.oss-accelerate.aliyuncs.com/release/exam/2.1.7/htmls/result/index.html?code=f96ef677-1683-461f-9579-d6077b184031
 * 找二维坐标轴上的最大点
 * 一个点的右上方不会出现其他点称为最大点
 */
public class A01 {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> points = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            points.add(new Point(sc.nextInt(), sc.nextInt()));
        }
        sc.close();
        Collections.sort(points, (p1, p2) -> {
            return p1.y == p2.y ? p2.x - p1.x : p1.y - p2.y;
        });
        System.out.println(points.get(n - 1).x + " " + points.get(n - 1).y);
        int max = points.get(n - 1).x;
        for (int i = n - 2; i >= 0; i--) {
            if (points.get(i).x > max) {
                max = points.get(i).x;
                System.out.println(points.get(i).x + " " + points.get(i).y);
            }
        }
    }
}
