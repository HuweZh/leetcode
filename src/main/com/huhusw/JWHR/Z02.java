package com.huhusw.JWHR;

import java.util.*;

public class Z02 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 求子数组最大和
     *
     * @param array int整型一维数组 给定数组
     * @return int整型
     */
    public int getMaxSubArray(int[] array) {
        // write code here
        int max = array[0];
        int preSum = array[0];
        for (int i = 1; i < array.length; i++) {
            int n = array[i];
            preSum = Math.max(preSum + n, n);
//            max = max > preSum ? max : preSum;
            max = Math.max(max, preSum);
        }
        return max;
    }
}
