package com.huhusw.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/778ae1581eb54959bce91afe0b51c3ff
 * 合法连续子段，找到连续子段满足其中由若干个元素的个数大于等于m
 * <p>
 * 滑动窗口，固定左端不动，移动右端点，直到满足题意
 * 移动左端点，直到不满足题意，重复过程
 */
public class ALI202108 {
    public static void main(String[] args) {
        //输入数据
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        //存储元素出现的次数
        Map<Integer, Integer> memo = new HashMap<>();
        //左右端点和结果
        int l = 0;
        int r = 0;
        long res = 0;
        while (r < n) {
            //右边界对应的值现在应当加一
            int count1 = memo.getOrDefault(nums[r], 0);
            count1++;
            memo.put(nums[r], count1);
            //现在满足题意，移动左边界
            while (l <= r && count1 >= m) {
                //不管左边界如何移动，此时对应的字段个数为n-r，因为还有n-r个元素没有遍历
                res += n - r;
                //更新左边界
                int count2 = memo.get(nums[l]);
                count2--;
                memo.put(nums[l], count2);
                l++;
                //并更新循环条件
                count1 = memo.get(nums[r]);
            }
            r++;
        }
        //结果
        System.out.println(res);
    }
}
