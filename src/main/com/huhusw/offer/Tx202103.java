package com.huhusw.offer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.nowcoder.com/questionTerminal/ba384b491e8a45f2836e5951cd86ba4f
 * 有效序列的数量
 * 规定 一个序列的左右两端为最小值和次小值是有效序列 中间的值要大于等于两端的值
 * 两个数为一个有效序列
 * 找到有个序列中的有效序列数量
 * <p>
 * 单调栈
 * 一个递增的单调栈，大于栈顶元素的值，直接压入，等于栈顶元素时，将值出现的次数加一
 * 其余的情况，弹栈计算
 */


public class Tx202103 {
    /**
     * 定义一个node，存储元素值和连续出现的次数
     */
    static class Node {
        int val;
        int time;

        public Node(int val, int time) {
            this.val = val;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
//        System.out.println(cn2(1000005));
//        System.out.println(cn22(1000005));
        //输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //n个元素
        int n = Integer.parseInt(br.readLine().trim());
        String[] tmp = br.readLine().trim().split(" ");
        if (n < 2) {
            System.out.println(0);
            return;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(tmp[i]);
        }
        //单调栈
        Stack<Node> stack = new Stack<>();
        //结果
        long res = 0;
        //遍历一遍所有元素
        for (int i = 0; i < n; i++) {
            //破坏了单调栈，弹出进行计算
            //也就是当前的元素作为最小或者次小元素，弹栈作为左端元素
            while (!stack.isEmpty() && stack.peek().val > nums[i]) {
                Node topNode = stack.pop();
                //连续的值都能构成有效序列，且不加上当前元素也能构成有效序列，即Cn2种选择
                res += topNode.time + cn2(topNode.time);
            }
            //如果元素相等，time加一
            if (!stack.isEmpty() && stack.peek().val == nums[i]) {
                stack.peek().time++;
            } else {
                //压入一个新节点
                stack.push(new Node(nums[i], 1));
            }
        }
        //弹出栈中的所有元素
        while (!stack.isEmpty()) {
            res += cn2(stack.pop().time);
        }
        //倒序再来一遍，但是不需要加上cn2
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek().val > nums[i]) {
                Node topNode = stack.pop();
                //因为相同的元素已经处理过了，不需要加cn2
                res += topNode.time;
            }
            if (!stack.isEmpty() && stack.peek().val == nums[i]) {
                stack.peek().time++;
            } else {
                stack.push(new Node(nums[i], 1));
            }
        }
        //返回结果
        System.out.println(res);
    }

    /**
     * 不会溢出
     *
     * @param time
     * @return
     */
    public static long cn2(int time) {
        return (long) time * (time - 1) >> 1;
    }

    /**
     * 会溢出
     *
     * @param time
     * @return
     */
    public static long cn22(int time) {
        return (long) (time * (time - 1)) >> 1;
    }

}
