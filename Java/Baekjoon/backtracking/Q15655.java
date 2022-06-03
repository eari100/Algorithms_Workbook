package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/15655 (N과 M (6))
 * @classfication: backtracking
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.06.03 (O)
 **/
public class Q15655 {
    static int N;
    static int M;
    static int[] arr;
    static int[] memo;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        memo = new int[M];

        st = new StringTokenizer(br.readLine());
        br.close();

        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        dfs(-1, 0);
        System.out.print(sb);
    }

    private static void dfs(int str, int w) {
        if(w == M) {
            for(int i : memo)
                sb.append(i).append(' ');

            sb.append('\n');
            return;
        }

        for(int i=str+1;i<N;i++) {
            memo[w] = arr[i];
            dfs(i, w+1);
        }
    }
}
