package com.huhusw.YUAN;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.*;

public class Z04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(sc.nextLine());
        while (M > 0) {
            M--;
            String[] strings = sc.nextLine().toLowerCase().split(" ");
            String[] words = sc.nextLine().toLowerCase().split(" ");
            Map<String, Integer> memo = new HashMap<>();
            Set<String> set = new HashSet<>();
            for (int i = 1; i < strings.length; i++) {
                if (set.contains(strings[i])) {
                    continue;
                }
                //判断是否为停用词
                for (int j = 1; j < words.length; j++) {
                    if (words[j].length() != strings[i].length()) {
                        continue;
                    }
                    boolean isStop = true;
                    for (int k = 0; k < words[j].length(); k++) {
                        if (words[j].charAt(k) == '?') {
                            continue;
                        }
                        if (words[j].charAt(k) != strings[i].charAt(k)) {
                            isStop = false;
                            break;
                        }
                    }
                    if (isStop) {
                        set.add(strings[i]);
                        break;
                    }
                }
                if (set.contains(strings[i])) {
                    continue;
                }
                if (memo.containsKey(strings[i])) {
                    memo.put(strings[i], memo.get(strings[i]) + 1);
                    continue;
                }
                memo.put(strings[i], 1);
            }
            int res = 0;
            for (Map.Entry<String, Integer> entry : memo.entrySet()) {
                res = Math.max(res, entry.getValue());
            }
            System.out.println(res);
        }
        sc.close();
    }
}
