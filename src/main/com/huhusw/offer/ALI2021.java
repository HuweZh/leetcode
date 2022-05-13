package com.huhusw.offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/a55198d2e65746009110226f2f6c8533
 * <p>
 * 由题意可知，在进行一个元素的排序后，求另一个元素的最长递增子序列即可完成题目要求
 * 这里的最长递增子序列因为不能是n方复杂度，会超时
 * 所以使用贪心+二分，nlogn的复杂度
 * dp[i]表示长度为i的子序列第i位最小值为dp[i]
 */
public class ALI2021 {
    public static void main(String[] args) {
        //输入数据
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T > 0) {
            T--;
            int n = Integer.parseInt(sc.nextLine());
            String[] x = sc.nextLine().split(" ");
            String[] y = sc.nextLine().split(" ");
            //保存数组元素，相当于信封套娃的题
            //https://leetcode.cn/problems/russian-doll-envelopes/
            int[][] item = new int[n][2];
            for (int i = 0; i < n; i++) {
                item[i][0] = Integer.parseInt(x[i]);
                item[i][1] = Integer.parseInt(y[i]);
            }
            //排序，对第一个元素升序，第二个元素降序
            Arrays.sort(item, new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] != o2[0]) {
                        return o1[0] - o2[0];
                    } else {
                        return o2[1] - o1[1];
                    }
                }
            });
            //结果
            int res = 1;
            //dp数组，并赋初始值
            int[][] dp = new int[n + 1][2];
            dp[1] = item[0];
            //遍历剩下的元素
            for (int i = 1; i < n; i++) {
                //因为第二维的元素是递减的，所以碰见大于当前元素的值，可以直接追加到dp数组的后面
                //否则，就找到一个索引保存当前的元素，因为第二维元素递减，所以不会出现连续的第一维元素相等的情况
                if (dp[res][1] < item[i][1]) {
                    dp[++res] = item[i];
                } else {
                    //二分查找放置的位置
                    int l = 1;
                    int r = res;
                    //放置的索引位置，初始值为0，如果找不到就更新第一位
                    int pos = 0;
                    //二分
                    while (l <= r) {
                        int mid = (l + r) >> 1;
                        //中间值小于当前元素，更新索引和左边界值，继续寻找
                        //否则，更新右边界
                        if (dp[mid][1] < item[i][1]) {
                            pos = mid;
                            l = mid + 1;
                        } else {
                            r = mid - 1;
                        }
                    }
                    //这里有两种情况，第一个是第一维元素相等，那么可以直接覆盖，说明第一维元素相等的元素有更加合适的
                    //第二种是不相等，不相等也可以直接覆盖，因为目前需要找的元素就是不相同的元素
                    dp[pos + 1] = item[i];
                }
            }
            System.out.println(res);
        }
    }
}
