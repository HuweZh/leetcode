package com.huhusw.offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/31a1d7926cd947cc907de60ba8192b6c
 * 晋级人数，设定一个分数线，大于等于这个分数线且不为0的都晋级
 * 分情况讨论
 * 最大值为0，没人晋级
 * 分数线为0，往前数直到不为0
 * 分数线不为0，往后数直到不等于分数线，并列晋级
 */
public class MT202106 {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        //对所有人分数排序
        Arrays.sort(scores);
        //结果
        int count = 0;
        //最大值为0，没人晋级
        if (scores[n - 1] == 0) {
            count = 0;
        } else {
            //分数线
            int baseline = scores[n - x];
            //目前晋级的人数为x人
            count = x;
            //分数线为0，往后数，减少人数
            //分数线不为0，往前数，增加人数
            if (baseline == 0) {
                while (scores[n - x] == 0) {
                    count--;
                    x--;
                }
            } else {
                //因为while要从当前位置开始循环，这里要先改变一下状态
                count--;
                while (scores[n - x] == baseline) {
                    count++;
                    x++;
                }
            }
        }
        System.out.println(count);
    }
}
