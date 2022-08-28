package com.huhusw.WYHY;

import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T > 0) {
            T--;
            String[] nums = sc.nextLine().split(" ");
            int n = Integer.parseInt(nums[0]);
            int m = Integer.parseInt(nums[1]);
            char[][] flowers = new char[n][n];
            for (int i = 0; i < n; i++) {
                flowers[i] = sc.nextLine().toCharArray();
            }
            if (T != 0)
                sc.nextLine();
            int count = 1;
            while ((m - count * n) / 2 >= n) {
                count++;
            }
            int diff = (m - count * n) / 2;
            char[][] res = new char[m][m];
            int row = 0;
            int col = 0;
            //上左
            for (int i = n - diff; i < n; i++) {
                for (int j = n - diff; j < n; j++) {
                    res[row][col] = flowers[i][j];
                    col++;
//                    if (col == diff) {
//
//                    }
                }
                col = 0;
                row++;
            }
            //上中
            row = 0;
            col = diff;
            for (int i = 0; i < count; i++) {
                int stemDiff = col;
                for (int j = n - diff; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        res[row][col] = flowers[j][k];
                        col++;
                    }
                    row++;
                    col = stemDiff;
                }
                row = 0;
                col = diff + (i + 1) * n;
            }
            //上右
            row = 0;
            col = diff + count * n;
            for (int i = n - diff; i < n; i++) {
                for (int j = 0; j < diff; j++) {
                    res[row][col] = flowers[i][j];
                    col++;
                }
                col = diff + count * n;
                row++;
            }
            //左中
            col = 0;
            row = diff;
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = n - diff; k < n; k++) {
                        res[row][col] = flowers[j][k];
                        col++;
                    }
                    col = 0;
                    row++;
                }
            }
            //右中
            col = diff + count * n;
            row = diff;
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < diff; k++) {
                        res[row][col] = flowers[j][k];
                        col++;
                    }
                    col = diff + count * n;
                    row++;
                }
            }
            //下左
            row = diff + count * n;
            col = 0;
            for (int i = 0; i < diff; i++) {
                for (int j = n - diff; j < n; j++) {
                    res[row][col] = flowers[i][j];
                    col++;
                }
                col = 0;
                row++;
            }
            //下右
            row = diff + count * n;
            col = diff + count * n;
            for (int i = 0; i < diff; i++) {
                for (int j = 0; j < diff; j++) {
                    res[row][col] = flowers[i][j];
                    col++;
                }
                col = diff + count * n;
                row++;
            }
            //下中
            row = diff + count * n;
            col = diff;
            for (int i = 0; i < count; i++) {
                int stemDiff = col;
                for (int j = 0; j < diff; j++) {
                    for (int k = 0; k < n; k++) {
                        char c = flowers[j][k];
                        res[row][col] = c;
                        col++;
                    }
                    row++;
                    col = stemDiff;
                }
                row = diff + count * n;
                col = diff + (i + 1) * n;
            }
            //中间
            col = diff;
            row = diff;
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < count * n; k++) {
                        res[row][col] = flowers[j][k % n];
                        col++;
                    }
                    row++;
                    col = diff;
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(res[i][j]);
                }
                System.out.println();
            }
            if (T != 0)
                System.out.println();
            System.out.println(":asdada");
        }
        sc.close();
    }
}
/*
1
3 10
1x1
xox
1x1
 */

/*
1
5 19
13S31
LMcML
Sc2cS
LKcKL
13S31
        */
