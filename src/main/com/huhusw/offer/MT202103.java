package com.huhusw.offer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/**
 * https://www.nowcoder.com/questionTerminal/601815bea5544f389bcd20fb5ebca6a8
 * 公司食堂，男女按照不同的策略进行座位吃饭
 * 女的先坐0人桌，男的先坐1人桌
 * 都从小号桌开始坐起
 *
 * 模拟整个过程，使用优先队列保证每次先选的是小号桌
 * 按照要求进行输入输出即可
 * 但是直接使用sout会超时，这里应该是用br和bw
 */
public class MT202103 {
    public static void main(String[] args) throws Exception {
        //输入和输出
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        //数据组数
        while (T > 0) {
            T--;
            //当前桌子的现状
            int n = Integer.parseInt(br.readLine());
            //两个优先队列保存不同桌子的序号
            PriorityQueue<Integer> queue0 = new PriorityQueue<>();
            PriorityQueue<Integer> queue1 = new PriorityQueue<>();
            String str = br.readLine();
            //遍历桌子，并保存
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == '0') {
                    queue0.offer(i + 1);
                } else if (str.charAt(i) == '1') {
                    queue1.offer(i + 1);
                }
            }
            //输入排队的情况
            int m = Integer.parseInt(br.readLine());
            String temp = br.readLine();
            //遍历队伍
            for (int i = 0; i < m; i++) {
                //男
                if (temp.charAt(i) == 'M') {
                    //优先坐1人桌，坐0人桌时需要将桌子状态更新至1人桌
                    if (!queue1.isEmpty()) {
                        bw.write(queue1.poll().toString());
                        bw.newLine();
                    } else {
                        String order = queue0.poll().toString();
                        bw.write(order);
                        bw.newLine();
                        queue1.offer(Integer.parseInt(order));
                    }
                } else {
                    //女，先坐0人桌，并更新桌子状态
                    if (!queue0.isEmpty()) {
                        String order = queue0.poll().toString();
                        bw.write(order);
                        bw.newLine();
                        queue1.offer(Integer.parseInt(order));
                    } else {
                        bw.write(queue1.poll().toString());
                        bw.newLine();
                    }
                }
            }
            //刷新缓冲区
            bw.flush();
        }
    }
}
