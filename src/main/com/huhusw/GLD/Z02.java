package com.huhusw.GLD;

import java.util.*;

public class Z02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        if (n * m < k || k == 1) {
            System.out.println(0);
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int base = 0;
        for (int i = 0; i < n; i++) {
            base += m * m;
            for (int j = 0; j < m; j++) {
                map.put(2 + i * m + j, base);
                base += 1;
            }
            base--;
        }
        base = 0;
        for (int i = 0; i < m; i++) {
            base += n * n;
            for (int j = 0; j < n; j++) {
                int count = map.get(2 + i * n + j);
                map.put(2 + i * n + j, Math.min(count, base));
                base++;
            }
            base--;
        }
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
        System.out.println(map.get(k));
//        int res = 0;
//        int count = 1;
//        while (count != k) {
//            int stem = 0;
//            if (m <= n && count + n <= k) {
//                //长边剪
//                res += n * n;
//                res += n - 1;
//                count += n;
//                m--;
//                continue;
//            } else if (m <= n && count + n > k) {
//                //短边剪
//                res += m * m;
//                n--;
//                stem = m - 1;
//                count++;
//            } else if (m > n && count + m <= k) {
//                //长边剪
//                res += m * m;
//                res += m - 1;
//                count += m;
//                n--;
//                continue;
//            } else if (m > n && count + m > k) {
//                //短边剪
//                res += n * n;
//                m--;
//                stem = n - 1;
//                count++;
//            }
//            while (count != k && stem != 0) {
//                stem--;
//                count++;
//                res++;
//            }
//        }
//        System.out.println(res);
    }
}
/*

72


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
              if (n * m < k || k == 1) {
            System.out.println(0);
            return;
        }
        sc.close();
        int res = 0;
        int count = 1;
        while (count != k) {
            int stem = 0;
            if (m <= n && count + n <= k) {
                res += n * n;
                res += n - 1;
                count += n;
                m--;
                continue;
            } else if (m <= n && count + n > k) {
                res += m * m;
                n--;
                stem = m - 1;
            } else if (m > n && count + m <= k) {
                res += m * m;
                res += m - 1;
                count += m;
                n--;
                continue;
            } else if (m > n && count + m > k) {
                res += n * n;
                m--;
                stem = n - 1;
            }
            count++;
            while (count != k && stem != 0) {
                stem--;
                count++;
                res++;
            }
        }
        System.out.println(res);
    }
}

 */