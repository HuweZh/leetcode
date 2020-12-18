package com.huhusw;

public class M738 {
    public static void main(String[] args) {
        M738 m738 = new M738();
        int i = m738.monotoneIncreasingDigits(233432);
    }

    public int monotoneIncreasingDigits(int N) {
        //转为字符数组
        char[] strN = Integer.toString(N).toCharArray();
        // 记录第一个降序位置的索引
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i++;
        }
        if (i < strN.length) {
            // 往前迭代进行判断
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1]--;
                i--;
            }
            // 后面的补9
            for (i += 1; i < strN.length; i++) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}
