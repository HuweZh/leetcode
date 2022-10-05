package com.huhusw.middle;

import java.util.*;

/**
 * https://leetcode.cn/problems/subdomain-visit-count/
 * 子域名访问计数
 * <p>
 * 统计计算域名访问的次数
 * 使用hash表存储已经访问过的域名
 */
public class M811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        sc.close();
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            String[] stem = s.split(" ");
            int num = Integer.parseInt(stem[0]);
            int index = -1;
            while (index < stem[1].length()) {
                String ss = stem[1].substring(index + 1, stem[1].length());
                int sum = map.getOrDefault(ss, 0);
                map.put(ss, sum + num);
                index++;
                while (index < stem[1].length() && stem[1].charAt(index) != '.') {
                    index++;
                }
            }
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getValue());
            sb.append(" ");
            sb.append(entry.getKey());
            res.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return res;
    }
}
