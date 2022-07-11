package Baekjoon.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/23286 (허들 넘기)
 * @classfication: floyd-warshall 응용
 * @reference: https://littlesam95.tistory.com/93
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.11 (X, 문제를 제대로 이해하고 종이에 진중하게 풀 것)
 **/
public class Q23286 {
    static long INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        INF = 1000000 + 1;

        long[][] graph = new long[N+1][N+1];

        for(int i=1;i<N+1;i++) {
            for(int j=1;j<N+1;j++) {
                if(i==j) continue;
                else graph[i][j] = INF;
            }
        }

        while(--M>-1) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            graph[u][v] = h;
        }

        for(int k=1;k<N+1;k++)
            for(int i=1;i<N+1;i++)
                for(int j=1;j<N+1;j++)
                    graph[i][j] = Math.min(graph[i][j], Math.max(graph[i][k], graph[k][j]));

        StringBuilder result = new StringBuilder();

        while(--T>-1) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            result.append(graph[s][e] < INF ? graph[s][e] : -1).append('\n');
        }
        br.close();

        System.out.print(result);
    }
}
