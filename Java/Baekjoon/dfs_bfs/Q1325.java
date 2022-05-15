package Baekjoon.dfs_bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/1325 (효율적인 해킹)
 *@classfication: 단방향 dfs
 **/
public class Q1325 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] score;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        score = new int[N];

        for(int i=0;i<N;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int nextNode = Integer.parseInt(st.nextToken()) - 1;
            int idx = Integer.parseInt(st.nextToken()) - 1;

            graph.get(idx).add(nextNode);
        }
        br.close();

        int max = 0;
        for(int i=0;i<N;i++) {
            visited = new int[N];

            dfs(i);

            int sum = 0;
            for(int s : visited) {
                sum += s;
            }

            score[i] = sum;
            max = Math.max(max, sum);
        }

        for(int i=0;i<score.length;i++) {
            if(max == score[i])
                bw.write(i+1 + " ");
        }

        bw.flush();
        bw.close();
    }

    private static void dfs(int str) {
        visited[str] = 1;

        for(int i : graph.get(str)) {
            if(visited[i]==0) {
                dfs(i);
            }
        }
    }
}
