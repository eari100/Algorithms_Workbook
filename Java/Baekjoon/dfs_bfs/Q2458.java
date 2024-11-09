package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2458 (키 순서)
 * @classification: dfs
 * @문제 푼 날짜 (자력으로 풂?): 24.11.08 (O)
 **/
// todo: 플로이드 와샬로 변경해볼 것
public class Q2458 {
    static boolean[][] graph;
    static int connect;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int answer = 0;

        graph = new boolean[n][n];

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;

            graph[a][b] = true;
        }

        for(int i=0;i<n;i++) {
            connect = 0;
            dfs1(i, new boolean[n]);
            dfs2(i, new boolean[n]);

            if(connect == n - 1) {
                ++answer;
            }
        }

        System.out.print(answer);
    }

    private static void dfs1(int curr, boolean[] visited) {
        for(int i=0;i<graph[curr].length;i++) {
            if(graph[curr][i] && !visited[i]) {
                visited[i] = true;
                ++connect;
                dfs1(i, visited);
            }
        }
    }

    private static void dfs2(int curr, boolean[] visited) {
        for(int i=0;i<visited.length;i++) {
            if(graph[i][curr] && !visited[i]) {
                visited[i] = true;
                ++connect;
                dfs2(i, visited);
            }
        }
    }
}
