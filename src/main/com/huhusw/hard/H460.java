package com.huhusw.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class H460 {
    public static void main(String[] args) {
        H460 h460 = new H460(3);
        h460.put(1, 1);
        h460.put(2, 2);
        h460.put(3, 3);
        h460.put(4, 4);
        System.out.println(h460.get(4));
        System.out.println(h460.get(3));
        System.out.println(h460.get(2));
        System.out.println(h460.get(1));
        h460.put(5, 5);
        System.out.println(h460.get(1));
        System.out.println(h460.get(2));
        System.out.println(h460.get(3));
        System.out.println(h460.get(4));
        System.out.println(h460.get(5));
    }

    private Map<Integer, ValueStatus> map;
    Queue<ValueStatus> queue;
    int time = 0;
    int capacity;

    public H460(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity, 1);
        queue = new PriorityQueue<>(capacity);
    }

    public int get(int key) {
        time++;
        if (capacity == 0) {
            return -1;
        }
        ValueStatus res = map.get(key);
        if (res != null) {
            queue.remove(res);
            res.countIncre(time);
            map.put(key, res);
            queue.add(res);
            return res.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        //该key已经存在，说明队列中也存在这个key，所以要先弹出去
        if (map.containsKey(key)) {
            queue.remove(map.get(key));
        }
        //达到容量时，弹出一个元素，再进行添加
        else if (map.size() == capacity) {
            ValueStatus poll = queue.poll();
            map.remove(poll.key);
        }
        ValueStatus valueStatus = new ValueStatus(key, value, time++, 1);
        map.put(key, valueStatus);
        queue.add(valueStatus);
    }


    class ValueStatus implements Comparable {
        int key;
        int val;
        int time;
        int count;

        ValueStatus(int key, int val, int time, int count) {
            this.key = key;
            this.val = val;
            this.time = time;
            this.count = count;
        }

        public void countIncre(int time) {
            count += 1;
            this.time = time;
        }

        @Override
        public int compareTo(Object o) {
//            System.out.println(o instanceof ValueStatus);
//            System.out.println(o instanceof LFUCache);
            ValueStatus o1 = (ValueStatus) o;
            if (count < o1.count || (count == o1.count && time < o1.time)) {
                return -1;
            } else if (count > o1.count || (count == o1.count && time > o1.time)) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
