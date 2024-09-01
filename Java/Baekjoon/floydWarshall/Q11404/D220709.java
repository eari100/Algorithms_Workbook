package Baekjoon.floydWarshall.Q11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/11404 (플로이드)
 * @classification: floyd-warshall
 * @reference: https://youtu.be/dDDy2bEZRA8?list=PLtqbFd2VIQv4O6D6l9HcD732hdrnYb6CY&t=426
 * @문제 푼 날짜 (자력으로 풂?): 22.07.09 (X)
 **/
public class D220709 {
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] graph = new int[n+1][n+1];

        for(int i=1;i<n+1;i++) {
            for(int j=1;j<n+1;j++) {
                graph[i][j] = INF;

                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        StringTokenizer st;
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[A][B] = Math.min(graph[A][B], d);
        }
        br.close();

        for(int k=1;k<n+1;k++) {
            for(int i=1;i<n+1;i++) {
                for(int j=1;j<n+1;j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<n+1;j++) {
                result.append(graph[i][j] < INF ? graph[i][j] : 0).append(' ');
            }
            result.append('\n');
        }

        System.out.print(result);
    }
}
