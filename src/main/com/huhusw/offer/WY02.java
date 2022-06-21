package com.huhusw.offer;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/test/question/done?tid=57540420&qid=1262834#summary
 * 选座位
 * 0代表可选，1代表不可选，选一个座位，这个座位需要离最近的人最远，求这个最远距离
 * <p>
 * 分三种情况：选择头，选择尾，选择中间
 * 头尾只需要找到第一个1和最后一个1
 * 中间需要找到两个1，计算其中的距离，然后除以2
 * 最终的结果是上面的最大值
 */
public class WY02 {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        String[] seats = sc.nextLine().split(" ");
        sc.close();
        //找到第一个1和最后一个1的索引
        int start = 0;
        int end = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i].equals("1")) {
                start = i;
                break;
            }
        }
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i].equals("1")) {
                end = i;
                break;
            }
        }
        //计算结果
        int res = 0;
        res = Math.max(res, start);
        res = Math.max(res, seats.length - 1 - end);
        //中间的选择
        int pre = start;
        for (int i = start + 1; i <= end; i++) {
            if (seats[i].equals("1")) {
                res = Math.max(res, (i - pre) / 2);
                pre = i;
            }
        }
        System.out.println(res);
    }

    /**
     * 双指针实现，复杂度更低，执行效率更高
     * @param args
     */
    public static void main2(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        String[] seats = sc.nextLine().split(" ");
        sc.close();
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i].equals("1")) {
                continue;
            }
            int left = i - 1;
            int right = i + 1;
            int temp = 1;
            while (left >= 0 || right < seats.length) {
                if ((left >= 0 && seats[left].equals("1")) || (right < seats.length && seats[right].equals("1"))) {
                    res = Math.max(res, temp);
                    break;
                }
                if (left >= 0) {
                    left--;
                }
                if (right < seats.length) {
                    right++;
                }
                temp++;
                if (left < 0 && right >= seats.length) {
                    res = Math.max(res, temp);
                }
            }
        }
        System.out.println(res);
    }
}
