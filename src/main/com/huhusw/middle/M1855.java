package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/maximum-distance-between-a-pair-of-values/
 * 下标对中的最大值
 * <p>
 * 两个非递增的数组，ij分别为索引，满足s1[i]<=s2[j]的j-i的最大值
 * 因为非递增，所有在遍历s2的情况下，只需要维持左边界就能完成需求
 * 因为j在增大的过程中s2[j]在减小，所以j+1对应的i’一定小于等于i
 */
public class M1855 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int res = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        for (int j = 0; j < n2; j++) {
            while (i < n1 && nums1[i] > nums2[j]) {
                i++;
            }
            if (i < n1) {
                res = Math.max(res, j - i);
            }
        }
        return res;
    }
}
