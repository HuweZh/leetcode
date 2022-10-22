package com.huhusw.H3C;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 反转给定的整数
     *
     * @param x int整型 待反转的整数
     * @return int整型
     */
    public int reverse(int x) {
        // write code here
        int a = 0;
        if (x < 0) {
            x = -x;
            while (x > 0) {
                int t = a;
                a = (a * 10) + (x % 10);
                x /= 10;
                if (a / 10 != t) return 0;
            }
            a = -a;
        }else{
            while(x>0){
                int t = a;
                a = (a*10)+(x%10);
                x/=10;
                if(a/10!=t)return 0;
            }
        }
        return a;
    }
}
