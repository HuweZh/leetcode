package com.huhusw.middle;

/**
 * @author huhusw
 * @Description
 * @create 2021-04-28 10:45
 */
public class M633 {
    public static void main(String[] args) {
        M633 m633 = new M633();
        m633.judgeSquareSum(1000);
    }

    //利用平方根减少循环的次数
    public boolean judgeSquareSum1(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                System.out.println(a);
                System.out.println(b);
                return true;
            }
        }
        return false;
    }

    //双指针法减少循环次数，假设a<b
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
//            if(left == 10){
//                System.out.println("sadlkajdla");
//            }
            if (left * left + right * right == c) {
                return true;
            } else if (left * left + right * right < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
