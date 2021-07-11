package com.huhusw.middle;

import javafx.util.Pair;

import java.lang.reflect.Parameter;
import java.util.*;

public class M981 {

    public static void main(String[] args) {
        M981.TimeMap timeMap = new M981.TimeMap();
        timeMap.set("1", "1", 1);
        timeMap.set("1", "2", 2);
        timeMap.set("1", "5", 5);
        timeMap.set("1", "3", 3);
        timeMap.set("1", "4", 4);
        timeMap.get("1", 6);
    }

    static class TimeMap {
        class Pair implements Comparable<Pair> {
            String value;
            int timestamp;

            public Pair(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }

            @Override
            public int hashCode() {
                return timestamp + value.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                if (obj instanceof Pair) {
                    Pair pair2 = (Pair) obj;
                    return this.timestamp == pair2.timestamp && this.value.equals(pair2.value);
                }
                return false;
            }

            //默认升序排列
            @Override
            public int compareTo(Pair o) {
                if (this.timestamp != o.timestamp) {
                    return this.timestamp - o.timestamp;
                } else {
                    return this.value.compareTo(o.value);
                }
            }
        }

        Map<String, List<Pair>> map;

        /**
         * Initialize your data structure here.
         */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            List<Pair> pairs = map.getOrDefault(key, new ArrayList<Pair>());
            pairs.add(new Pair(value, timestamp));
            map.put(key, pairs);
        }

        public String get(String key, int timestamp) {
            List<Pair> pairs = map.getOrDefault(key, new ArrayList<>());
            for (Pair p : pairs) {
                System.out.println(p.timestamp + "  " + p.value);
            }
            //使用一个大于所有value的字符串，以确保在pairs中含有timestamp的情况下也返回大于timestamp的位置
            Pair pair = new Pair(String.valueOf((char) 127), timestamp);
            int i = binarySearch(pairs, pair);
            if (i > 0) {
                return pairs.get(i - 1).value;
            }
            return "";
        }

        private int binarySearch(List<Pair> pairs, Pair target) {
            int low = 0, high = pairs.size() - 1;
            if (high < 0 || pairs.get(high).compareTo(target) <= 0) {
                return high + 1;
            }
            while (low < high) {
                int mid = (high - low) / 2 + low;
                Pair pair = pairs.get(mid);
                if (pair.compareTo(target) <= 0) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
}
