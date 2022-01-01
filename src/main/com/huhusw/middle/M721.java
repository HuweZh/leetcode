package com.huhusw.middle;

import java.util.*;

/**
 * 合并账户，每条记录中有一个账户名和邮箱，根据邮箱合并账户
 */
public class M721 {
    /**
     * 根据邮箱合并账户，accounts[0]为账户名称，后面的为其邮箱列表
     * 相同邮箱代表是相同的用户
     *
     * @param accounts 账号列表
     * @return 合并后的账户列表
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //两个hash表存储邮箱对应的姓名和序号
        Map<String, Integer> mapToIndex = new HashMap<>();
        Map<String, String> mapToName = new HashMap<>();
        int emailCount = 0;
        //初始化hash表
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String firstEmail = acc.get(i);
                if (!mapToIndex.containsKey(firstEmail)) {
                    mapToName.put(firstEmail, name);
                    mapToIndex.put(firstEmail, emailCount++);
                }
            }
        }
        //新建并查集类
        UF uf = new UF(emailCount);
        //根据账号列表进行账户的合并
        for (List<String> acc : accounts) {
            String firstEmail = acc.get(1);
            int firstIndex = mapToIndex.get(firstEmail);
            //将相同账户下的邮箱合并到一起
            for (int i = 2; i < acc.size(); i++) {
                uf.union(firstIndex, mapToIndex.get(acc.get(i)));
            }
        }
        //hash表，存储邮箱编号对应的邮箱列表
        //并查集中搜索祖先节点
        //使用祖先节点的序号作为键，将不同的邮箱加到列表中
        Map<Integer, List<String>> indexToList = new HashMap<>();
        for (String email : mapToIndex.keySet()) {
            //祖先节点
            int rootIndex = uf.find(mapToIndex.get(email));
            //获取祖先节点对应的列表
            List<String> emails = indexToList.getOrDefault(rootIndex, new ArrayList<String>());
            //将邮箱加进去
            emails.add(email);
            //存入hash表
            indexToList.put(rootIndex, emails);
        }
        //构造结果
        List<List<String>> res = new ArrayList<>();
        //提取出所有的列表，排序，再加上名称即为题目要求
        for (List<String> emails : indexToList.values()) {
            Collections.sort(emails);
            String name = mapToName.get(emails.get(0));
            List<String> stem = new ArrayList<>();
            stem.add(name);
            stem.addAll(emails);
            res.add(stem);
        }
        //返回
        return res;
    }

    /**
     * 并查集类
     */
    class UF {
        private int[] parent;
        private int[] size;

        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) {
                return;
            }
            if (size[rootI] > size[rootJ]) {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
            } else {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            }
        }

        public int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
    }
}
