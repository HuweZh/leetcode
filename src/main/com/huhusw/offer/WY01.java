package com.huhusw.offer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/test/question/done?tid=57507654&qid=1262897#summary
 * 项目经理
 * <p>
 * A和B两家公司派人负责项目，每个员工可以负责多个项目，每个项目只能由一个员工负责
 * 求最少需要的员工个数
 * <p>
 * 利用二分图的最大匹配数就是本题要求的最小点覆盖数
 * 匈牙利算法
 */
public class WY01 {
    //B公司中员工与A公司的匹配关系
    static int[] match;
    //B公司的员工是否被使用
    static boolean[] used;
    //边集合，题目输入，ab员工共同负责一个项目则为1
    static int[][] map;

    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        String[] sa = sc.nextLine().split(" ");
        String[] sb = sc.nextLine().split(" ");
        int[] A = new int[sa.length];
        int[] B = new int[sb.length];
        int a = 0;
        int b = 0;
        int maxA = 0;
        int maxB = 0;
        for (String ssa : sa) {
            A[a] = Integer.parseInt(ssa);
            maxA = Math.max(maxA, A[a]);
            a++;
        }
        for (String ssb : sb) {
            B[b] = Integer.parseInt(ssb);
            maxB = Math.max(maxB, B[b]);
            b++;
        }
        //初始化三个变量
        match = new int[maxB + 1];
        used = new boolean[maxB + 1];
        map = new int[maxA + 1][maxB + 1];
        int n = sc.nextInt();
        //记录边
        for (int i = 0; i < n; i++) {
            int aIndex = sc.nextInt();
            int bIndex = sc.nextInt();
            map[aIndex][bIndex] = 1;
        }
        //求最大覆盖数
        System.out.println(solve(A, B));
        sc.close();
    }

    /**
     * 求由A和B组成的二分图的最大匹配数
     *
     * @param A
     * @param B
     * @return
     */
    static int solve(int[] A, int[] B) {
        //初始时，A和B之间没有关联
        Arrays.fill(match, -1);
        //结果
        int res = 0;
        //遍历A集合
        for (int a : A) {
            //初始化B为未使用，因为每一个a都可能与每一个b相连
            Arrays.fill(used, false);
            //在B中找与a可以构成的边
            if (find(B, a)) {
                res++;
            }
        }
        return res;
    }

    /**
     * B公司中是否有与A公司index号员工直接或者间接相连的员工
     * @param B
     * @param index
     * @return
     */
    static boolean find(int[] B, int index) {
        //遍历b
        for (int b : B) {
            //之间有边且未使用过，使用过的直接抛弃
            if (map[index][b] == 1 && !used[b]) {
                //修改状态
                used[b] = true;
                //此时这个b员工没有对a进行匹配，或者匹配过，那就对匹配后的再进行查找一遍
                if (match[b] == -1 || find(B, match[b])) {
                    //修改状态
                    match[b] = index;
                    return true;
                }
            }
        }
        return false;
    }
}
