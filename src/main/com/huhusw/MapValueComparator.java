package com.huhusw;

import java.util.Comparator;
import java.util.Map;

/**
 * @author huhusw
 * @Description
 * @create 2021-05-20 13:43
 */
public class MapValueComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        //按照值的降序排列
        if (o1.getValue() != o2.getValue()) {
            return o2.getValue() - o1.getValue();
        } else {
            int length = Math.min(o1.getKey().length(), o2.getKey().length());
            for (int i = 0; i < length; i++) {
                if (o1.getKey().charAt(i) != o2.getKey().charAt(i)) {
                    return o1.getKey().charAt(i) - o2.getKey().charAt(i);
                }
            }
            //按照键的升序排列
            if (length == o1.getKey().length()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}