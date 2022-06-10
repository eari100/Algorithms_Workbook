package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/15664 (N과 M (10))
 * @classfication: backtracking
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.06.10 (O)
 **/
public class Q15664 {
    static int N;
    static int M;
    static int[] arr;
    static int[] memo;
    static StringBuilder sb;

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

    private static void dfs(int str, int depth) {
        if(depth == M) {
            for(int i : memo)
                sb.append(i).append(' ');

            sb.append('\n');

            return;
        }

        int temp = 0;

        for(int i=str;i<N;i++) {
            if(temp != arr[i]) {
                temp = arr[i];
                memo[depth] = arr[i];
                dfs(i+1, depth+1);
            }
        }
    }
}
