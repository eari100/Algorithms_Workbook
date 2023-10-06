package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10451 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for(int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());
            int[] graph = new int[N+1];
            boolean[] visited = new boolean[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cycleCnt = 0;

            for(int j=1;j<=N;j++) {
                graph[j] = Integer.parseInt(st.nextToken());
            }

            for(int j=1;j<=N;j++) {
                if( !visited[j] ) {
                    visited[j] = true;
                    ++cycleCnt;
                    dfs(graph, visited, j);
                }
            }

            result.append(cycleCnt).append('\n');
        }

        br.close();

        System.out.print(result);
    }

    private static void dfs(int[] graph, boolean[] visited, int node) {
        int node2 = graph[node];

        if( !visited[node2] ) {
            visited[node2] = true;
            dfs(graph, visited, node2);
        }
    }
}
