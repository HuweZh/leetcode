package com.huhusw;

import java.util.*;

public class MinPQ {
    public static void main(String[] args) {
        MinPQ minPQ = new MinPQ(10);
        minPQ.insert(2);
        minPQ.insert(5);
        minPQ.insert(12);
        minPQ.insert(85);
        minPQ.insert(200);
        minPQ.insert(1);
        minPQ.insert(-1);
        minPQ.insert(0);
        minPQ.insert(20);
        minPQ.insert(50);
        for (int i = 0; i < 10; i++) {
            System.out.println(minPQ.delMin());
        }
    }

    private int[] pq;
    private int size;

    MinPQ(int cap) {
        pq = new int[cap + 1];
        size = 0;
    }

    //父节点
    private int parent(int x) {
        return x / 2;
    }

    //左孩子
    private int left(int x) {
        return 2 * x;
    }

    //右孩子
    private int right(int x) {
        return x * 2 + 1;
    }

    //插入，跳过头结点
    public void insert(int num) {
        size++;
        pq[size] = num;
        swim(size);
    }

    //上浮
    private void swim(int x) {
        while (x != 1 && pq[parent(x)] > pq[x]) {
            swap(parent(x), x);
            x = parent(x);
        }
    }

    //下沉
    private void sink(int x) {
        while (left(x) <= size) {
            int min = left(x);
            if (right(x) <= size && pq[min] > pq[right(x)]) {
                min = right(x);
            }
            if (pq[x] < pq[min]) {
                break;
            }
            swap(x, min);
            x = min;
        }
    }

    //获取最小值
    public int getMin() {
        return pq[1];
    }

    //删除最小值
    public int delMin() {
        int min = pq[1];
        swap(1, size);
        pq[size] = Integer.MAX_VALUE;
        size--;
        sink(1);
        return min;
    }


    //交换元素
    private void swap(int i, int j) {
        int stem = pq[i];
        pq[i] = pq[j];
        pq[j] = stem;
    }

}
