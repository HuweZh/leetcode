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
        test t = new test(10, 10);
        queue.offer(t);
        System.out.println("asdhkad");
        t.desc();
        System.out.println("asdhkad");

        System.out.println("***************************************");
        int[] arr = new int[]{9, 3, 5, 1, 2, 6, 4, 8, 6, 4, 1, 5, 6, 32, 68};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    static public void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partion(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index + 1, right);
    }

    private static int partion(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            System.out.println(arr[i] + " " + arr[pivot]);
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    static private void swap(int[] arr, int low, int high) {
        int stem = arr[low];
        arr[low] = arr[high];
        arr[high] = stem;
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
            count -= 11;
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
