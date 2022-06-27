package com.huhusw.offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://www.nowcoder.com/test/question/done?tid=57737731&qid=1453774#summary
 * 逛街
 * 小明在逛街，街上有一排大楼，大楼有自己的高度，站在大楼上，可以向前和后去看
 * 问在每一栋大楼时能看到多少栋大楼，被挡住的看不到
 * <p>
 * 模拟，看似寻找单调序列，其实不然，因为要考虑被挡住的情况，直接使用循环会使问题复杂
 * 使用栈来模拟，模拟当前楼的左右两边能看见的楼
 */
public class TX02 {
    public static void main(String[] args) {
        TX02 tx02 = new TX02();
        tx02.findBuilding(new int[]{5, 3, 8, 3, 2, 5});
    }

    /**
     * @param heights int整型一维数组
     * @return int整型一维数组
     */
    public int[] findBuilding(int[] heights) {
        // write code here
        //结果
        int[] res = new int[heights.length];
        //看到自己
        Arrays.fill(res, 1);
        //模拟向左看
        Stack<Integer> leftStack = new Stack<>();
        for (int i = 0; i < heights.length - 1; i++) {
            //当前楼高于栈中保存的左边的楼
            while (!leftStack.isEmpty() && heights[i] >= leftStack.peek()) {
                leftStack.pop();
            }
            //当前楼加入栈
            leftStack.push(heights[i]);
            //在下一栋楼处可以看到栈中的有序的楼的数量，因为一定能看到挨着的楼
            res[i + 1] += leftStack.size();
        }
        //右边看，同理
        Stack<Integer> rightStack = new Stack<>();
        for (int i = heights.length - 1; i > 0; i--) {
            while (!rightStack.isEmpty() && heights[i] >= rightStack.peek()) {
                rightStack.pop();
            }
            rightStack.push(heights[i]);
            res[i - 1] += rightStack.size();
        }
        return res;
    }
}
