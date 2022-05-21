package com.huhusw.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/b65b8b1376d94d4b8d4718ba2f4c0022
 * 两个序列，计算两个序列转化成相同需要的最小步骤
 * 序列中的元素都相同，仅仅是顺序不同
 * 每次转化的步骤为：每一步可以选择将a的首位或末位插入到序列的任意位置
 * <p>
 * 通过题意，正常的做法，比较困难编码
 * 可以将其转化为最长上升子序列的问题
 * 因为b序列是不允许动的，所以可以将b序列的元素看成是升序排列的元素
 * 因为可以插入到任意位置，所以只需要求出a中与b中相似的上升序列x，其他的元素在n-|x|步骤内一定可以转化成b
 */
public class ALI202109 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入a，b序列
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        //将b转化成一个上升序列
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            memo.put(b[i], i);
        }
        //求a的最长上升子序列
        int cur = 0;
        int low = -1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (memo.get(a[i]) > low) {
                cur++;
            } else {
                res = Math.max(res, cur);
                cur = 1;
            }
            low = memo.get(a[i]);
        }
        //结果就是差值
        System.out.println(n - res);
    }
}
