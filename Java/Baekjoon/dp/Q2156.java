package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/2156 (포도주 시식)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 23.11.28 (O)
 **/
public class Q2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n+3];

        for(int i=3;i<n+3;i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int[] dp = new int[n+3];

        // dp[n] = max(dp[n-2] + wine[n], dp[n-1], dp[n-3] + wine[n-1] + wine[n])
        for(int i=3;i<wines.length;i++) {
            int y1 = dp[i-2] + wines[i];
            int y2 = dp[i-1];
            int y3 = dp[i-3] + wines[i-1] + wines[i];

            dp[i] = Math.max(y1, Math.max(y2, y3));
        }

        System.out.print(dp[dp.length - 1]);
    }
}
