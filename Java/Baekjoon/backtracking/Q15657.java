package Baekjoon.backtracking;

import java.util.*;
import java.io.*;

/**
 * @source: https://www.acmicpc.net/problem/15657 (N과 M (8))
 * @classfication: backtracking
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.06.07 (O)
 **/
public class Q15657 {
    static int[] arr;
    static int[] memo;
    static StringBuilder sb;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        memo = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(arr);
        dfs(0, 0);

        System.out.print(sb);
    }

    private static void dfs(int depth, int str) {
        if(depth == M) {
            for(int i : memo)
                sb.append(i).append(' ');

            sb.append('\n');

            return;
        }

        for(int i=str;i<N;i++) {
            memo[depth] = arr[i];
            dfs(depth+1, i);
        }
    }
}
