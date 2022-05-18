package com.huhusw.offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/2a9089ea7e5b474fa8f688eae76bc050
 * 知识竞赛，每一位员工有a b两种能力，选两位员工参加竞赛，x，y分别是两位员工的两种能力的调和平均值
 * 调和平均值的最小值作为能力值，求出能力值的最大值
 * <p>
 * 思路就是按照一个能力升序，另一个能力降序
 * 这样在第一次遇见不一样的升序能力时，对应的第二个能力是最大的，可以直接跳过后面的相同能力值，减少计算
 */
public class ALI202105 {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] abilitys = new int[n][2];
        int index = 0;
        while (index < n) {
            String[] tmp = sc.nextLine().split(" ");
            abilitys[index][0] = Integer.parseInt(tmp[0]);
            abilitys[index][1] = Integer.parseInt(tmp[1]);
            index++;
        }
        //排序，对第一个能力升序，第二个能力降序
        Arrays.sort(abilitys, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }
            }
        });
        //先计算一个预期结果
        double x = (abilitys[0][0] + abilitys[1][0]) / 2.0;
        double y = (abilitys[0][1] + abilitys[1][1]) / 2.0;
        double res = Math.min(x, y);
        //记录不一样的能力第一次出现的位置
        int pre = 1;
        //遍历数组
        for (int i = 2; i < n; i++) {
            //能力值相同，可以直接跳过，因为第一次遇见的一定是最优
            if (abilitys[i][0] == abilitys[pre][0]) {
                continue;
            }
            //第一次遇见不同的能力值，计算一次结果，并更新
            x = (abilitys[i][0] + abilitys[pre][0]) / 2.0;
            y = (abilitys[i][1] + abilitys[pre][1]) / 2.0;
            double t = Math.min(x, y);
            res = Math.max(t, res);
            //更新当前的能力值
            pre = i;
        }
        //结果
        System.out.println(res);
    }
}
