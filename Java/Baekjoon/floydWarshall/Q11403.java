package Baekjoon.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/11403 (경로 찾기)
 *@classfication: floyd-warshall
 **/
public class Q11403 {
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for(int i=0;i<graph.length;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<graph.length;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        floydWarshall();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<graph.length;i++) {
            for(int j=0;j<graph.length;j++) {
                sb.append(graph[i][j]+" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static void floydWarshall() {
        for(int k=0;k<graph.length;k++) {
            for(int i=0;i<graph.length;i++) {
                for(int j=0;j<graph.length;j++) {
                    // g(i,j) = g(i,k) && g(k,j)
                    if(graph[i][k] == 1 && graph[k][j] == 1)
                        graph[i][j] = 1;
                }
            }
        }
    }
}
