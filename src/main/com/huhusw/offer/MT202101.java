package com.huhusw.offer;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/9c4a4e879b4f49939dfaebea8948f976
 * 每个人都有一个成绩，裁判想设定一个分数线，大于分数线的晋级，其他的淘汰
 * 但是要保证淘汰和晋级的人数都在[x,y]区间内，可能会有多个答案，输出最小值
 * 这个题目通过排序，可以变成求一个上升序列中的第k小的元素
 * 使用二分可以在log(n)的复杂度下完成目标，但是二分有一点一点的小问题：1 2 2 3  x=2,y=2,这个序列应该是-1，二分比较难做
 * 这里使用的是最小堆，往外面弹x个元素
 * 接着再进行判断后面的元素是否相等
 */
public class MT202101 {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        //最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.offer(sc.nextInt());
        }
        //提前判断
        if (!(n >= 2 * x && n <= 2 * y)) {
            System.out.println(-1);
            return;
        }
        //结果
        int res = 0;
        //本次弹出的限额
        int temp = x;
        while (temp > 0) {
            temp--;
            res = queue.poll();
        }
        //这是题目的要求，不能超过y，再这个区间判断是否符合题意
        temp = y - x;
        while (temp > 0 && queue.peek() == res) {
            queue.poll();
            temp--;
        }
        //弹到最后还是相等，代表序列不能满足题意
        if (queue.peek() == res) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }
}
