package Baekjoon.unionFind;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1976 (여행 가자)
 * @classification: union-find
 * @문제 푼 날짜 (자력으로 풂?): 23.12.14 (X)
 **/
public class Q1976 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final String YES = "YES";
        final String NO = "NO";

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parents = new int[N+1];

        for(int i=1;i<N+1;i++) {
            parents[i] = i;
        }

        for(int i=1;i<N+1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=1;j<N+1;j++) {
                int isConnected = Integer.parseInt(st.nextToken());

                if(isConnected == 1) {
                    union(i, j);
                }
            }
        }

        boolean flag = true;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstCity = find(Integer.parseInt(st.nextToken()));
        for(int i=1;i<M;i++) {
           int otherCity = find(Integer.parseInt(st.nextToken()));

           if(firstCity != otherCity) {
               flag = false;
           }
        }

        br.close();

        bw.write(flag ? YES : NO);
        bw.flush();
        bw.close();
    }

    private static void union(int node1, int node2) {
        if(parents[node1] == parents[node2]) return;

        int root1 = find(node1);
        int root2 = find(node2);

        if(root1 < root2)
            parents[root2] = root1;
        else if(node1 > node2) {
            parents[root1] = root2;
        }
    }

    private static int find(int node) {
        if(parents[node] == node)
            return node;

        return parents[node] = find(parents[node]);
    }
}
