package com.huhusw.WY;

import java.util.*;

public class Z03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        sc.close();
        int eSum = (string.length() - 1) / 2;
        int common = eSum - 1;
        int rCount = 0;
        int dCount = 0;
        int eCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'r') {
                rCount++;
            } else if (string.charAt(i) == 'e') {
                eCount++;
            } else {
                dCount++;
            }
        }
        int res = Math.abs(eSum - eCount);
        res += Math.abs((rCount + dCount) - (string.length() - eSum));
        System.out.println(res);
        //0 r   1 e  2 d
//        Map<Character, Integer> memo = new HashMap<>();
//        memo.put('r', 0);
//        memo.put('e', 1);
//        memo.put('d', 2);
//        int[][] dp = new int[string.length()][3];
//        for (int i = 0; i < string.length(); i++) {
//            if (i < 2) {
//                dp[i][memo.get(string.charAt(i))] = 1;
//                continue;
//            }
//            if (string.charAt(i) == 'r') {
//                dp[i][0] = dp[i - 2][2] + dp[i - 1][1];
//                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + 1;
//                dp[i][2] = dp[i - 2][0] + dp[i - 1][1] + 1;
//            } else if (string.charAt(i) == 'e') {
//                dp[i][0] = dp[i - 2][2] + dp[i - 1][1] + 1;
//                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
//                dp[i][2] = dp[i - 2][0] + dp[i - 1][1] + 1;
//            } else {
//                dp[i][0] = dp[i - 2][2] + dp[i - 1][1] + 1;
//                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
//                dp[i][2] = dp[i - 2][0] + dp[i - 1][1];
//            }
//        }
//        System.out.println(Math.min(dp[string.length() - 1][0], Math.min(dp[string.length() - 1][1], dp[string.length() - 1][2])));
    }
}
/*



import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        sc.close();
        //0 r   1 e  2 d
        Map<Character, Integer> memo = new HashMap<>();
        memo.put('r', 0);
        memo.put('e', 1);
        memo.put('d', 2);
        int[][] dp = new int[string.length()][3];
        for (int i = 0; i < string.length(); i++) {
            if (i < 2) {
                dp[i][memo.get(string.charAt(i))] = 1;
                continue;
            }
            if (string.charAt(i) == 'r') {
                dp[i][0] = dp[i - 2][2] + dp[i - 1][1];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + 1;
                dp[i][2] = dp[i - 2][0] + dp[i - 1][1] + 1;
            } else if (string.charAt(i) == 'e') {
                dp[i][0] = dp[i - 2][2] + dp[i - 1][1] + 1;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = dp[i - 2][0] + dp[i - 1][1] + 1;
            } else {
                dp[i][0] = dp[i - 2][2] + dp[i - 1][1] + 1;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = dp[i - 2][0] + dp[i - 1][1];
            }
        }
        System.out.println(Math.min(dp[string.length()-1][0],Math.min(dp[string.length()-1][1],dp[string.length()-1][2])));
    }
}


*/
