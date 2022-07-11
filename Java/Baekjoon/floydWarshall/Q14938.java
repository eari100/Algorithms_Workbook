package Baekjoon.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/14938 (서강그라운드)
 * @classfication: floyd-warshall
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.12 (O)
 **/
public class Q14938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] items = new int[n+1];
        int[][] graph = new int[n+1][n+1];
        final int INF = 100 * (n-1) * (n-1) + 1;

        for(int i=1;i<n+1;i++) {
            for(int j=1;j<n+1;j++) {
                if(i==j) continue;
                else graph[i][j] = INF;
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<n+1;i++)
            items[i] = Integer.parseInt(st.nextToken());

        for(int i=0;i<r;i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph[a][b] = graph[b][a] = l;
        }
        br.close();

        floydWarshall(graph);
        System.out.println(findLargestNumberOfItems(graph, items, m));
    }

    private static void floydWarshall(int[][] graph) {
        for(int k=1;k<graph.length;k++)
            for(int i=1;i<graph.length;i++)
                for(int j=1;j<graph.length;j++)
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
    }

    private static int findLargestNumberOfItems(int[][] graph, int[] items, int m) {
        int max = 0;

        for(int i=1;i<graph.length;i++) {
            int itemCnt = 0;

            for(int j=1;j<graph.length;j++) {
                if(graph[i][j] <= m) {
                    itemCnt += items[j];
                }
            }

            max = Math.max(max, itemCnt);
        }

        return max;
    }
}
