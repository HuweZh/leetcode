package com.huhusw.middle;

public class M413 {

    public static void main(String[] args) {
        M413 m413 = new M413();
        int i = m413.numberOfArithmeticSlices(new int[]{1, 2, 3, 4});
        System.out.println(i);
    }

    //初始条件
    int[] f = new int[500];

    public int numberOfArithmeticSlices(int[] nums) {
        /**
         连续的元素的差应该是相等的才能满足等差数列，充分条件
         那么根据差相等的个数，可以发现规律:
         差相等的个数-可以组成的子数列的个数
         0-0
         1-0
         2-1
         3-3
         4-6
         5-10
         于是可以构造数组 f(0)=0 f(1)=0 f(2)=1 f(n+1)=f(n)+n
         于是，问题转化为求原数组中相邻元素的差，在差组成的数组中找相等元素的个数
         全部的相等元素构成的子数列的个数想加得到结果
         */
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        calCount();
        //元素差构成的数组
        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = nums[i + 1] - nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n - 1; ) {
            //计算相同元素的个数
            int count = 1;
            for (int j = i + 1; j < n - 1; j++) {
                if (diff[j] == diff[i]) {
                    count++;
                } else {
                    break;
                }
            }
            i += count;
            //加到结果上
            ans += f[count];
        }
        return ans;
    }
    //计算相同元素构成子数组的个数
    private void calCount() {
        f[0] = 0;
        f[1] = 0;
        f[2] = 1;
        for (int i = 3; i < f.length; i++) {
            f[i] = f[i - 1] + i - 1;
        }
    }
}
