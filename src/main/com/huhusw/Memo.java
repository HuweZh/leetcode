package com.huhusw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 备忘录
 */
public class Memo {
    //日期对应字符串
    static Map<String, Integer> date2str = new HashMap<>();
    //字符串对应日期
    static Map<String, String> str2date = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        while (times > 0) {
            times--;
            String str = scanner.nextLine();
            String[] s = str.split(" ");
            //添加
            if ("1".equals(s[0])) {
                //检查日期
                if (!check(s[1], s[2], s[3])) {
                    System.out.println("error");
                } else if (str2date.containsKey(s[4])) {
                    System.out.println("existed");
                } else {
                    String date = s[1] + "/" + s[2] + "/" + s[3];
                    date2str.put(date, date2str.getOrDefault(date, 0) + 1);
                    str2date.put(s[4], date);
                    System.out.println("done");
                }
            } else if ("2".equals(s[0])) {
                //查询字符串
                //检查日期
                if (!check(s[1], s[2], s[3])) {
                    System.out.println("error");
                } else {
                    String date = s[1] + "/" + s[2] + "/" + s[3];
                    System.out.println(date2str.get(date));
                }
            } else {
                //查询日期
                if (!str2date.containsKey(s[1])) {
                    System.out.println("not existed");
                } else {
                    System.out.println(str2date.get(s[1]));
                }
            }
        }
    }

    /**
     * 检查日期是否合法
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static boolean check(String year, String month, String day) {
        int y = Integer.parseInt(year);
        int m = Integer.parseInt(month);
        int d = Integer.parseInt(day);
        int[] date = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (((y % 100 != 0 && y % 4 == 0) || y % 400 == 0) && m == 2) {
            date[2] += 1;
        }
        if (y < 2022 || y > 9999 || m <= 0 || m > 12 || d <= 0) {
            return false;
        } else {
            return d <= date[m] ? true : false;
        }
    }
}
