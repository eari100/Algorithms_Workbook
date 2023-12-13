package Baekjoon.dfs_bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1976 (여행 가자)
 * @classfication: dfs
 * @문제 푼 날짜 (자력으로 풂?): 23.12.14 (O)
 **/
public class Q1976 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] plan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final String YES = "YES";
        final String NO = "NO";

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N];
        visited = new boolean[N+1];

        for(int i=0;i<N;i++) {
            graph[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++) {
                int isConnected = Integer.valueOf(st.nextToken());

                if(isConnected == 1) {
                    graph[i].add(j);
                }
            }
        }

        plan = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            plan[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        br.close();

        visited[plan[0]] = true;
        dfs(plan[0]);

        boolean flag = true;
        for(int p : plan) {
            if( !visited[p] ) {
                flag = false;
                break;
            }
        }

        bw.write(flag ? YES : NO);
        bw.flush();
        bw.close();
    }

    private static void dfs(int curr) {
        for(int next : graph[curr]) {
            if(visited[next]) continue;
            visited[next] = true;

            dfs(next);
        }
    }
}
