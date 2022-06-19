package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/25214 (크림 파스타)
 * @classfication: dp
 * @reference: https://burningfalls.github.io/algorithm/boj-25214/
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.19 (X)
 **/
public class Q25214 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1;i<N+1;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        br.close();

        int min = Integer.MAX_VALUE;
        for(int i=1;i<N+1;i++) {
            min = Math.min(min, arr[i]);
            dp[i] = Math.max(dp[i-1], arr[i] - min);
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<N+1;i++)
            sb.append(dp[i]).append(' ');

        System.out.print(sb);
    }
}
