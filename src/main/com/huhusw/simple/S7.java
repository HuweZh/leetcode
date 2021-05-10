package com.huhusw.simple;

/**
 * @author huhusw
 * @Description
 * @create 2021-04-29 11:10
 */
public class S7 {

    public static void main(String[] args) {
        S7 s7 = new S7();
        int reverse = s7.reverse(Integer.MAX_VALUE);
        System.out.println(reverse);
    }

    public int reverse(int x) {

        int result = 0;

        while (x != 0) {
            //最后一位数组
            int num = x % 10;
            x /= 10;

            //判断溢出
            //正数溢出
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num > 7)) return 0;
            //负数溢出
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && num < -8)) return 0;

            //赋值给新的数
            result = result * 10 + num;
        }

        return result;
    }
}
