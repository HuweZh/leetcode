package com.huhusw.YUAN;

import java.util.*;

public class Z03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            for (int i = 2; i <= num; ) {
                if (num % i == 0) {
                    System.out.println("质因子：" + i);
                    num /= i;
                } else i++;
            }
        }

        sc.close();
    }

}
