package com.huhusw.YZF;

import java.util.*;

/**
 * 贪心即可，动规超时
 */
public class Z02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            T--;
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (n <= 2) {
                System.out.println(Math.min(a, b));
                continue;
            }
            long res = 0;
            int minMon = Math.min(a, b);
            int diff = minMon == a ? 2 : 3;
            long dp1 = Math.min(a, b);
            long dp2 = Math.min(a, b);
            long dp3 = 0;
            for (int i = 3; i <= n; i++) {
                res = min(dp1 + minMon, dp2 + minMon, dp3 + b);
                dp3 = dp2;
                dp2 = dp1;
                dp1 = res;
                if (res == dp1 + minMon) {
                    i += diff;
                    for (int j = 0; j < diff; j++) {
                        dp3 = dp2;
                        dp2 = dp1;
                        dp1 = res;
                    }
                } else if (res == dp2 + minMon) {
                    i += diff - 1;
                    for (int j = 0; j < diff - 1; j++) {
                        dp3 = dp2;
                        dp2 = dp1;
                        dp1 = res;
                    }
                } else {
                    i++;
                }
            }
            System.out.println(res);
        }
        scanner.close();
    }

    private static long min(long i, long i1, long i2) {
        return Math.min(i, Math.min(i1, i2));
    }
}
/*


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            T--;
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (n <= 2) {
                System.out.println(Math.min(a, b));
                continue;
            }
            long res = 0;
            int minMon = Math.min(a, b);
            long dp1 = Math.min(a, b);
            long dp2 = Math.min(a, b);
            long dp3 = 0;
            for (int i = 3; i <= n; i++) {
                res = min(dp1 + minMon, dp2 + minMon, dp3 + b);
                dp3 = dp2;
                dp2 = dp1;
                dp1 = res;
            }
            System.out.println(res);
        }
        scanner.close();
    }

    private static long min(long i, long i1, long i2) {
        return Math.min(i, Math.min(i1, i2));
    }
}

 */