package com.huhusw;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author huhusw
 * @Date 2020/11/6
 */
public class S1356 {

    public static void main(String[] args) {
        S1356 s1356 = new S1356();

        int[] ints = s1356.sortByBits(new int[]{0,1,2,3,4,5,6,7,8});

        System.out.println(ints);
    }

    public int[] sortByBits(int[] arr) {
        int[][] stem = new int[arr.length][2];
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            stem[i][0] = arr[i];
            int temp = 0;
            while (arr[i] != 0) {
                temp += (arr[i] & 0x1);
                // 逻辑右移
                arr[i] = arr[i] >>> 1;
            }
            stem[i][1] = temp;
        }

        Arrays.sort(stem, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]){
                    return o1[1]-o2[1];
                }
                else{
                    return o1[0]-o2[0];
                }
            }
        });

        //System.out.println(stem);

        for (int i = 0; i < arr.length; i++) {
            result[i] = stem[i][0];
        }
        return result;
    }
}
