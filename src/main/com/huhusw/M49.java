package com.huhusw;

import java.util.*;

public class M49 {
    public static void main(String[] args) {
        M49 m49 = new M49();
        List<List<String>> lists = m49.groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    //    排序字符串作为键，对数组中的元素进行分类
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    // 将每个字符串中字母出现的次数组合成键值
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] words = new int[26];
            for (int i = 0; i < str.length(); i++) {
                words[str.charAt(i) - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                stringBuilder.append((char) ('a' + i));
                stringBuilder.append(words[i]);
            }
//            System.out.println(stringBuilder);
            List<String> list = map.getOrDefault(stringBuilder.toString(), new ArrayList<String>());
            list.add(str);
            map.put(stringBuilder.toString(), list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
