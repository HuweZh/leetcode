package com.huhusw;

/**
 * @author huhusw
 * @Description
 * @create 2021-05-20 13:36
 */
public class Test {
    public static void main(String[] args) {
        String a = "abc";
        String b = "acs";

        System.out.println(a.compareTo(b));
        int i = Math.min(a.length(), b.length());
        for (int j = 0; j < i; j++) {
            if (a.charAt(j) != b.charAt(j)) {
                System.out.println(a.charAt(j));
                System.out.println(b.charAt(j));
                System.out.println(a.charAt(j) - b.charAt(j));
            } else {
                continue;
            }
        }

    }
}
