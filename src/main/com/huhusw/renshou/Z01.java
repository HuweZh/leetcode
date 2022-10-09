package com.huhusw.renshou;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] stem = sc.nextLine().split(",");
        sc.close();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for (int i = 0; i < stem.length; i++) {
            ArrayList<Integer> orDefault = map.getOrDefault(Integer.parseInt(stem[i]), new ArrayList<>());
            orDefault.add(i);
            map.put(Integer.parseInt(stem[i]), orDefault);
        }
        int[] res = new int[stem.length];
        int index = 0;
        int count = 1;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
                res[entry.getValue().get(i)] = count;
            }
            count += 1;
//            if (entry.getValue().size() >= 2) {
//                count += 2;
//            } else {
//                count += 1;
//            }
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            if (i != res.length - 1) {
                System.out.print(",");
            }
        }
    }
}
