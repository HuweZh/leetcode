package com.huhusw;

import java.util.PriorityQueue;

/**
 * @author huhusw
 * @Description
 * @create 2021-05-20 13:36
 */
public class Test {
    public static void main(String[] args) {
        PriorityQueue<test> queue = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.offer(new test(i, i));
        }
        test t = new test(10,10);
        queue.offer(t);
        System.out.println("asdhkad");
        t.desc();
        System.out.println("asdhkad");
    }

    static class test implements Comparable {
        int count;
        int num;

        test(int count, int num) {
            this.count = count;
            this.num = num;
        }

        public void incre() {
            count++;
        }

        public void desc() {
            count-=11;
        }

        @Override
        public int compareTo(Object o) {
            if (count < ((test) o).count || (count == ((test) o).count && num == ((test) o).num)) {
                return -1;
            } else if (count > ((test) o).count) {
                return 1;
            } else {
                return 0;
            }

        }
    }
}
