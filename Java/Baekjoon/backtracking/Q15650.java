package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/15650 (N과 M (2))
 * @classfication: backtracking
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.05.23 (O)
 **/
public class Q15650 {
    static int[] memo;
    static int N;
    static int M;
    static int depth = -1;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken());
        M  = Integer.parseInt(st.nextToken());
        memo = new int[M];
        br.close();

        for(int i=1;i<=N-M+1;i++) {
            dfs(i);
            --depth;
        }

        System.out.println(sb);
    }

    private static void dfs(int idx) {
        ++depth;
        memo[depth] = idx;
        if(depth == M-1) {
            for(int i : memo) {
                sb.append(i+" ");
            }
            sb.append('\n');
        }

        for(int i=idx+1;i<=N;i++) {
            if(depth+1<M) {
                dfs(i);
                --depth;
            }
        }
    }
}
