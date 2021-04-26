package com.huhusw.middle;

/**
 * @author huhusw
 * @Description
 * @create 2021-04-26 13:13
 */
public class M1011 {
    public static void main(String[] args) {
        M1011 m1011 = new M1011();

        int i = m1011.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1);
        System.out.println(i);
    }

    //利用贪心加二分查找
    public int shipWithinDays(int[] weights, int D) {
        //保存满足题意的运载能力数字
//        int result = 0x3f3f3f3f;
        //先确定二分查找的左右边界
        //左边界为数组中最大的元素，右边界为数组元素之和
        int right = 0;
        int left = 0;
        for (int weight : weights) {
            if (weight > left) {
                left = weight;
            }
            right += weight;
        }
        //当前的运载能力
        int middle = (right + left) / 2;

        //二分查找
        while (left < right) {
            int day = 1;
            int sumWeight = 0;
            for (int weight : weights) {
                //船上装不下了
                if (sumWeight + weight > middle) {
                    day++;
                    sumWeight = 0;

                }
                sumWeight += weight;
            }
            //运载能力不够
            if (day > D) {
                left = middle + 1;
            }
            //运载能力太强，但是满足题意
            else {
//                result = Math.min(result, middle);
                right = middle;
            }
            middle = (left + right) / 2;
        }

        return left;
    }
}
