package com.huhusw.middle;

import java.util.LinkedList;
import java.util.Stack;

public class M331 {
    public boolean isValidSerialization(String preorder) {
        //栈空间
        Stack<Integer> stack = new Stack<>();
        //分割字符串
        String[] strings = preorder.split(",");
        //字符串中节点的个数
        int n = strings.length;
        int index = 0;
        //初始条件，为了将第一个节点放入到栈空间，需要初始化为1
        stack.push(1);
        //循环判断
        while (index < n) {
            //栈在循环过程中空了，说明不合题意
            if (stack.isEmpty()) {
                return false;
            }
            //判断节点是否为空，为空需要将栈顶的元素减一，代表以栈顶元素为根节点的树，有一个空子树
            if ("#".equals(strings[index])) {
                int top = stack.pop() - 1;
                //以栈顶元素为根节点的树，还有一个子树的情况，再压入栈
                if (top > 0) {
                    stack.push(top);
                }
            } else {
                //节点不为空，代表以栈顶元素为根节点的树，有一个子树，对应的个数减一，再压入这颗子树
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                //压入子树
                stack.push(2);

            }
            index++;

        }
        //栈为空说明全部弹出，所有的节点都能找到自己的位置，说明是一个合法的序列
        return stack.isEmpty();
    }

    public boolean isValidSerialization2(String preorder) {
        //记录遍历到当前节点时，还有多少个空位需要节点填充，初始时为1，使用根节点填充
        int nodeCount = 1;
        //分割字符串
        String[] strings = preorder.split(",");
        //字符串中节点的个数
        int n = strings.length;
        int index = 0;

        //循环判断
        while (index < n) {
            //循环过程中，没有需要填充的空位说明后面的节点已经不满足题意
            if (nodeCount == 0) {
                return false;
            }
            //判断节点是否为空，为空时，直接填充一个空位
            if ("#".equals(strings[index])) {
                nodeCount -= 1;
            } else {
                //节点不为空，填充一个空位的同时加入了两个空位
                nodeCount += 1;
            }
            index++;

        }
        //遍历完以后，没有需要填充的空位说明是一个合法的序列
        return nodeCount == 0;
    }
}
