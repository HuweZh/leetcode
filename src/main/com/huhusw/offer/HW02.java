package com.huhusw.offer;

import java.util.*;

/**
 * https://www.nowcoder.com/test/question/done?tid=56851985&qid=36827#summary
 * 排序，对输入数据进行去重和排序
 * set去重和排序
 *
 * 这个题还可以使用散列表，因为数据规模不大
 */
public class HW02 {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //去重
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        //排序，默认升序
        Set<Integer> treeSet = new TreeSet<>(set);
        Iterator it = treeSet.iterator();
        //输出
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
