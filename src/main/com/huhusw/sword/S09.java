package com.huhusw.sword;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 用两个栈模拟队列
 */
public class S09 {
    /**
     * 用两个栈模拟队列，实现队尾增加元素，队头删除元素
     */
    class CQueue {
        //队尾插入，用于保存队尾插入的元素
        Stack<Integer> inStack;
        //队头删除，用于删除队头的元素
        Stack<Integer> outStack;

        /**
         * 构造器
         */
        public CQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        /**
         * 队尾插入元素
         *
         * @param value 元素值
         */
        public void appendTail(int value) {
            inStack.push(value);
        }

        /**
         * 队头删除元素
         * 其中outStack中的元素一定是早于inStack中的元素
         * 所以在outStack中还有元素的时候，不用进行数据的迁移工作
         *
         * @return
         */
        public int deleteHead() {
            //队头中有元素，直接删除
            if (!outStack.isEmpty()) {
                return outStack.pop();
            }
            //将队尾的元素压入栈
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            //判断队列是否为空
            return outStack.isEmpty() ? -1 : outStack.pop();
        }
    }

}
