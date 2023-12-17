package Baekjoon.TSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/10971 (외판원 순회 2)
 * @classfication: TSP, backtracking
 * @문제 푼 날짜 (자력으로 풂?): 23.12.17 (O)
 **/
public class Q10971 {
    static int[][] graph;
    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        for(int i=0;i<graph.length;i++) {
            boolean[] visited = new boolean[n];
            dfs(1, 0, i, i, visited);
        }

        System.out.print(minDist);
    }

    private static void dfs(int depth, int dist, int strNode, int node, boolean[] visited) {
        if(depth < graph.length) {
            for(int i=0;i<graph[node].length;i++) {
                if(visited[i] || i == strNode) continue;
                int dist2 = graph[node][i];
                if(dist2 == 0) continue;

                visited[i] = true;
                dfs(depth+1, dist+dist2, strNode, i, visited);
                visited[i] = false;
            }
        } else {
            int dist2 = graph[node][strNode];

            if(dist2 == 0) return;

            dist += dist2;
            minDist = Math.min(minDist, dist);
            return;
        }
    }
}
