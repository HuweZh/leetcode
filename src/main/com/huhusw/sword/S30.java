package com.huhusw.sword;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * 设计一个最小栈，使得pop push min 的时间复杂度都是O(1)
 * <p>
 * 比较简单的想法就是在每一次push时都将最小值保存起来，并与当前的状态一一对应
 * 怎么使得复杂度为O(1)是一个需要考虑的点
 */
public class S30 {
    public static void main(String[] args) {
        S30 s30 = new S30();
        s30.push(-2);
        s30.push(0);
        s30.push(-1);
        s30.pop();
    }

    /**
     * 现在有两个数据结构，一个保存栈，一个保存最小值
     * 但是优先队列的插入和删除明显不是O(1)的复杂度
     */
    private Stack<Integer> stack;
    private PriorityQueue<Integer> queue;
    //多使用一个栈保存最小值，这样的时间复杂度就是O(1)
    private Stack<Integer> miStack;

    /**
     * initialize your data structure here.
     */
    public S30() {
        stack = new Stack<>();
        queue = new PriorityQueue<>((Integer o1, Integer o2) -> {
            return o1.compareTo(o2);
        });
        miStack = new Stack<>();
        miStack.push(Integer.MAX_VALUE);
    }

    /**
     * 使用优先队列的时间复杂度不是O(1)
     *
     * @param x
     */
    public void push(int x) {
        stack.push(x);
        queue.add(x);
        //保存当前所有元素中的最小值
        miStack.push(Math.min(miStack.peek(), x));
    }

    /**
     * 弹栈时，使用队列时间复杂度为O(n)
     */
//    public void pop() {
//        int pop = stack.pop();
//        System.out.println("pop:" + pop);
//        Iterator<Integer> it = queue.iterator();
//        while (it.hasNext()) {
//            int x = it.next();
//            if (x == pop) {
//                it.remove();
//                break;
//            }
//        }
//    }
    public void pop() {
        stack.pop();
        miStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
//        return queue.peek();
        return miStack.peek();
    }
}
