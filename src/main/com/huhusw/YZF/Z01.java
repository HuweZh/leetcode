package com.huhusw.YZF;

import java.util.*;

public class Z01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] duili = new long[2];
        long[] guang = new long[2];
        duili[0] = scanner.nextInt();
        duili[1] = scanner.nextInt();
        guang[0] = scanner.nextInt();
        guang[1] = scanner.nextInt();
        scanner.close();
        long sum = 0;
        while (duili[1] > 0 && guang[1] > 0) {
            sum += duili[0] + guang[0];
            duili[1] -= guang[0];
            guang[1] -= duili[0];
        }
        if (duili[1] <= 0 && guang[1] <= 0) {
            //什么都不做
        } else if (duili[1] <= 0) {
            sum += guang[0] * 10;
        } else {
            sum += duili[0] * 10;
        }
        System.out.println(sum);
    }
}
