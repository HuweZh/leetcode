package com.huhusw;

import java.util.*;

public class Merger {
    public static void main(String[] args) {
        int[] nums = new int[]{-5, 80, 2, 4, 45, -10, 30, 200, 153, -1};
        Merger merger = new Merger();
        nums = merger.mergerSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public int[] mergerSort(int[] nums, int left, int right) {
        if (left == right) {
            return new int[]{nums[left]};
        }
        int mid = (left + right) / 2;
        int[] leftArr = mergerSort(nums, left, mid);
        int[] rightArr = mergerSort(nums, mid + 1, right);
        return merger(leftArr, rightArr);
    }

    private int[] merger(int[] leftArr, int[] rightArr) {
        int[] stem = new int[leftArr.length + rightArr.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < leftArr.length + rightArr.length; i++) {
            if (leftIndex == leftArr.length) {
                stem[i] = rightArr[rightIndex];
                rightIndex++;
            } else if (rightIndex == rightArr.length) {
                stem[i] = leftArr[leftIndex];
                leftIndex++;
            } else if (leftArr[leftIndex] < rightArr[rightIndex]) {
                stem[i] = leftArr[leftIndex];
                leftIndex++;
            } else {
                stem[i] = rightArr[rightIndex];
                rightIndex++;
            }
        }
        return stem;
    }
}
