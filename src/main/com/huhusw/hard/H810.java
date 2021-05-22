package com.huhusw.hard;

/**
 * @author huhusw
 * @Description
 * @create 2021-05-22 10:08
 */
public class H810 {
    //数学证明
    public boolean xorGame(int[] nums) {
        if (nums.length % 2 == 0) {
            return true;
        }
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0;
    }
}
