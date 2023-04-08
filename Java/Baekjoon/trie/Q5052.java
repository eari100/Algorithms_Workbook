package Baekjoon.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/5052 (전화번호 목록)
 * @classfication: trie
 * @문제 푼 날짜 (자력으로 풂?): 23.04.09(O)
 **/
public class Q5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            TrieNode root = new TrieNode();
            boolean flag = false;

            while(n-- > 0) {
                String str = br.readLine();
                TrieNode node = root;
                int strLen = str.length();

                for(char c : str.toCharArray()) {
                    if(node.next[c - '0'] == null) {
                        node.next[c - '0'] = new TrieNode();
                    }

                    node = node.next[c - '0'];

                    if(!flag && node.isEnd) {
                        result.append("NO").append('\n');
                        flag = true;
                    }

                    if(--strLen == 0) {
                        node.isEnd = true;

                        if(!flag) {
                            for(TrieNode next : node.next) {
                                if(next != null) {
                                    result.append("NO").append('\n');
                                    flag = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            if(!flag) result.append("YES").append('\n');
        }

        br.close();

        System.out.print(result);
    }

    public static class TrieNode {
        boolean isEnd;
        TrieNode[] next = new TrieNode[10];
    }
}
