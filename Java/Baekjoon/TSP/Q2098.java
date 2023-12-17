package Baekjoon.TSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2098 (외판원 순회)
 * @classfication: TSP, dp, bitmask
 * @문제 푼 날짜 (자력으로 풂?): 23.12.17 (X)
 **/
public class Q2098 {
    static int[][] graph, memo;
    static final int INF = 16_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        memo = new int[n][(1<<n)-1];

        for(int[] m: memo)
            Arrays.fill(m, -1);

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        System.out.print(dfs(0, 1));
    }

    private static int dfs(int node, int visited) {
        if(visited == (1<<graph.length)-1) {
            int cost = graph[node][0];
            return cost == 0 ? INF : cost;
        }

        if(memo[node][visited] != -1) {
            return memo[node][visited];
        }

        memo[node][visited] = INF;

        for(int i=0;i<graph.length;i++) {
            if((visited & (1 << i)) == 0 && graph[node][i] != 0) {
                memo[node][visited] = Math.min(memo[node][visited], dfs(i, (visited | (1 << i)))+graph[node][i]);
            }
        }

        return memo[node][visited];
    }
}
