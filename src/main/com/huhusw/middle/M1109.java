package com.huhusw.middle;

public class M1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            for (int j = bookings[i][0] - 1; j < bookings[i][1]; j++) {
                res[j] += bookings[i][2];
            }
        }

        return res;
    }

    //差分数组
    public int[] corpFlightBookings1(int[][] bookings, int n) {
        int[] res = new int[n];

        //求差分数组
        for (int i = 0; i < bookings.length; i++) {
            res[bookings[i][0]-1] += bookings[i][2];
            if (bookings[i][1] != n) {
                res[bookings[i][1]] -= bookings[i][2];
            }
        }
        //还原数组
        for (int i = 1; i < n; i++) {
            res[i] += res[i - 1];
        }

        return res;
    }
}
