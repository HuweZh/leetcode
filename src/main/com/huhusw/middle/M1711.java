package com.huhusw.middle;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.HashMap;
import java.util.Map;

public class M1711 {

    public static void main(String[] args) {
        M1711 m1711 = new M1711();
        int i = m1711.countPairs(new int[]{1,1,1,3,3,3,7});
        System.out.println(i);
    }

    public int countPairs(int[] deliciousness) {
        int maxVal = 0;
        //求出数组中最大的元素
        for (int delicious : deliciousness) {
            maxVal = Math.max(delicious, maxVal);
        }
        //这是大餐之和的最大值
        int maxSum = maxVal * 2;
        int n = deliciousness.length;
        int pairs = 0;
        int MOD = 1000000007;
        //哈希表，记录每个单独的餐品可以使用的数量
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int j = 1; j <= maxSum; j <<= 1) {
                //从hash表中查找可以组成幂的餐品的数量，加到pairs上
                int count = hash.getOrDefault(j - val, 0);
                pairs = (pairs + count) % MOD;
            }
            //该类单独的餐品的数量加1
            hash.put(val, hash.getOrDefault(val, 0) + 1);
        }

        return pairs;
    }
}
