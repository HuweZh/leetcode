package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/can-make-palindrome-from-substring/
 * 构建回文串检测
 * <p>
 * 给一个查询，查询在区间内重新排列字符，且最多替换k个字符后，是否能构成回文串
 * 查询的格式[left,right,k]，查询的区间为[left,right]
 * 这个题目需要统计区间内的字母的个数，偶数不用管，重新排列后一定能消去
 * 奇数字符个数为0或者1个，那么就是一个回文串
 * 所以现在的目标是找到区间内的奇数字符的个数
 * 使用前缀和
 * 这里只需要找到奇偶性，并不要求具体的个数，所以用一个位代表奇偶，
 * 那么区间的奇偶就是两端奇偶的亦或
 * 统计区间内的奇数个数，判断是否小于等于2*k+1即可，因为最多可以改变k个字符，所以有2*k字符能被消除，最后剩下一个或零个
 */
public class M1177 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        //前缀和
        int[] arr = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            //统计[0,i]区间内的奇偶性
            arr[i + 1] = arr[i] ^ (1 << (s.charAt(i) - 'a'));
        }
        //遍历所有的查询
        List<Boolean> res = new ArrayList<>();
        for (int[] stem : queries) {
            //区间内的奇偶性
            int v = arr[stem[1] + 1] ^ arr[stem[0]];
            //统计奇数字符的个数
            int count = Integer.bitCount(v);
            //添加结果
            res.add(count <= (2 * stem[2] + 1));
        }
        return res;
    }
}
