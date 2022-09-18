package com.huhusw.BD;

import java.util.*;

public class Z02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            StringBuilder sb = new StringBuilder(s);
            while (true) {
                StringBuilder stem = new StringBuilder(sb);
                sb.delete(0, sb.length());
                boolean flag = false;
                for (int j = 0; j < stem.length(); j++) {
                    if (j + 1 < stem.length() && stem.charAt(j) == stem.charAt(j + 1)) {
                        //啥也不做
                        j++;
                        flag = true;
                    } else if (j + 1 < s.length() && s.charAt(j) != s.charAt(j + 1)) {
                        sb.append(stem.charAt(j));
                    } else {
                        sb.append(stem.charAt(j));
                    }
                }
                if (!flag) {
                    break;
                }
            }
            if (sb.length()%4 == 2) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
        scanner.close();
    }
}
