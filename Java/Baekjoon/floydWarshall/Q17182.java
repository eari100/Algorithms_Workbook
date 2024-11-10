package Baekjoon.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/17182 (우주 탐사선)
 * @classfication: floyd-warshall
 * @문제 푼 날짜 (자력으로 풂?): 24.11.11 (O)
 **/
public class Q17182 {
    static boolean[] visited;
    static int time;
    static int[][] floyd_warshall;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][n];
        floyd_warshall = new int[n][n];

        final int INF = (n-1) * 1000 + 1;

        time = INF;

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i==j) continue;

                floyd_warshall[i][j] = INF;
            }
        }

        visited = new boolean[n];
        visited[k] = true;

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<n;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                for(int l=0;l<n;l++) {
                    floyd_warshall[j][l] = Math.min(floyd_warshall[j][l], graph[j][i] + graph[i][l]);
                }
            }
        }

        dfs(k, 0, 0);

        System.out.print(time);
    }

    private static void dfs(int curr, int depth, int t) {
        if(depth == floyd_warshall[0].length - 1) {
            time = Math.min(time, t);
            return;
        }

        for(int next=0;next<floyd_warshall[curr].length;next++) {
            if(visited[next] || next == curr) continue;

            visited[next] = true;
            dfs(next, depth+1, t + floyd_warshall[curr][next]);
            visited[next] = false;
        }
    }
}
