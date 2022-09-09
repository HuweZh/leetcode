package com.huhusw.simple;

import java.util.*;

public class S1598 {
    public int minOperations(String[] logs) {
        Deque<String> stack = new LinkedList<>();
        for (String log : logs) {
            if ("../".equals(log) && !stack.isEmpty()) {
                stack.pollLast();
            } else if ("./".equals(log) || ("../".equals(log) && stack.isEmpty())) {

            } else {
                stack.addLast(log);
            }
        }
        return stack.size();
    }
}
