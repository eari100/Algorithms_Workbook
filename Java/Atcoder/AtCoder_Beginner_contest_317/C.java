package Atcoder.AtCoder_Beginner_contest_317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://atcoder.jp/contests/abc317/tasks/abc317_c (C - Remembering the Days)
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 23.08.26 (O)
 **/
// advice: 편향적인 생각을 하지 말 것 (그래프 알고리즘이라고 생각함)
public class C {
    static long longestDist = 0;
    static int[][] graph;
    static int maxNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int dist = Integer.parseInt(st.nextToken());

            graph[str][end] = dist;
            graph[end][str] = dist;
        }

        br.close();

        for(int i=0;i<N;i++) {
            boolean[] visited = new boolean[N];
            visited[i] = true;
            dfs(0, 0, i, visited);
        }

        System.out.println(longestDist);
    }

    private static void dfs(int depth, long sumDist, int node, boolean[] visited) {
        if(maxNode < depth) {
            maxNode = depth;
            longestDist = sumDist;
        } else if(maxNode == depth) {
            longestDist = Math.max(longestDist, sumDist);
        }

        for(int i=0;i<graph.length;i++) {
            if(visited[i]) continue;
            if(graph[node][i] == 0) continue;

            visited[i] = true;
            dfs(depth+1, sumDist+graph[node][i], i, visited);
            visited[i] = false;
        }
    }
}
