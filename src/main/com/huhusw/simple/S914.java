package com.huhusw.simple;

import java.util.*;

/**
 * https://leetcode.cn/problems/x-of-a-kind-in-a-deck-of-cards/
 * 卡牌分组
 * 每组卡牌的数量一致且都相等
 * 思路就是求所有卡牌的最大公约数，最大公约数大于等于2满足题意
 */
public class S914 {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int d : deck) {
            if (!map.containsKey(d)) {
                map.put(d, 1);
            } else {
                map.put(d, map.get(d) + 1);
            }
        }
        int g = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (g == -1) {
                g = entry.getValue();
            } else {
                g = gcd(g, entry.getValue());
            }
        }
        return g >= 2;
    }

    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
