package Baekjoon.backtracking;

import java.io.*;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/15654 (N과 M (5))
 * @classfication: backtracking
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.06.01 (X, visited 아이디어를 못 떠올림)
 **/
public class Q15654 {
    static int[] arr;
    static int N;
    static int M;
    static int[] memo;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        memo = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
        }

        Arrays.sort(arr);
        br.close();

        int[] memo = new int[M];
        dfs(0);

        bw.write(sb.toString());
        bw.close();
    }

    private static void dfs(int depth) {
        if(depth == M) {
            for(int i : memo)
                sb.append(i).append(' ');

            sb.append('\n');
            return;
        }

        for(int i=0;i<N;i++) {
            if(visited[i]) continue;

            memo[depth] = arr[i];

            visited[i] = true;
            dfs(depth+1);
            visited[i] = false;
        }
    }
}
