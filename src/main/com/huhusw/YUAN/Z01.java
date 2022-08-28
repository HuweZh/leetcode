package com.huhusw.YUAN;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.*;

public class Z01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(sc.nextLine());
        while (M > 0) {
            M--;
            String[] strings = sc.nextLine().toLowerCase().split(" ");
            String[] words = sc.nextLine().toLowerCase().split(" ");
            Trie trie = new Trie();
            for (int i = 1; i < words.length; i++) {
                trie.insert(words[i]);
            }
            Map<String, Integer> memo = new HashMap<>();
            for (int i = 1; i < strings.length; i++) {
                if (memo.containsKey(strings[i])) {
                    memo.put(strings[i], memo.get(strings[i])+1);
                    continue;
                }
                if (trie.match(strings[i])) {
                    continue;
                }
                memo.put(strings[i], 1);
            }
            int res = 0;
            for (Map.Entry<String, Integer> entry : memo.entrySet()) {
                res = Math.max(res, entry.getValue());
            }
            System.out.println(res);
        }
        sc.close();
    }

    static class Trie {
        Trie[] children;
        boolean isEnd;

        Trie() {
            children = new Trie[27];
            isEnd = false;
        }

        public void insert(String str) {
            str = str.toLowerCase();
            Trie node = this;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '?') {
                    node.children[26] = new Trie();
                    node = node.children[26];
                } else {
                    int index = str.charAt(i) - 'a';
                    node.children[index] = new Trie();
                    node = node.children[index];
                }
            }
            node.isEnd = true;
        }

        public boolean match(String word) {
            Trie node = this;
            word = word.toLowerCase();
            for (int i = 0; i < word.length(); i++) {
                if (node.children[26] != null) {
                    node = node.children[26];
                } else {
                    int index = word.charAt(i) - 'a';
                    if (node.children[index] != null) {
                        node = node.children[index];
                    } else {
                        return false;
                    }
                }
            }
            return node.isEnd;
        }
    }
}
