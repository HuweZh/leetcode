package com.huhusw.hard;

import java.util.HashMap;
import java.util.Map;

public class H446 {
    public int numberOfArithmeticSlices(int[] nums) {
        //构造弱等差数列
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        //状态记录变量，f[i][d]表示已nums[i]为尾项，d为公差的弱等差数列的数量
        //通过计算弱等差数列的数量，更新等差数列的数量
        //题目规定至少三个元素构成等差数列，我们现在需要做的是先找两个数，他们的公差为nums[i]-nums[j](i>j)
        //即状态变量f[i][nums[i]-nums[j]]
        //更新nums的状态变量为f[i][d] += f[j][d],即他们组成的各个弱等差数列的公差都相等，连起来可以构成一个大的弱等差数列
        //考虑到nums[i]和nums[j]也可以组成一个弱等差数列，所以状态转移方程前需要加1
        //即f[i][d] += f[j][d]+1
        //这样不断的往前传输状态，最后计算得到答案。

        //因为二维变量的数太大，使用数组会造成大量的浪费，使用哈希表代替
        Map<Long, Integer>[] f = new Map[n];
        for (int i = 0; i < n; i++) {
            f[i] = new HashMap<>();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //计算公差
                long d = 1L * nums[i] - nums[j];
                //第i个元素可以加到第j个元素构成的弱等差数列后面，所以结果需要加上
                int cur = f[j].getOrDefault(d, 0);
                ans += cur;
                //状态转移方程
                f[i].put(d, f[i].getOrDefault(d, 0) + cur + 1);
            }
        }

        return ans;
    }
}
