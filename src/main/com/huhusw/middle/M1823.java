package com.huhusw.middle;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 * 约瑟夫环
 */
public class M1823 {
    /**
     * 每次数到k的小伙伴淘汰，找出胜利者
     *
     * @param n n个小伙伴，1~n
     * @param k 计数淘汰
     * @return 胜利者
     */
    public int findTheWinner(int n, int k) {
        //当前的序号
        int cur = 0;
        //定义一个数组存储小伙伴的状态，1表示还在游戏，0表示淘汰
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        //游戏次数，要淘汰n-1个，模拟时需要n-1次游戏
        int count = 1;
        //每次游戏的计数
        int sum = 0;
        //循环n-1次
        while (count != n) {
            //预处理一遍数据，防止数据过大
            int order = 0;
            if (k == n) {
                order = k;
            } else {
                order = k % n;
            }
            //本次游戏
            while (true) {
                //计数
                sum += nums[cur];
                //游戏是否结束
                if (sum == order) {
                    sum = 0;
                    break;
                }
                //往下循环，并重置
                cur++;
                if (cur == n) {
                    cur = 0;
                }
            }
            //标志淘汰
            nums[cur] = 0;
            //游戏次数更新
            count++;
        }
        //找到胜利者
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                res = i;
                break;
            }
        }
        return res + 1;
    }
}
