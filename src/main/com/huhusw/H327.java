package com.huhusw;

import javax.sound.midi.SoundbankResource;

/**
 * @Author huhusw
 * @Date 2020/11/7
 */
public class H327 {
    public static void main(String[] args) {
        H327 h327 = new H327();
        int i = h327.countRangeSumNLOGN(new int[]{-2, 5, -1, 8, 9, -10}, -2, 2);
        System.out.println(i);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int result = 0;

        //双层循环，外层循环遍历数组
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            // 内层循环从当前索引往后寻找
            for (int j = i; j < nums.length; j++) {
                // 加到总和上面，处在区间内，结果加一
                sum += nums[j];
                if (sum >= lower && sum <= upper) {
                    result += 1;
                }
            }
        }

        return result;
    }

    public int countRangeSumNLOGN(int[] nums, int lower, int upper) {
        long s = 0;
        // 前缀和数组
        long[] sum = new long[nums.length + 1];
        // 计算前缀和，并填充数组
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            sum[i + 1] = s;
        }
        return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
    }

    private int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (left + right) / 2;
            int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
            int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int l = mid + 1;
            int r = mid + 1;
            while (i <= mid) {
                while (l <= right && sum[l] - sum[i] < lower) {
                    l++;
                }
                while (r <= right && sum[r] - sum[i] <= upper) {
                    r++;
                }
                ret += r - 1;
                i++;
            }
            // 合并两个排序数组
            int[] sorted = new int[right - left + 1];
            int p1 = left;
            int p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = (int) sum[p2++];
                } else if (p2 > right) {
                    sorted[p++] = (int) sum[p1++];
                } else {
                    if (sum[p1] < sum[p2]) {
                        sorted[p++] = (int) sum[p1++];
                    } else {
                        sorted[p++] = (int) sum[p2++];
                    }
                }
            }
            for (int j = 0; j < sorted.length; j++) {
                sum[left + j] = sorted[j];
            }
            return ret;
        }
    }
}
