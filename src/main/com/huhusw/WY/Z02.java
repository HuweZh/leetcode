package com.huhusw.WY;

import java.util.*;

public class Z02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        int oushuMax = 0;
        int jishuMax = 0;
        List<Integer> oushu = new ArrayList<>();
        List<Integer> jishu = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            oushuMax = Math.max(oushuMax, nums[i]);
            oushu.add(nums[i]);
        }
        for (int i = 1; i < n; i += 2) {
            jishuMax = Math.max(jishuMax, nums[i]);
            jishu.add(nums[i]);
        }
        int res = 0;
        for (int i = 0; i < oushu.size(); i++) {
            res += oushuMax - oushu.get(i);
        }
        for (int i = 0; i < jishu.size(); i++) {
            res += jishuMax - jishu.get(i);
        }
        if(oushuMax == jishuMax){
            System.out.println(res + jishu.size() > oushu.size() ? oushu.size() : jishu.size());
        }else{
            System.out.println(res);
        }
//        int add = 0;
//        if (oushuMax > jishuMax) {
//            add = oushuMax - jishuMax - 1;
//            System.out.println(res + add * jishu.size());
//        } else if (jishuMax > oushuMax) {
//            add = jishuMax - oushuMax - 1;
//            System.out.println(res + add * oushu.size());
//        } else {
//            add = jishu.size() > oushu.size() ? oushu.size() : jishu.size();
//            System.out.println(res + add);
//        }
    }
}
