package Baekjoon.floydWarshall;

import java.io.*;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/14938 (역사)
 * @classfication: floyd-warshall
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.16 (O, 힌트 사용)
 **/
public class Q1613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n+1][n+1];

        while(--k > -1) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = -1;
            graph[b][a] = 1;
        }

        floydWarshall(graph);

        int s = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        while(--s > -1) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            result.append(graph[a][b]).append('\n');
        }

        br.close();

        System.out.print(result);
    }

    private static void floydWarshall(int[][] graph) {
        for(int k=0;k<graph.length;k++)
            for(int i=0;i<graph.length;i++)
                for(int j=0;j<graph.length;j++)
                    if(graph[i][k]==-1 && graph[k][j]==-1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
    }
}
