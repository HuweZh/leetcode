package com.huhusw.offer;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/78255f37c7dc4f749ceafc8c58206a43
 * 字符变换
 * 规定两种字符交换的规则，1.任意交换两个字符的位置，代价为0
 * 2.任意改变一个字符的样子，代价为差值的绝对值，只有小写字母
 * 给两个字符串，将两个字符串转化为相等需要的最小代价
 * <p>
 * 由规则1可知，只要将两个字符串中每个字符出现的频次相等即可
 * 由规则2可知，可以使用贪心，小字母转小字母，大字母转大字母，局部最优
 * 先将字符串中相等的部分去掉，然后剩下不相等的部分进行转化
 */
public class PDD202101 {
    public static void main(String[] args) {
        //输入字符串长度和两个字符串
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        //保留两个字符串中字符出现的频次
        int[] ss1 = new int[26];
        int[] ss2 = new int[26];
        for (int i = 0; i < n; i++) {
            ss1[s1.charAt(i) - 'a']++;
            ss2[s2.charAt(i) - 'a']++;
        }
        //去掉相同的部分
        boolean flag = false;
        for (int i = 0; i < 26; i++) {
            if (ss1[i] >= ss2[i]) {
                ss1[i] -= ss2[i];
                ss2[i] = 0;
            } else {
                ss2[i] -= ss1[i];
                ss1[i] = 0;
            }
            if (!flag && (ss1[i] != 0 || ss2[i] != 0)) {
                flag = true;
            }
        }
        //所有的字符都相同，代价为0
        if (!flag) {
            System.out.println(0);
            return;
        }
        //遍历剩余字符，进行代价最小的查找
        int res = 0;
        int i = 0;
        int j = 0;
        while (true) {
            while (ss1[i] == 0) {
                i++;
            }
            while (ss2[j] == 0) {
                j++;
            }
            res += Math.abs(i - j);
            ss1[i] -= 1;
            ss2[j] -= 1;
            //每次都要检查一下是否全部的字符转化完毕
            if (check(ss1)) {
                break;
            }
        }
        System.out.println(res);
    }

    /**
     * 检查arr数组是否全为0
     * 全为0为true
     *
     * @param arr
     * @return
     */
    private static boolean check(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

