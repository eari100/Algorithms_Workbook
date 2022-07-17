package Baekjoon.floydWarshall;

import java.io.*;

/**
 * @source: https://www.acmicpc.net/problem/15723 (n단 논법)
 * @classfication: floyd-warshall
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.16 (O, 힌트 사용)
 **/
public class Q15723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] graph = new boolean[26][26];

        for(int i=0;i<26;i++)
            for(int j=0;j<26;j++)
                if(i==j) graph[i][j] = true;

        for(int i=0;i<n;i++) {
            String[] arr = br.readLine().split(" is ");
            char c1 = arr[0].charAt(0);
            char c2 = arr[1].charAt(0);

            graph[(int) c1 - 97][(int) c2 - 97] = true;
        }

        floydWarshall(graph);

        int m = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        for(int i=0;i<m;i++) {
            String[] arr = br.readLine().split(" is ");
            char c1 = arr[0].charAt(0);
            char c2 = arr[1].charAt(0);

            result.append(graph[(int) c1 - 97][(int) c2 - 97] ? 'T' : 'F').append('\n');
        }

        br.close();

        System.out.print(result);
}

    private static void floydWarshall(boolean[][] graph) {
        for(int k=0;k<graph.length;k++)
            for(int i=0;i<graph.length;i++)
                for(int j=0;j<graph.length;j++)
                    if(graph[i][k] && graph[k][j]) graph[i][j] = true;
    }
}
