package com.huhusw.BY;

import java.util.*;

public class Z03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String word = sc.nextLine();
        word = cal(word);
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            int index = 0;
            int count = 0;
            while (index != word.length() && count != s.length()) {
                if (word.charAt(index) == '$' && index == word.length() - 1) {
                    System.out.println("True");
                    break;
                }
                else if(word.charAt(index) == '$' ){

                }
            }
        }
        sc.close();
    }

    private static String cal(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); ) {
            if (word.charAt(i) != '{' && word.charAt(i) != '}') {
                sb.append(word.charAt(i));
                i++;
                continue;
            }
            if (word.charAt(i) == '{') {
                while (word.charAt(i) != '}') {
                    i++;
                }
                i++;
                sb.append('$');
            }
        }
        return sb.toString();
    }
}
