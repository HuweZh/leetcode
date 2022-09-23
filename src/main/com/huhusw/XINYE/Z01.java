package com.huhusw.XINYE;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Z01 z01 = new Z01();
        z01.dateArraysSum(new String[]{"20th Oct 2051", "20th Oct 2051", "29th Feb 2004", "2nd Jan 2022"});
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 日期字符串数组一年中的几天求和
     *
     * @param dates string字符串一维数组 日期字符串数组
     * @return int整型
     */
    public int dateArraysSum(String[] dates) {
        // write code here
        int[] month = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Jan", 0);
        map.put("Feb", 1);
        map.put("Mar", 2);
        map.put("Apr", 3);
        map.put("May", 4);
        map.put("Jun", 5);
        map.put("Jul", 6);
        map.put("Aug", 7);
        map.put("Sep", 8);
        map.put("Oct", 9);
        map.put("Nov", 10);
        map.put("Dec", 11);
        int res = 0;
        HashSet<String> set = new HashSet<>();
        for (String d : dates) {
            if (set.contains(d)) {
                continue;
            }
            set.add(d);
            String[] times = d.split(" ");
            if (check(Integer.parseInt(times[2]))) {
                month[1] = 29;
            }
            int[] preSum = new int[13];
//            preSum[0] = month[0];
            for (int i = 0; i < 12; i++) {
                preSum[i + 1] = preSum[i] + month[i];
            }
            res += preSum[map.get(times[1])];
            int day = 0;
            for (int i = 0; i < times[0].length(); i++) {
                if (times[0].charAt(i) >= '0' && times[0].charAt(i) <= '9') {
                    day = day * 10 + times[0].charAt(i) - '0';
                }
            }
            res += day;
        }
        return res;
    }

    private boolean check(int time) {
        if ((time % 4 == 0 && time % 100 != 0) || (time % 400 == 0)) {
            return true;
        }
        return false;
    }
}
