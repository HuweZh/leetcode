package com.huhusw;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author huhusw
 * @Date 2020/11/2
 */
public class S349 {

    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] res = new int[1001];
        Set<Integer> num1 = new HashSet<>();
        Set<Integer> num2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            num1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            num2.add(nums2[i]);
        }
        return getIntersection(num1, num2);
    }

    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            return getIntersection(set2, set1);
        }
        Set<Integer> intersectionSet = new HashSet<>();
        for (Integer num : set1) {
            if (set2.contains(num)) {
                intersectionSet.add(num);
            }
        }
        int[] intersection = new int[intersectionSet.size()];
        int index = 0;
        for (Integer num:intersectionSet
             ) {
            intersection[index++] = num;
        }
        return intersection;
    }
}
