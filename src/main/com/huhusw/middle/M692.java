package com.huhusw.middle;

import com.huhusw.MapValueComparator;

import java.util.*;

/**
 * @author huhusw
 * @Description
 * @create 2021-05-20 13:23
 */
public class M692 {
    public static void main(String[] args) {
        M692 m692 = new M692();
        m692.topKFrequent(new String[]{"a", "aa", "aaa"}, 1);
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> stringIntegerMap = sortMapByValue(map);
        for (Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()) {
            if (k == result.size()) {
                break;
            }
            result.add(entry.getKey());
//            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        return result;

    }

    /**
     * 按map的值排序
     *
     * @return
     */
    public Map<String, Integer> sortMapByValue(Map map) {
        if (map.isEmpty() || map == null) {
            return null;
        }
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, new MapValueComparator());
        Iterator<Map.Entry<String, Integer>> iterator = entryList.iterator();
        Map.Entry<String, Integer> tempEntry = null;
        while (iterator.hasNext()) {
            tempEntry = iterator.next();
            linkedHashMap.put(tempEntry.getKey(), tempEntry.getValue());
        }

        return linkedHashMap;
    }

}

