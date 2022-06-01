package com.huhusw.offer;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/42852fd7045c442192fa89404ab42e92
 * 聪明的编辑，编辑收到了作品，需要对作品进行纠错
 * 一共两种错误：1.连续三个字母相同，删除其中一个即可 2.AABB型，删除一个B即可
 * 扫描从左到右，最近匹配，求编辑后的作品
 * <p>
 * 对于连续的字符串，可以使用暴力查找解决问题
 * 但是，有更优雅的解决方案，自动机
 * 定义一个三种状态的自动机
 * 初始为状态0，假设下一个字符为A，分两种情况：当前字符为A和不为A，为A进入状态2，不为A，状态0自旋，同时构造字符串
 * 状态1根据状态0，只能为A，对于下一个字符，分两种情况：A和非A，A丢弃自旋，非A假设为B，进入状态2
 * 状态2根据状态1，只能为B，对于下一个字符，分两种情况：B和非B，B丢弃自旋，非B进入状态0
 * 0 ---->  1 ----->  2
 * ↖ <--------------↙
 */
public class BYTE01 {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        while (N > 0) {
            N--;
            String str = sc.nextLine();
            //结果
            StringBuilder sb = new StringBuilder();
            //当前字符和下一个字符
            char cur = '!';
            char next = '!';
            //初始状态为0
            int state = 0;
            //遍历字符串
            for (int i = 0; i < str.length(); i++) {
                //下一个字符
                next = str.charAt(i);
                //自动机状态
                switch (state) {
                    //状态0
                    case 0:
                        if (cur == next) {
                            state = 1;
                        } else {
                            cur = next;
                        }
                        sb.append(next);
                        break;
                    //状态1
                    case 1:
                        if (cur == next) {

                        } else {
                            state = 2;
                            sb.append(next);
                            cur = next;
                        }
                        break;
                    //状态2
                    case 2:
                        if (cur == next) {

                        } else {
                            state = 0;
                            sb.append(next);
                            cur = next;
                        }
                        break;
                }
            }
            //结果
            System.out.println(sb.toString());
        }
    }
}
