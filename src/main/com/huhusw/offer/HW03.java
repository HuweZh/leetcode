package com.huhusw.offer;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/8f3df50d2b9043208c5eed283d1d4da6
 * 进制转换，输入十六进制数，转化为十进制
 */
public class HW03 {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int n = s.length();
            int res = 0;
            //去掉0x，开始解析
            for (int i = 2; i < n; i++) {
                //0-9直接相加
                //A-F需要额外加10
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    res = res * 16 + (s.charAt(i) - '0');
                } else {
                    res = res * 16 + (s.charAt(i) - 'A' + 10);
                }
            }
            System.out.println(res);
        }
    }
}
