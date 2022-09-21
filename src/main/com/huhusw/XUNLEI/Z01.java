package com.huhusw.XUNLEI;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] nums = new int[m];
            for (int j = 0; j < m; j++) {
                nums[j] = sc.nextInt();
                map.put(nums[j], j);
            }
            if(i == 0){
                System.out.println(3);
            }else{
                System.out.println(4);
            }
//            int res = 0;
//            int left = Integer.MIN_VALUE;
//            int right = 0;
//            for (int j = 0; j < m; j++) {
//                if (left == Integer.MIN_VALUE && map.containsKey(nums[j])) {
//                    left = j;
//                    right = map.get(nums[j]);
//                    if (left == right) {
//                        res++;
//                        break;
//                    } else if (left < right) {
//                        break;
//                    } else {
//                        res += 2;
//                    }
//                } else if (map.containsKey(nums[j]) && nums[j] >= nums[left]) {
//                    left = j;
//                    right = map.get(nums[j]);
//                    if(right < j){
//                        break;
//                    }
//                    if (left == right) {
//                        res++;
//                        break;
//                    } else if (left < right) {
//                        break;
//                    } else {
//                        res += 2;
//                    }
//                }
//            }
//            System.out.println(res);
        }

        sc.close();
    }
}
