package com.huhusw.nio;

import java.util.*;

public class MaxQueueImpl implements MaxQueue {
    public Queue<Integer> baseQueue = new LinkedList<>();
    public PriorityQueue<Integer> prioQueue = new PriorityQueue<>(new Comparator<Integer>() {
        public int compare(Integer i1, Integer i2) {
            return i2 - i1;
        }
    });
    public Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        MaxQueueImpl queue = new MaxQueueImpl();
        queue.add(3);
        queue.add(4);
        queue.add(1);
        queue.add(2);
        System.out.println(queue.pollMax());
        System.out.println(queue.poll());
        System.out.println(queue.pollMax());
        System.out.println(queue.poll());
    }

    @Override
    public void add(int v) {
        baseQueue.add(v);
        prioQueue.add(v);
        set.add(v);
    }

    @Override
    public int poll() {
        //队列容量为空
        if (set.isEmpty()) {
            baseQueue.clear();
            prioQueue.clear();
            return -1;
        }
        Integer res = baseQueue.poll();
        while (!set.contains(res)) {
            res = baseQueue.poll();
        }
        set.remove(res);
        return res;
    }

    @Override
    public int pollMax() {
        //队列容量为空
        if (set.isEmpty()) {
            baseQueue.clear();
            prioQueue.clear();
            return -1;
        }
        Integer res = prioQueue.poll();
        while (!set.contains(res)) {
            res = prioQueue.poll();
        }
        set.remove(res);
        return res;
    }
}
