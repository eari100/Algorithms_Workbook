package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/15651 (N과 M (3))
 * @classfication: backtracking
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.05.28 (O)
 **/
public class Q15651 {
    static StringBuilder sb = new StringBuilder();
    static int[] memo;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memo = new int[M];

        dfs(0);
        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if(depth == M) {
            for(int i : memo) {
                sb.append(i).append(' ');
            }
            sb.append('\n');

            return;
        }

        for(int i=1;i<=N;i++) {
            memo[depth] = i;
            dfs(depth+1);
        }
    }
}
