package com.huhusw.middle;

import java.util.Arrays;

public class M881 {
    public static void main(String[] args) {
        M881 m881 = new M881();
        int i = m881.numRescueBoats(new int[]{3, 5, 3, 4}, 5);
        System.out.println(i);
    }

    //贪心
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int right = people.length-1;
        int left = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                res++;
                left++;
                right--;
            } else {
                res++;
                right--;
            }
        }
        return res;
    }
}
