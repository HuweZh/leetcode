package com.huhusw.middle;

/**
 * @author huhusw
 * @Description
 * @create 2021-05-12 10:34
 */
public class M1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int temp = arr[queries[i][0]];
            for (int j = queries[i][0] + 1; j <= queries[i][1]; j++) {
                temp ^= arr[j];
            }
            result[i] = temp;
        }

        return result;
    }
}
