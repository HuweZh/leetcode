package com.huhusw.XINYE;

import javafx.util.Pair;

import java.lang.annotation.Target;
import java.util.*;
import java.util.stream.*;
import java.util.Scanner;


public class Z03 {

    /**
     * 任务类
     * 【无需改动】
     */
    static class Task {
        //任务id
        Long taskId;
        //货柜名称
        String counterName;
        //配送任务类型=子任务类型之和
        Long taskType;

        public Task() {
        }

        public Long getTaskId() {
            return taskId;
        }

        public void setTaskId(Long taskId) {
            this.taskId = taskId;
        }

        public Long getTaskType() {
            return taskType;
        }

        public void setTaskType(Long taskType) {
            this.taskType = taskType;
        }

        public String getCounterName() {
            return counterName;
        }

        public void setCounterName(String counterName) {
            this.counterName = counterName;
        }
    }

    /**
     * 将输入的字符串任务转换为任务类的对象
     * 【无需改动】
     *
     * @param taskStr
     * @return
     */
    private static Task convertToTask(String taskStr) {
        String cleanTask = taskStr.substring(1, taskStr.length() - 1);
        String[] vars = cleanTask.split(",");
        String[] nameStr = vars[0].split(":");
        String[] taskIdStr = vars[1].split(":");
        String[] typeStr = vars[2].split(":");
        Task task = new Task();
        task.setCounterName(nameStr[1]);
        task.setTaskId(Long.parseLong(taskIdStr[1]));
        task.setTaskType(Long.parseLong(typeStr[1]));
        return task;
    }

    /**
     * ACM模式输入输出处理【无需改动】
     *
     * @param args
     */
    public static void main(String[] args) {
        //ACM模式输入
        Scanner in = new Scanner(System.in);
        List<Task> strArr = new ArrayList<>();
        int i = 0;
        int k = 0;
        while (in.hasNext()) {
            if (i == 0) {
                k = Integer.parseInt(in.nextLine());
            } else {
                String s = in.nextLine();
                if ("a".equals(s)) {
                    break;
                } else {
                    strArr.add(convertToTask(s));
                }
            }
            i++;
        }

        //题目逻辑计算
        int[] res = planTasks(strArr, k);
        //ACM模式输出
        System.out.println(Arrays.toString(res));
    }

    /**
     * 任务规划评估
     * <p>
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param tasks 要规划的任务列表
     * @param k     间隔的天数
     * @return 一个数组a[], 比如[10,2,3] a[0]即10为做完最少的天数， a[1]即2为空闲的天数，a[2]即3为2k天内完成的校期子任务数量，
     */
    static HashMap<String, Integer> map = new HashMap<>();
    static int time = 0;
    static int K;

    public static int[] planTasks(List<Task> tasks, int k) {
        //todo 请实现此函数
        K = k;

        PriorityQueue<Pair<Task, Integer>> queue1 = new PriorityQueue<Pair<Task, Integer>>((a, b) -> {
            return b.getValue() - a.getValue();
        });
        Queue<Pair<Task, Integer>> queue2 = new LinkedList<>();

        for (Task t : tasks) {
            int num = (int) ((t.getTaskType() >> 1) & 1);
            queue1.add(new Pair<>(t, num));
        }
        int count = 0;
        int free = 0;
        while (!queue1.isEmpty()) {
            boolean flag = false;
            while (!queue1.isEmpty() && !flag) {
                Pair<Task, Integer> p = queue1.poll();
                if (check(p)) {
                    map.put(p.getKey().getCounterName(), time);
                    if (time <= 2 * k) {
                        count += p.getValue();
                    }
                    flag = true;
                } else {
                    queue2.add(p);
                }
            }
            if (!flag) {
                free++;
            }
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
            time++;
        }
        return new int[]{time, free
                , count};
    }

    private static boolean check(Pair<Task, Integer> p) {
        if (!map.containsKey(p.getKey().getCounterName())) {
            return true;
        } else if (time - map.get(p.getKey().getCounterName()) > K) {
            return true;
        }
        return false;
    }

}