package com.huhusw;

public class M134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;  //结果
        int n = gas.length;
        while (index < n) {
            int sumOfGas = 0;
            int sumOfCost = 0;
            int count = 0;  //记录走过的站点数
            while (count < n) {
                int j = (index + count) % n;//环形
                sumOfCost += cost[j];
                sumOfGas += gas[j];
                //油不够
                if (sumOfGas < sumOfCost) {
                    break;
                }
                //油够到下一个加油站，记录此站点
                count++;
            }
            // 能绕一圈
            if (count == n) {
                return index;
            } else {
                // 从下一个站点开始检查
                index = index + count + 1;
            }
        }
        // 都不满足
        return -1;
    }

    public static void main(String[] args) {

    }
}
