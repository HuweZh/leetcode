package com.huhusw.offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.nowcoder.com/questionTerminal/c59d9690061e448fb8ec7d744c20ebff
 * 第K小子串，计算出字符串中所有的子串中第k小的子串
 * 字符串很长，双重循环堆空间爆掉，所以需要技巧优化内存
 * 因为找的是第k的子串，那么就一定能保证最终的结果长度不会超过k，根据这个点出发，减少循环次数
 *
 * 对于第k小子串，可以使用大顶堆进行常数时间的查找，当堆的元素数量小于k时，直接加入
 * 大于k时，弹出顶部加入
 * 同时还需要一个集合用来去重，因为字符串可能出现重复的现象
 */
public class TX202102 {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        int n = str.length();
        //大顶堆
        PriorityQueue<String> queue = new PriorityQueue<>((s1, s2) -> s2.compareTo(s1));
        //去重
        Set<String> set = new HashSet<>();
        //双重循环
        //外层循环控制子串的长度
        for (int len = 1; len <= k; len++) {
            //内层循环控制原始字符串的遍历
            for (int i = 0; i < n - len + 1; i++) {
                //子串
                String temp = str.substring(i, i + len);
                //重复的直接跳过
                if (!set.contains(temp)) {
                    set.add(temp);
                    //大顶堆加入元素的逻辑
                    if (queue.size() < k) {
                        queue.offer(temp);
                    } else {
                        //这里要比较一下顶部元素与当前元素
                        if (queue.peek().compareTo(temp) > 0) {
                            queue.poll();
                            queue.offer(temp);
                        }
                    }
                }
            }
        }
        //结果
        System.out.println(queue.peek());
    }
}
