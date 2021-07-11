package com.huhusw.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huhusw
 * @Description
 * @create 2021-06-21 10:13
 */
public class S401 {
    //计算小时和分钟的1的个数，相加为turnedOn为答案
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + (m < 10 ? ":0" : ":") + m);
                }
            }
        }
        return ans;
    }
}
