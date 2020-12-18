package com.huhusw;

import java.util.Arrays;
import java.util.Comparator;

public class S493 {

    public static void main(String[] args) {
        S493 s493 = new S493();
        int i = s493.reversePairs(new int[]{-5,-5});
        System.out.println(i);
    }

    public int reversePairs(int[] nums) {
        int result = 0;
        int[][] stem = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            stem[i][0] = nums[i];
            stem[i][1] = i;
        }
        // 逆序，首先根据元素大小排序，元素大小相等根据索引排序索引越大越靠前
        Arrays.sort(stem, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0] || (o1[0] == o2[0] && o1[1] < o2[1])) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
//        for(int i= 0; i<nums.length; i++){
//            System.out.print(stem[i][0]);
//            System.out.print("   ");
//            System.out.println(stem[i][1]);
//        }
        int indexCount = 0;     //内层循环符合的个数
        boolean flag = false;   //内层循环大小判断合适
        for (int i = 0; i < nums.length; i++) {
//            //剪枝
//            if (indexCount != 0 && i > 0 && stem[i][0] == stem[i - 1][0]) {
//                result += indexCount;
//            }
            indexCount = 0;
            flag = false;
            long stem1 = stem[i][0];
            for (int j = i + 1; j < nums.length; j++) {
                long stem2 = 0;
                if (!flag) {
                    stem2 = stem[j][0];
                }
                //只需要判断索引顺序即可
                if (flag && stem[i][1] < stem[j][1]) {
                    result++;
                    indexCount++;
                }
                if (!flag && stem[i][1] < stem[j][1] && stem1 > (2 * stem2)) {
                    result++;
                    indexCount++;
                    //后面的数大小都合适
                    flag = true;
                }
            }
        }
        return result;
    }
}
