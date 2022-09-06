package com.huhusw;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.*;

/**
 * 索引为0的不用
 * 这样就能快速判断左右孩子和父节点
 */
public class MaxPQ {

    public static void main(String[] args) {
        MaxPQ maxPQ = new MaxPQ(10);
        maxPQ.insert(2);
        maxPQ.insert(5);
        maxPQ.insert(12);
        maxPQ.insert(85);
        maxPQ.insert(200);
        maxPQ.insert(1);
        maxPQ.insert(-1);
        maxPQ.insert(0);
        maxPQ.insert(20);
        maxPQ.insert(50);
        for (int i = 0; i < 10; i++) {
            System.out.println(maxPQ.delMax());
        }
    }

    private int[] pq;
    private int size;

    MaxPQ(int cap) {
        pq = new int[cap + 1];
        size = 0;
    }

    //父亲
    public int parent(int x) {
        return x / 2;
    }

    //左孩子
    public int left(int x) {
        return 2 * x;
    }

    //右孩子
    public int right(int x) {
        return 2 * x + 1;
    }

    //插入，跳过第一个节点
    public void insert(int num) {
        size++;
        pq[size] = num;
        //上浮至正确的位置
        swim(size);
    }

    //下沉
    private void sink(int x) {
        //下沉到最底部
        while (left(x) <= size) {
            //先让其等于左孩子
            int max = left(x);
            //左孩子小于右孩子
            if (right(x) <= size && pq[right(x)] > pq[max]) {
                max = right(x);
            }
            //当前节点大于两个孩子，不用下沉了
            if (pq[x] > pq[max]) {
                break;
            }
            swap(x, max);
            x = max;
        }
    }

    //上浮
    private void swim(int x) {
        //上浮至顶端，如果parent小于孩子，换上去，并更新x
        while (x != 1 && pq[parent(x)] < pq[x]) {
            swap(parent(x), x);
            x = parent(x);
        }
    }

    //获取最大值
    public int getMax() {
        return pq[1];
    }

    //删除最大值
    public int delMax() {
        int stem = pq[1];
        //将最大值删去，然后换最后一个元素上来，并将最后一个元素设置为空
        swap(1, size);
        pq[size] = Integer.MIN_VALUE;
        size--;
        //将索引为1的元素下沉到正确位置
        sink(1);
        return stem;
    }


    private void swap(int i, int j) {
        int stem = pq[i];
        pq[i] = pq[j];
        pq[j] = stem;
    }
}
