package com.huhusw;

import java.util.Random;

/**
 * 生成随机练习题目
 */
public class SelfTest {
    public static void main(String[] args) {
        String[] root = new String[]{
                "基础篇", "JVM篇", "多线程&并发篇", "Spring篇", "Mybatis篇", "SpringBoot篇",
                "MySql篇", "SpringCloud篇", "Dubbo篇", "Nginx篇", "MQ篇", "数据机构和算法篇",
                "Linux篇", "Zookeeper篇", "Redis篇", "分布式篇", "网络篇", "设计模式", "Maven",
                "ElasticSearch篇", "tomcat篇", "Git篇"
        };
        int[] sub = new int[]{
                45, 33, 46, 23, 14, 14, 34, 14, 10, 8, 8, 1, 5, 35, 42, 22, 28, 13, 11, 22, 12, 26
        };
        Random random = new Random();
        for(int j = 0; j < 10; j++){
            int i = random.nextInt(root.length);

            System.out.print(root[i]);
            System.out.println(" " + (1 + random.nextInt(sub[i])));
        }
    }
}
