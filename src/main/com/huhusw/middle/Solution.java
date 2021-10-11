package com.huhusw.middle;

import java.util.*;
import java.util.stream.Collectors;

//M528
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 3});
        for (int i = 0; i < 20; i++) {
            System.out.println(solution.pickIndex());
        }
    }

    //w的元素和，即转化为数轴时的长度
    int total;
    //前缀和
    int[] pre;

    public Solution(int[] w) {
        int n = w.length;
        pre = new int[n];
        pre[0] = w[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + w[i];
        }
        total = Arrays.stream(w).sum();
    }

    public int pickIndex() {
        //随机返回数轴上的一个数字
        int index = (int) (Math.random() * total + 1);
        return binarySearch(index);
    }

    private int binarySearch(int index) {
        int left = 0;
        int right = pre.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (pre[mid] < index) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */