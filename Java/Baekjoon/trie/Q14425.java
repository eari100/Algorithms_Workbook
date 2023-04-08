package Baekjoon.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/14425 (문자열 집합)
 * @classfication: trie
 * @문제 푼 날짜 (자력으로 풂?): 23.04.09(X)
 **/
public class Q14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node root = new Node();

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            Node node = root;
            int strLen = str.length();

            for(char c : str.toCharArray()) {
                if( node.nextNode[c - 'a'] == null ) {
                    node.nextNode[c - 'a'] = new Node();
                }

                node = node.nextNode[c - 'a'];

                if(--strLen == 0) {
                    node.isEnd = true;
                }
            }
        }

        for(int i=0;i<M;i++) {
            String str = br.readLine();
            Node node = root;
            int strLen = str.length();

            for(char c : str.toCharArray()) {
                if(node.nextNode[c - 'a'] == null) break;

                node = node.nextNode[c - 'a'];

                if(--strLen == 0 && node.isEnd) {
                    ++result;
                }
            }
        }

        System.out.print(result);
    }

    public static class Node {
        Node[] nextNode = new Node[26];
        boolean isEnd;
    }
}
