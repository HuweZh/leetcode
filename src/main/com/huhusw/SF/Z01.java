package com.huhusw.SF;

import java.util.*;
/*
小明有一个由1到n的整数组成的排列，他让你来猜出这个排列是什么。你每次可以猜测某一位置的数字，小明会告诉你所猜测的数是“大了”、“小了”或是“正确”。你想知道你在最坏情况下，需要猜测几次，才能在排列的所有位置都得到小明“正确”的回复？
 */
public class Z01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();
//        long sum = 1;
//        for (int i = 2; i <= n; i++) {
//            sum += i - 1;
//        }
//        if(n%2 == 0){
//            sum*=(n/2);
//            sum *= (n-1);
//        }else{
//            sum *=(n-1)/2;
//            sum*=n;
//        }
//        sum += 1;
        if (n == 1) {
            System.out.println(1);
            return;
        }
        long sum = 0;
        for (int i = 1; i < n; i++) {
            sum += ((i + 1) >> 1);
        }
        sum += n;
        System.out.println(sum);

    }
}
