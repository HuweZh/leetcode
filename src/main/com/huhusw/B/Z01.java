package com.huhusw.B;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int res = 0;
        int i = 2;
        while (i < N) {
            if (N % i == 0) {
                res += i;
                N /= i;
            }else{
                i++;
            }
        }
        System.out.println(res);
    }
}
