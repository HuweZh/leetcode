package com.huhusw.XINYE;

import java.util.*;
import java.util.List;
import java.util.Scanner;


public class Z02 {

    /**
     * 任务步骤类
     * 【无需改动】
     */
    static class Step {
        //步骤id
        Long stepId;
        //步骤类型
        Long type;
        //动作 commit正向提交 cancel逆向撤销
        String action;

        public Step() {
        }

        public Long getStepId() {
            return stepId;
        }

        public void setStepId(Long stepId) {
            this.stepId = stepId;
        }

        public Long getType() {
            return type;
        }

        public void setType(Long type) {
            this.type = type;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

    }

    /**
     * 将输入的字符串任务步骤转换为步骤类的对象
     * 【无需改动】
     *
     * @param stepStr
     * @return
     */
    private static Step convertToStep(String stepStr) {
        String cleanStep = stepStr.substring(1, stepStr.length() - 1);
        String[] vars = cleanStep.split(",");
        String[] stepIdStr = vars[0].split(":");
        String[] typeStr = vars[1].split(":");
        String[] actionStr = vars[2].split(":");
        Step step = new Step();
        step.setStepId(Long.parseLong(stepIdStr[1]));
        step.setType(Long.parseLong(typeStr[1]));
        step.setAction(actionStr[1]);
        return step;
    }

    /**
     * ACM模式输入输出处理【无需改动】
     *
     * @param args
     */
    public static void main(String[] args) {
        //ACM模式输入
        Scanner in = new Scanner(System.in);
        List<Step> strArr = new ArrayList<>();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            if ("a".equals(s)) {
                break;
            } else {
                strArr.add(convertToStep(s));
            }
        }

        //题目逻辑计算
        long[] res = commitTask(strArr);
        //ACM模式输出
        System.out.println(Arrays.toString(res));
    }

    /**
     * 任务缓存提交
     * 【实现此函数】
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param steps 任务缓存中的步骤列表
     * @return 最后真正提交的数据步骤id数组
     */
    public static long[] commitTask(List<Step> steps) {
        //todo 请实现此函数
        Deque<Step> stack1 = new LinkedList<>();
        Deque<Step> stack2 = new LinkedList<>();
        for (Step s : steps) {
            stack1.add(s);
        }
        while (!stack1.isEmpty()) {
            if (!stack2.isEmpty() && !stack1.isEmpty() && check(stack1.peek(), stack2.peek())) {
                stack1.pop();
                stack2.pop();
            } else {
                stack2.push(stack1.pop());
            }
        }
        long[] res = new long[stack2.size()];
        int count = 0;
        while (!stack2.isEmpty()) {
            res[count++] = stack2.pop().getStepId();
        }
        Arrays.sort(res);
        return res;
    }

    private static boolean check(Step s1, Step s2) {
        if (s1.getType() != s2.getType()) {
            return false;
        }
        if ((("\"commit\"".equals(s1.getAction()) && "\"cancel\"".equals(s2.getAction())) ||
                ("\"commit\"".equals(s2.getAction()) && "\"cancel\"".equals(s1.getAction())))) {
            return true;
        }
        return false;
    }


}