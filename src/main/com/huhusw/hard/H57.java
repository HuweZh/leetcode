package com.huhusw.hard;

import java.util.Comparator;
import java.util.Stack;

/**
 * @Author huhusw
 * @Date 2020/11/4
 */
public class H57 {

    public static void main(String[] args) {
        H57 h57 = new H57();
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] insert = h57.insert(intervals, newInterval);
        System.out.println(insert);
    }

//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        int[][] result = new int[intervals.length][2];
//
//        // 将新区间加进去先
//        for (int i = 0; i < intervals.length; i++) {
//            // 没有交集
//            if (intervals[i][0] > newInterval[1] || intervals[i][1] < newInterval[0]) {
//
//            } else {
//                // 有交集
//                intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
//                intervals[i][1] = Math.max(intervals[i][1], newInterval[1]);
//                break;
//            }
//        }
//        while (true) {
//            boolean innerFlag = true;
//            // 合并区间
//            for (int i = 1; i < intervals.length - 1; i++) {
//                // 向前合并
//                if (intervals[i][0] <= intervals[i - 1][1]) {
//                    intervals[i][0] = Math.min(intervals[i - 1][0], intervals[i][0]);
//                    intervals[i - 1][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
//                    innerFlag = false;
//                }
//                // 向后合并
//                if (intervals[i][1] >= intervals[i + 1][0]) {
//                    intervals[i + 1][0] = Math.min(intervals[i][0], intervals[i + 1][0]);
//                    intervals[i][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
//                    innerFlag = false;
//                }
//            }
//
//            if (innerFlag) {
//                break;
//            }
//        }
//        return intervals;
//    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < intervals.length; i++) {
            // 没有重叠曲线
            if (intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1]) {
                stack.push(intervals[i]);
            } else {
                // 有重叠就更新区间
                newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            }
        }
        stack.push(newInterval);
        int[][] result = new int[stack.size()][2];
        stack.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int size = stack.size();
        for(int i = 0; i < size; i++){
            result[size-i-1] = stack.pop();
        }
        return result;
    }
}
