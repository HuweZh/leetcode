package com.huhusw.middle;

import java.util.LinkedList;
import java.util.Queue;

public class M649 {

    public static void main(String[] args) {
        M649 m649 = new M649();
        System.out.println(m649.predictPartyVictory("RDD"));
    }

    public String predictPartyVictory(String senate) {
        Queue<Integer> dire = new LinkedList<>();
        Queue<Integer> radiant = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if ('D' == senate.charAt(i)) {
//                System.out.println("R");
                dire.offer(i);
            }
            if ('R' == senate.charAt(i)) {
//                System.out.println("D");
                radiant.add(i);
            }
        }
        int length = senate.length();
        while (!(dire.isEmpty() || radiant.isEmpty())) {
            int direIndex = dire.poll();
            int radiIndex = radiant.poll();
            if (direIndex < radiIndex) {
                dire.add(length++);
            } else {
                radiant.add(length++);
            }
        }
        if (!dire.isEmpty()) {
            return "Dire";
        } else {
            return "Radiant";
        }
//        int dNumber = 0;
//        int rNumber = 0;
//        for (int i = 0; i < senate.length(); i++) {
//            if ("D".equals(senate.charAt(i))) {
//                dNumber++;
//            }
//            if ("R".equals(senate.charAt(i))) {
//                rNumber++;
//            }
//        }
//        if ("D".equals(senate.charAt(0))) {
//            dNumber++;
//        } else {
//            rNumber++;
//        }
//        if (rNumber > dNumber) {
//            return "Radiant";
//        } else if (rNumber == dNumber) {
//            return "D".equals(senate.charAt(0)) ? "Dire" : "Radiant";
//        } else {
//            return "Dire";
//        }
    }
}
