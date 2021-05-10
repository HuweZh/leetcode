package com.huhusw.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huhusw
 * @Description
 * @create 2021-04-30 10:18
 */
public class M137 {
    public int singleNumber(int[] nums) {
        //使用Map存储数组中的元素，数组元素为键，元素个数为值
        Map<Integer, Integer> numbers = new HashMap<>();
        //遍历数组赋值于map
        for (int num : nums) {
            if (numbers.containsKey(num)) {
                int temp = numbers.get(num);
                numbers.put(num, temp + 1);
            } else {
                numbers.put(num, 1);
            }
        }
        //遍历map 找到符合题意的元素
        for (Map.Entry<Integer, Integer> entry:numbers.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 0;
    }
}
