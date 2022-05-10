package com.huhusw.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/877c520f935c4d67a4614dc4bce84a1a
 * 求和计算
 * 有一个数组，数组中的元素为和谐值
 * 求一段数组的和谐值之和，若和能被m整除，则说明这一段是和谐的
 * 单个元素也可以看做和谐
 * 求和谐段数
 * <p>
 * 前缀和加hash
 * 在前缀和数组中，和对m取余相等的元素，之间的元素一定能被m整除
 * 所以只需要知道前缀和数组中取余后相等的元素的个数
 * 就能判断当前的余数值对应的段数，这些数中任取两个一定能被m整除
 * 所以使用hash加速寻找的过程
 */
public class PDD202102 {
    public static void main(String[] args) {
        //输入n、m、n个元素值
        Scanner sc = new Scanner(System.in);
        String[] nm = sc.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[] arr = sc.nextLine().split(" ");
        int[] nums = new int[n];
        //这里计算前缀和，因为要取余，对和每一次都取余
        long sum = 0L;
        //hash表
        int[] map = new int[m];
        //取余为0的值要被赋初值，因为取余为0本身能被m整除
        //所以要加上自身一次，正好在求cn2时，只需要再加上1即可
        map[0] = 1;
        //遍历数组，计算前缀和，更新hash
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(arr[i]);
            //前缀和
            sum = (sum + nums[i]) % m;
            //更新hash
            map[(int) sum]++;
        }
        //计算结果
        long res = 0;
        for (int i = 0; i < m; i++) {
            //对每一个取余后的值任取两个作为结果
            res += cn2(map[i]);
        }
        System.out.println(res);
    }

    /**
     * 从num中任取两个数的方案数
     *
     * @param num
     * @return
     */
    private static long cn2(int num) {
        return (long) num * (num - 1) >> 1;
    }
}

