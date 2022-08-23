package com.huhusw.acmer;

import java.util.*;

/**
 * https://examacmcoder.oss-accelerate.aliyuncs.com/release/exam/2.1.7/htmls/result/index.html?code=f96ef677-1683-461f-9579-d6077b184031
 * 求一个数列中的最大值
 * 最大值定义为：区间最小值*区间的和
 */
public class A02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        int res = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int k = i - 1;
            int sum = 0;
            while (j < n && nums[i] <= nums[j]) {
                sum += nums[j];
                j++;
            }
            while (k >= 0 && nums[i] <= nums[k]) {
                sum += nums[k];
                k--;
            }
            res = Math.max(res, sum * nums[i]);
        }
        System.out.println(res);

//        int[] preSum = new int[n];
//        preSum[0] = nums[0];
//        for (int i = 1; i < n; i++) {
//            preSum[i] = preSum[i - 1] + nums[i];
//        }
//        int[][] minDp = new int[n][n];
//        for (int i = n - 1; i >= 0; i--) {
//            minDp[i][i] = nums[i];
//            for (int j = i + 1; j < n; j++) {
//                minDp[i][j] = Math.min(minDp[i + 1][j], minDp[i][j - 1]);
//            }
//        }
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                res = Math.max(res, preSum[j - i] * minDp[i][j]);
//            }
//        }
//        System.out.println(res);
    }
}
