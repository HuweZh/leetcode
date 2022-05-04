package com.huhusw.sword;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 * 获取数据流中的中位数
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 */
public class S41 {
    /**
     * 思路是
     * 利用两个堆，一个最大堆存储较小部分的数据，一个最小堆存储较大部分的数据
     * 保证堆的元素个数最大差值为1
     * 总元素个数为偶数时，两个堆高度相等，否则最大堆大
     */
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public S41() {
        //大顶堆
        max = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        //小顶堆
        min = new PriorityQueue<>();
    }

    /**
     * 插入一个元素
     * @param num 元素
     */
    public void addNum(int num) {
        //当前是偶数个元素，插入一个变为奇数，让他插入到大顶堆中
        if (max.size() == min.size()) {
            //要保证大顶堆的数据是较小部分的，所以需要先去小顶堆排序，再插入
            min.add(num);
            max.add(min.poll());
        } else {
            //当前元素个数不相等，插入小顶堆，同样先排序，再插入
            max.add(num);
            min.add(max.poll());
        }
    }

    /**
     * 找到中位数
     * @return 中位数
     */
    public double findMedian() {
        //元素个数为偶数，顶元素的和为中位数
        if (max.size() == min.size()) {
            return (max.peek() + min.peek()) / 2.0;
        } else {
            //大顶堆为中位数
            return max.peek();
        }
    }
}
