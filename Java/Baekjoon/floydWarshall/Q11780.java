package Baekjoon.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/11780 (플로이드 2)
 * @classfication: floyd-warshall + 경로 복원
 * @reference: https://youtu.be/dDDy2bEZRA8?t=765
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.10 (X)
 **/
public class Q11780 {
    static int INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        INF = 100000 * (n-1) * (n-1) + 1;
        int[][] graph = new int[n+1][n+1];
        int[][] next = new int[n+1][n+1];

        for(int i=1;i<graph.length;i++) {
            for(int j=1;j<graph.length;j++) {
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = INF;
            }
        }

        StringTokenizer st;
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(graph[a][b] > d) {
                graph[a][b] = d;
                next[a][b] = b;
            }
        }
        br.close();

        for(int k=1;k<graph.length;k++) {
            for(int i=1;i<graph.length;i++) {
                for(int j=1;j<graph.length;j++) {
                    if(graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        StringBuilder result1 = new StringBuilder();
        for(int i=1;i<graph.length;i++) {
            for(int j=1;j<graph.length;j++) {
                result1.append(graph[i][j] < INF ? graph[i][j] : 0).append(' ');
            }
            result1.append('\n');
        }

        System.out.print(result1);

        StringBuilder result2 = new StringBuilder();
        for(int i=1;i<next.length;i++) {
            for(int j=1;j<next.length;j++) {
                int cityCnt = 0;
                StringBuilder cities = new StringBuilder();
                int nextNode = next[i][j];

                if(nextNode != 0) {
                    cities.append(i).append(' ');
                    ++cityCnt;
                }

                while(nextNode != 0) {
                    cities.append(nextNode).append(' ');
                    nextNode = next[nextNode][j];
                    ++cityCnt;
                }

                result2.append(cityCnt).append(' ').append(cityCnt == 0 ? "" : cities).append('\n');
            }
        }

        System.out.print(result2);
    }
}
