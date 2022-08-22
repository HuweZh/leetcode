package com.huhusw.LEN;

import java.util.*;

public class Z02 {
    static Queue<String> res = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Trie trie = new Trie();
        while (n > 0) {
            n--;
            String[] strings = scanner.nextLine().split(" ");
            for (String s : strings) {
                insert(s, trie);
            }
        }
        scanner.close();
        dfs(trie);

        int sum = 0;
        while (!res.isEmpty()) {
            if (sum + res.peek().length() > 50) {
                System.out.println();
                sum = 0;
            }
            sum += res.peek().length()+1;

            System.out.print(res.poll() + " ");
        }
    }

    static public void dfs(Trie trie) {
        if (trie.str != null) {
            res.offer(trie.str);
        }
        for (int i = 0; i < 26; i++) {
            if (trie.children[i] != null) {
                dfs(trie.children[i]);
            }
        }
    }

    static public void insert(String s, Trie trie) {
        Trie node = trie;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.str = s;
    }

    static class Trie {
        Trie[] children;
        String str;

        Trie() {
            children = new Trie[26];
            str = null;
        }


    }
}
